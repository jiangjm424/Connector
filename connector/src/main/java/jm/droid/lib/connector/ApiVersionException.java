package jm.droid.lib.connector;

import java.util.concurrent.ExecutionException;

public class ApiVersionException extends ExecutionException {

    private final int mRemoteVersion;
    private final int mMinVersion;

    public ApiVersionException(int remoteVersion, int minVersion) {
        super(
                "Version requirements for calling the method was not met, remoteVersion: "
                        + remoteVersion
                        + ", minVersion: "
                        + minVersion);
        this.mRemoteVersion = remoteVersion;
        this.mMinVersion = minVersion;
    }

    public int getRemoteVersion() {
        return mRemoteVersion;
    }

    public int getMinVersion() {
        return mMinVersion;
    }
}
