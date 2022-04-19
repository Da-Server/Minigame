package com.daserver.minigame.bukkit.database;

import com.daserver.minigame.bukkit.database.pool.ConnectionPool;
import com.daserver.minigame.common.database.Database;
import com.daserver.minigame.common.database.pooling.ObjectPool;
import org.bukkit.plugin.Plugin;

import java.sql.Connection;

public class DatabaseProvider extends Database {
    private final ObjectPool<Connection> conPool;
    private Plugin plugin;

    public DatabaseProvider(int initialAmount, String connectionUrl, Plugin plugin) {
        super();
        this.plugin = plugin;

        this.conPool  = new ConnectionPool(initialAmount, connectionUrl);
    }

    @Override
    protected Connection acquireConnection() {
        return conPool.get();
    }

    @Override
    protected void closeConnection(Connection connection) {
        conPool.release(connection);
    }
}
