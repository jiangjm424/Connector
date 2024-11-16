package jm.droid.lib.connector.internal;

import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;

import java.util.HashSet;
import java.util.Set;

public class DefaultExecutionTracker implements ExecutionTracker {
    private final Set<SettableFuture<?>> mFuturesInProgress = new HashSet<>();

    @Override
    public void track(SettableFuture<?> future) {
        synchronized (mFuturesInProgress) {
            mFuturesInProgress.add(future);
            future.addListener(
                    () -> {
                        synchronized (mFuturesInProgress) {
                            mFuturesInProgress.remove(future);
                        }
                    },
                    MoreExecutors.directExecutor());
        }
    }

    @Override
    public void cancelPendingFutures(Throwable throwable) {
        Set<SettableFuture<?>> futuresInProgressCopy;
        synchronized (mFuturesInProgress) {
            futuresInProgressCopy = new HashSet<>(mFuturesInProgress);
            mFuturesInProgress.clear();
        }
        for (SettableFuture<?> future : futuresInProgressCopy) {
            future.setException(throwable);
        }
    }
}
