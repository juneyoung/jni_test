package org.owls.jni;

public class NativeCaller {

    static {
        try {
            System.loadLibrary("NativeCaller");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    public native void hello();
}
