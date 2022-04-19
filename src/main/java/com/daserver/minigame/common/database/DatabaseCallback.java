package com.daserver.minigame.common.database;

/**
 * Callback for the database to use that allows access to the result of a query
 * @param <T> The expected data
 * @see DatabaseQuery
 */
public interface DatabaseCallback<T> {
    void execute(T result);
}
