package jm.droid.lib.connector;

import android.os.IBinder;
import android.os.RemoteException;

import com.google.common.util.concurrent.SettableFuture;

public interface ServiceOperation<R> {

    /**
     * Method executed against the service.
     *
     * @param binder Already connected binder to the target service.
     * @param resultFuture A {@link SettableFuture} that should be set with the result.
     */
    void execute(IBinder binder, SettableFuture<R> resultFuture) throws RemoteException;
}

