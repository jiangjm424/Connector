package jm.droid.lib.connector.internal;

import static com.google.common.base.Preconditions.checkNotNull;

public final class ConnectionConfiguration {
    private final String mPackageName;
    private final String mClientName;
    private final String mBindAction;
    private final QueueOperation mRefreshVersionOperation;

    public ConnectionConfiguration(
            String packageName,
            String clientName,
            String bindAction,
            QueueOperation refreshVersionOperation) {
        this.mPackageName = checkNotNull(packageName);
        this.mClientName = checkNotNull(clientName);
        this.mBindAction = checkNotNull(bindAction);
        this.mRefreshVersionOperation = checkNotNull(refreshVersionOperation);
    }

    /** A key that defines the connection among other IPC connections. It should be unique. */
    String getKey() {
        return String.format("%s#%s#%s", mClientName, mPackageName, mBindAction);
    }

    /** Returns name of the service, use for logging and debugging only. */
    String getClientName() {
        return mClientName;
    }

    /** Returns the action used to bind to the remote service. */
    String getBindAction() {
        return mBindAction;
    }

    /** Returns the application package of the remote service. */
    String getPackageName() {
        return mPackageName;
    }

    QueueOperation getRefreshVersionOperation() {
        return mRefreshVersionOperation;
    }
}
