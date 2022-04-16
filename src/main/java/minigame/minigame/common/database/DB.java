package minigame.minigame.common.database;

import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB {
    private static DB instance = null;
    private int usercount = 0;

    private PreparedStatement preparedStatement = null;
    private Connection connection = null;

    public DB(PreparedStatement preparedStatement, Connection connection) {
        this.preparedStatement = preparedStatement;
        this.connection = connection;
        instance = this;
    }
    private void update() throws SQLException {
        usercount = preparedStatement.executeUpdate();
    }


    public static DB getInstance() {
        return instance;
    }
    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    private void prepareStatement(String s) throws SQLException {
        this.preparedStatement = connection.prepareStatement(s);
    }
}
