package dev.spiralmoon.maplestory.api.callback;

@FunctionalInterface
public interface FailureCallback {
    void callback(Throwable throwable);
}
