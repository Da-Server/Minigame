package com.daserver.minigame.common.database;

import java.sql.Connection;

/**
 * An action for the database to preform.
 */
public abstract class DatabaseAction {
    private Connection connection;
    private final Database database;

    public DatabaseAction(Database databaseService) {
        this.database = databaseService;
    }

    protected Connection getConnection() {
        if (connection == null) {
            connection = database.acquireConnection();
        }

        return connection;
    }

    protected void releaseConnection() {
        database.closeConnection(connection);
    }

    public void close() {
        releaseConnection();
    }
}
