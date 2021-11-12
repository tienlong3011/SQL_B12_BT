package com.typeService;

import com.IService;
import com.model.Type;

import java.sql.SQLException;
import java.util.List;

public interface ITypeService extends IService<Type> {
    @Override
    void insertUser(Type type) throws SQLException;

    @Override
    Type selectUser(int id);

    @Override
    List<Type> selectAllUser();

    @Override
    boolean deleteUser(int id) throws SQLException;

    @Override
    boolean updateUser(Type type) throws SQLException;
}
