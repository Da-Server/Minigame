package com.daserver.minigame.common.database;

import java.sql.Connection;

/**
 * This is responsible for managing the connection (Example: Closing and opening).
 */

public abstract class Database {

    /**
     * This method gets a usable connection to the database.
     * @return The connection that was created
     * @see Connection
     */

    protected abstract Connection acquireConnection();

    /**
     * This method takes an existing connection and executes the classes closing logic.
     * @param connection
     */
    protected abstract void closeConnection(Connection connection);
}
