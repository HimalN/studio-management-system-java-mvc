package lk.ijse.shadowStudio.model;

import lk.ijse.shadowStudio.db.DbConnection;
import lk.ijse.shadowStudio.dto.BookingDto;
import lk.ijse.shadowStudio.dto.ComplainDto;
import lk.ijse.shadowStudio.dto.CustomerDto;
import lombok.SneakyThrows;

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

    @SneakyThrows
    public static boolean saveBooking(BookingDto dto) {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO bookings VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getBooking_id());
        pstm.setString(2,dto.getCust_id());
        pstm.setString(3,dto.getCust_name());
        pstm.setString(4,dto.getPackage_id());
        pstm.setString(5,dto.getPackage_name());
        pstm.setString(6,dto.getDate());
        pstm.setString(7,dto.getTime());
        pstm.setString(8,dto.getLocation());
        pstm.setString(9,dto.getDescription());
        ;

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }

    @SneakyThrows
    public List<BookingDto> getAllBookings() {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "select * from bookings";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();



        ArrayList<BookingDto> dtoList = new ArrayList<>();
        while (rs.next()) {
            dtoList.add(
                    new BookingDto(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8),
                            rs.getString(9)
                    )
            );
        }
        return dtoList;

    }

    public boolean deleteBooking(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "delete from bookings where booking_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, id);

        return pstm.executeUpdate() > 0;
    }

    public boolean updateBookings(BookingDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE bookings SET cust_id = ?, package_id = ?, date = ?, time = ?, location=?, description=? WHERE cust_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
/*        pstm.setString(1, dto.getCust_Name(a));
        pstm.setString(2, dto.getCust_address());
        pstm.setString(3, dto.getCust_nic());
        pstm.setString(4, dto.getCust_tp());
        pstm.setString(5, dto.getCust_id());*/

        return pstm.executeUpdate() > 0;

    }
}
