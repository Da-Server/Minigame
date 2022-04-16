package minigame.minigame.common.database;

import lombok.SneakyThrows;
import minigame.minigame.bukkit.configs.MySQLConfig;

import java.sql.*;

/**
 * The class that holds stuff for the database
 * MYSQL Database
 * TODO: FINISH THE DB
 */
public class MySQL {
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;



    private DB database;

    /**
     * Initializes the DataBase
     * and its parts
     */
    @SneakyThrows
    public void initialize() {
        loadDrivers();
        connect();
    }

    /**
     * Loads the drivers necessary
     * for loading the db
     * @throws ClassNotFoundException Could not find the MySQL drivers
     */
    private void loadDrivers() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
    }

    /**
     * Connects to the specified DataBase
     * @see minigame.minigame.bukkit.configs.MySQLConfig for the config
     */
    private void connect() throws SQLException {
        this.connection = DriverManager.getConnection(MySQLConfig.DB_HOST, MySQLConfig.DB_USER, MySQLConfig.DB_PASSWORD);
        this.statement = connection.createStatement();
    }



    private void prepareStatement(String s) throws SQLException {
        this.preparedStatement = connection.prepareStatement(s);
    }


    /**
     * gets the Connection field and
     * @return returns the connection field
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * gets the Statement field and
     * @return returns the Statement field
     */
    public Statement getStatement() {
        return statement;
    }

    /**
     * gets the PreparedStatement field and
     * @return returns the PreparedStatement field
     */
    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    /**
     * gets the ResultSet field and
     * @return returns the ResultSet field
     */
    public ResultSet getResultSet() {
        return resultSet;
    }

    /**
     * gets the DataBase class
     * @return returns DB
     */
    public DB getDatabase() {
        return database;
    }




}
