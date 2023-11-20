package lk.ijse.shadowStudio.model;

import lk.ijse.shadowStudio.db.DbConnection;
import lk.ijse.shadowStudio.dto.CustomerDto;
import lk.ijse.shadowStudio.dto.PackageDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PackagesModel {
    public static String generateNextPackageId() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT package_id FROM packages ORDER BY package_id LIMIT 1";
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()){
            return splitPackageId(resultSet.getString(1));

        }

        return splitPackageId(null);
    }
    private static String splitPackageId(String currentPackageId){
        if(currentPackageId != null) {
            String[] split = currentPackageId.split("P0");

            int id = Integer.parseInt(split[1]); //01
            id++;
            return "P00" + id;
        } else {
            return "P001";
        }
    }

    public static boolean savePackage(PackageDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO packages VALUES(?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getPackage_id());
        pstm.setString(2,dto.getPackage_name());
        pstm.setString(3,dto.getPackage_type());
        pstm.setString(4,dto.getPackage_description());
        pstm.setString(5,dto.getPackage_price());

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }
    public List<PackageDto> getAllPackages() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "select * from packages";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();

        ArrayList<PackageDto> dtoList = new ArrayList<>();
        while (rs.next()) {
            dtoList.add(
                    new PackageDto(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5)
                    )
            );
        }
        return dtoList;

    }
}
