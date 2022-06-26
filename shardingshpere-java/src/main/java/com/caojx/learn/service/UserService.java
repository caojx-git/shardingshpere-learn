package com.caojx.learn.service;

import com.caojx.learn.pojo.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author caojx created on 2022/6/23 3:38 PM
 */
public class UserService {


    List<User> getUsers(final String sql) throws SQLException {

        DataSource dataSource = null;

        List<User> result = new LinkedList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                User user = new User();
                // 省略设置Uer对象的赋值语句
                result.add(user);
            }
        }
        return result;
    }

}
