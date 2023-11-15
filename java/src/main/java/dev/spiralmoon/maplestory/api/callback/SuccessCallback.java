package dev.spiralmoon.maplestory.api.callback;

@FunctionalInterface
public interface SuccessCallback<T> {
    void callback(T dto);
}
