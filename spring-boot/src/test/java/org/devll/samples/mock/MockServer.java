package org.devll.samples.mock;

public class MockServer {

    private int port;

    public MockServer(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
