package kw.test.app;

import io.jboot.Jboot;

/**
 * auther   kangwang
 */
public class App {
    public static void main(String[] args) {
        Jboot.setBootArg("Jboot.server.port","8888");
        Jboot.run(args);
    }
}