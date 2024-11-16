package jm.droid.lib.connector.internal;

import static com.google.common.base.Preconditions.checkNotNull;

import android.os.IBinder;
import android.os.RemoteException;

import androidx.annotation.NonNull;

public class BaseQueueOperation implements QueueOperation {
    private final ConnectionConfiguration mConnectionConfiguration;

    public BaseQueueOperation(@NonNull ConnectionConfiguration connectionConfiguration) {
        this.mConnectionConfiguration = checkNotNull(connectionConfiguration);
    }

    @Override
    public void execute(@NonNull IBinder binder) throws RemoteException {}

    @Override
    public void setException(@NonNull Throwable exception) {}

    @Override
    @NonNull
    public QueueOperation trackExecution(@NonNull ExecutionTracker tracker) {
        return this;
    }

    /** Configuration of the service connection on which the operation will be executed. */
    @Override
    @NonNull
    public ConnectionConfiguration getConnectionConfiguration() {
        return mConnectionConfiguration;
    }
}
