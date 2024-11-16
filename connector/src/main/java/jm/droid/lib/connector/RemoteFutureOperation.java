package jm.droid.lib.connector;

import android.os.RemoteException;

import com.google.common.util.concurrent.SettableFuture;

public interface RemoteFutureOperation<S, R> {

    /**
     * Executes a task against the {@code service} and {@code resultFuture}.
     *
     * @param service the already connected remote service to execute the task against
     * @param resultFuture a {@link SettableFuture} that should be set with the execution result
     * @throws RemoteException on binder error
     */
    void execute(S service, SettableFuture<R> resultFuture) throws RemoteException;
}

