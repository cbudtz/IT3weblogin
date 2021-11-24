package datalayer;

import model.LoginData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public LoginData findUser(String username) {
        Connection connection = MySQLConnector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE username = ? ");
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                String password= resultSet.getString("password");
                LoginData loginData = new LoginData();
                loginData.setUsername(username);
                loginData.setPassword(password);
                return loginData;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
