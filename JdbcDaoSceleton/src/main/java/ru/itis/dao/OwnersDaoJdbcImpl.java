package ru.itis.dao;

import ru.itis.models.Owner;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OwnersDaoJdbcImpl implements OwnersDao {
    //КЛАСС ДЛЯ ПРЯМОЙ РАБОТЫ С БАЗАМИ ДАННЫХ (SQL - запросы)
    // НАЙТИ (запрос SQL)
    // ОБНОВИТЬ (запрос SQL)

    private Connection connection;
    // language=SQL
    public static final String SQL_SELECT_ALL_OWNERS = "SELECT * FROM owners;";

    // language=SQL
    private final String SQL_FIND_OWNER = "SELECT * FROM owners WHERE owner_id = ?;";

    // language=SQL
    private final String SQL_UPDATE_OWNER = "UPDATE owners SET name = ? WHERE owner_id = ?";

    public OwnersDaoJdbcImpl(Connection connection) {
        this.connection = connection;
    }
    //ПРоверка владельца по id
    public Owner find(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_OWNER);
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            result.next();
            return new Owner(result.getInt("owner_id"), result.getString("name"));

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }
    //Обновление базы данных
    public void update(Owner owner) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_OWNER);
            preparedStatement.setString(1, owner.getName());
            preparedStatement.setInt(2, owner.getId());

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }

    public List<Owner> getAllOwners(){
        try {
            List<Owner> allOwners = new ArrayList<Owner>();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_OWNERS);
            while (resultSet.next()) {
                Owner owner = new Owner(resultSet.getInt("owner_id"), resultSet.getString("name"));
                allOwners.add(owner);
            }
            return allOwners;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
