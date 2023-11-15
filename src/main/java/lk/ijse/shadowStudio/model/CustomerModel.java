package lk.ijse.shadowStudio.model;

import lk.ijse.shadowStudio.db.DbConnection;
import lk.ijse.shadowStudio.dto.CustomerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerModel {
    public static boolean saveCustomer(CustomerDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO customer VALUES(?, ?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getCustomerId());
        pstm.setString(2, dto.getCustomerName());
        pstm.setString(3, dto.getCustomerNic());
        pstm.setString(4, dto.getCustomerTp());
        pstm.setString(5, dto.getDescription());

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }

    public static boolean deleteCustomer(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "delete from customer where cus_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, id);

        return pstm.executeUpdate() > 0;
    }

    public static boolean updateCustomer(CustomerDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "update customer set cus_name = ?, cus_nic = ?, cus_tp = ?, decription = ? where cus_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);


        pstm.setString(1, dto.getCustomerName());
        pstm.setString(2, dto.getCustomerNic());
        pstm.setString(3, dto.getCustomerTp());
        pstm.setString(4, dto.getDescription());
        pstm.setString(5, dto.getCustomerId());

        return pstm.executeUpdate() > 0;
    }



    public CustomerDto searchCustomer(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "select * from customer where cus_id=?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, id);

        ResultSet resultSet = pstm.executeQuery();

        CustomerDto dto = null;

        if(resultSet.next()) {
            String cus_id = resultSet.getString(1);
            String cus_name = resultSet.getString(2);
            String cus_nic = resultSet.getString(3);
            String cus_tp = resultSet.getString(4);
            String description = resultSet.getString(5);

            dto = new CustomerDto(cus_id, cus_name, cus_nic, cus_tp, description);
        }
        return dto;
    }

    public List<CustomerDto> getAllCustomer() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "select * from customer";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();



        ArrayList<CustomerDto> dtoList = new ArrayList<>();
        while (rs.next()) {
            dtoList.add(
                    new CustomerDto(
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
