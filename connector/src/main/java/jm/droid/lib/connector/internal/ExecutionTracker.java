package jm.droid.lib.connector.internal;

import com.google.common.util.concurrent.SettableFuture;

public interface ExecutionTracker {

    /** Track given future as in progress. */
    void track(SettableFuture<?> future);

    /** Cancel all tracked futures with given exception. */
    void cancelPendingFutures(Throwable throwable);
}
