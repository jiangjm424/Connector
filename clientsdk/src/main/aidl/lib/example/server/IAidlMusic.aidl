// IAidlMusic.aidl
package lib.example.server;

// Declare any non-default types here with import statements

interface IAidlMusic {
    int apiVersion();
    void play(String path);
}