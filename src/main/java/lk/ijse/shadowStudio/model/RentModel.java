package lk.ijse.shadowStudio.model;

import lk.ijse.shadowStudio.db.DbConnection;
import lk.ijse.shadowStudio.dto.ComplainDto;
import lk.ijse.shadowStudio.dto.RentDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentModel {
    public static String generateNextRentId() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT rentId FROM rent ORDER BY rentId DESC LIMIT 1";
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();
        if(resultSet.next()) {
            return splitRentId(resultSet.getString(1));
        }
        return splitRentId(null);
    }
    private static String splitRentId(String currentRentId) {
        if(currentRentId != null) {
            String[] split = currentRentId.split("R0");

            int id = Integer.parseInt(split[1]); //01
            id++;
            return "R00" + id;
        } else {
            return "R001";
        }
    }

    public static boolean saveRent(RentDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO rent VALUES(?,?,?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getRentId());
        pstm.setString(2,dto.getCustId());
        pstm.setString(3,dto.getCustName());
        pstm.setString(4,dto.getItemId());
        pstm.setString(5,dto.getItemName());
        pstm.setString(6,dto.getDaycount());
        pstm.setString(7,dto.getDate());



        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;


    }

    public List<RentDto> getAllRent() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "select * from rent";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();



        ArrayList<RentDto> dtoList = new ArrayList<>();
        while (rs.next()) {
            dtoList.add(
                    new RentDto(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7)
                    )
            );
        }
        return dtoList;

    }
}
