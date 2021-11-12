package com.dao;

import com.IService;
import com.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO extends IService<User> {
    public void insertUser(User user) throws SQLException;

    public User selectUser(int id);

    public List<User> selectAllUser();

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(User user) throws SQLException;

    User getUserById(int id);

    void insertUserStore(User user) throws SQLException;
}
