package jm.droid.lib.connector;

public class ClientConfiguration {
    private final String mServicePackageName;
    private final String mBindAction;
    private final String mApiClientName;

    public ClientConfiguration(String apiClientName, String servicePackageName, String bindAction) {
        this.mServicePackageName = servicePackageName;
        this.mBindAction = bindAction;
        this.mApiClientName = apiClientName;
    }

    /** Returns the application package of the remote service. */
    public String getServicePackageName() {
        return mServicePackageName;
    }

    /** Returns the action used to bind to the remote service. */
    public String getBindAction() {
        return mBindAction;
    }

    /** Returns name of the service, use for logging and debugging only. */
    public String getApiClientName() {
        return mApiClientName;
    }
}

