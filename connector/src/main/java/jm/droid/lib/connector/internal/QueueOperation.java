package jm.droid.lib.connector.internal;


import android.os.IBinder;
import android.os.RemoteException;

public interface QueueOperation {
    /**
     * Method executed against the service.
     *
     * @param binder already connected to the target service.
     */
    void execute(IBinder binder) throws RemoteException;

    /** Sets exception as the result of the operation. */
    void setException(Throwable exception);

    /**
     * Tracks the operation execution with an {@link ExecutionTracker}.
     *
     * @param tracker To track the execution as in progress.
     */
    QueueOperation trackExecution(ExecutionTracker tracker);

    /** Returns configuration of the service connection on which the operation will be executed. */
    ConnectionConfiguration getConnectionConfiguration();
}

