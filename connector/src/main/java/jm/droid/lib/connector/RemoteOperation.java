package jm.droid.lib.connector;

import android.os.RemoteException;

public interface RemoteOperation<S, R> {

    /**
     * Executes a task against the remote service.
     *
     * @param service the already connected remote service to execute the task against
     * @return the operation result
     * @throws RemoteException on binder error
     */
    R execute(S service) throws RemoteException;
}

