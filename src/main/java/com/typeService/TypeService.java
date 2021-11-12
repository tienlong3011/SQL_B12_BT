package com.typeService;

import com.model.Type;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypeService implements ITypeService{
    private static String jdbcURL =  "jdbc:mysql://localhost:3306/demomysql?useSSL=false";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "123456";

    private static final String INSERT_USERS_SQL = "INSERT INTO type (name) VALUES (?)";
    private static final String SELECT_USER_BY_ID = "select * from type where id =?";
    private static final String SELECT_ALL_USERS = "select * from type";
    private static final String DELETE_USERS_SQL = "delete from type where id = ?";
    private static final String UPDATE_USERS_SQL = "update type set name = ? where id = ?";

    public TypeService() {
    }

    public static Connection getConnection(){
        Connection connection = null;
        if(connection == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }
        return connection;
    }

    @Override
    public void insertUser(Type type)  {
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);) {
            preparedStatement.setString(1,type.getNameType());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Type selectUser(int id) {
        Type type = null;
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("typeName");
                type = new Type(id,name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return type;
    }

    @Override
    public List<Type> selectAllUser() {
        List<Type> typeList = new ArrayList<>();
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("typeName");
                typeList.add(new Type(id,name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return typeList;
    }

    @Override
    public boolean deleteUser(int id)  {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL)){
            preparedStatement.setInt(1,id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(Type type) {
        boolean rowUpdate = false;
                try(Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)){
                    preparedStatement.setString(1,type.getNameType());
                    preparedStatement.setInt(2,type.getId());
                    rowUpdate = preparedStatement.executeUpdate() > 0;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
        return rowUpdate;
    }
}
