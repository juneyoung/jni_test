package org.owls;

import org.owls.jni.NativeCaller;

public class Application {

    private void loadJni() {
        NativeCaller wrapper = new NativeCaller();
        wrapper.hello();
    }

    public static void main(String[] args) throws Exception {
        Application application = new Application();
        application.loadJni();
    }
}
