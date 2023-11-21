package lk.ijse.shadowStudio.model;

import lk.ijse.shadowStudio.db.DbConnection;
import lk.ijse.shadowStudio.dto.CustomerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ComplainModel {
    public static String generateNextComplainId() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT complain_id FROM complains ORDER BY complain_id DESC LIMIT 1";
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();
        if(resultSet.next()) {
            return splitComplainId(resultSet.getString(1));
        }
        return splitComplainId(null);
    }
    private static String splitComplainId(String currentComplainId) {
        if(currentComplainId != null) {
            String[] split = currentComplainId.split("C0");

            int id = Integer.parseInt(split[1]); //01
            id++;
            return "C00" + id;
        } else {
            return "C001";
        }

    }

}
