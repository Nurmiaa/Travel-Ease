package Dao;

import Bean.ContactBean;
import Util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactDao {
    public boolean addContactMessage(ContactBean contactBean) {
        Connection con = null;
        PreparedStatement preparedStatement = null;

        try {
            con = DBConnection.createConnection();
            String query = "INSERT INTO contact_messages (full_name, email, message) VALUES (?, ?, ?)";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, contactBean.getFullName());
            preparedStatement.setString(2, contactBean.getEmail());
            preparedStatement.setString(3, contactBean.getMessage());

            int result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
}
