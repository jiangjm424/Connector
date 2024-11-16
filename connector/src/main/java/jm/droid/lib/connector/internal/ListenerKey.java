package jm.droid.lib.connector.internal;

import androidx.annotation.Nullable;

public final class ListenerKey {
    private final Object mListenerKey;

    public ListenerKey(Object listenerKey) {
        this.mListenerKey = listenerKey;
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ListenerKey)) {
            return false;
        }

        ListenerKey that = (ListenerKey) o;
        return mListenerKey.equals(that);
    }

    @Override
    public int hashCode() {
        return System.identityHashCode(mListenerKey);
    }

    @Override
    public String toString() {
        return String.valueOf(mListenerKey);
    }
}
