package lk.ijse.shadowStudio.model;

import lk.ijse.shadowStudio.db.DbConnection;
import lk.ijse.shadowStudio.dto.EmployeeDto;
import lk.ijse.shadowStudio.dto.ItemDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentItemModel {
    public static String generateNextItemId() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT itemId FROM item ORDER BY itemId DESC LIMIT 1";
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();
        if(resultSet.next()) {
            return splitItemId(resultSet.getString(1));
        }
        return splitItemId(null);
    }
    private static String splitItemId(String currentItemId) {
        if (currentItemId != null) {
            String[] split = currentItemId.split("I0");

            int id = Integer.parseInt(split[1]); //01
            id++;
            return "I00" + id;
        } else {
            return "I001";
        }
    }


    public static boolean saveItem(ItemDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO item VALUES(?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getItemId());
        pstm.setString(2,dto.getItemName());
        pstm.setString(3,dto.getItemType());
        pstm.setString(4,dto.getRentalPrice());


        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;

    }
    public List<ItemDto> getAllItem() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "select * from item";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();



        ArrayList<ItemDto> dtoList = new ArrayList<>();
        while (rs.next()) {
            dtoList.add(
                    new ItemDto(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4)
                    )
            );
        }
        return dtoList;

    }
}
