package com.daserver.minigame.common.database.callbacks;

import java.sql.SQLException;

public interface SingleParamCallback<T> {
    void run(T TypeParam) throws SQLException;
}
