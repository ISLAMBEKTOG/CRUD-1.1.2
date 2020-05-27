package service;

import connection.MySqlConnection;
import dao.UserDAO;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private static UserService userService = new UserService();

    public static UserService getInstance(){
        return userService;
    }

    private UserDAO dao;

    public UserService(){
        this.dao = getUserDAO();
    }

    public List<User> getAllUsers() throws SQLException {
        return dao.getAllUsers();
    }

    public void deleteUser(Long id) throws SQLException {
        dao.deleteUser(id);
    }

    public void addUser(String name, int age, String gender) throws SQLException {
        dao.addUser(name, age, gender);
    }

    public void updateUser(Long id, String name, int age, String gender) throws SQLException {
        dao.updateUser(id, name, age, gender);
    }

    public User getUserById(Long id) throws SQLException {
        return dao.getUserById(id);
    }


    private static UserDAO getUserDAO(){
        return new UserDAO(MySqlConnection.getMysqlConnection());
    }
}
