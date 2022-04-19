package com.daserver.minigame.common.database.pooling;

/**
 * A pool of objects
 * @param <V> the type of object being pooled.
 */
public abstract class ObjectPool<V> {
    public abstract V get();

    public abstract void release(V poolObject);

    protected abstract V createPoolObj();
}
