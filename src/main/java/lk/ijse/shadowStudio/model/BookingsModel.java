package lk.ijse.shadowStudio.model;

import lk.ijse.shadowStudio.db.DbConnection;
import lk.ijse.shadowStudio.dto.CustomerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingsModel {
    public static String generateNextBookingId() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT booking_id FROM bookings ORDER BY booking_id DESC LIMIT 1";
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();
        if(resultSet.next()) {
            return splitBookingId(resultSet.getString(1));
        }
        return splitBookingId(null);
    }
    private static String splitBookingId(String currentBookingId) {
        if(currentBookingId != null) {
            String[] split = currentBookingId.split("B0");

            int id = Integer.parseInt(split[1]); //01
            id++;
            return "B00" + id;
        } else {
            return "B001";
        }
    }

}
