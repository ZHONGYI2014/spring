package ioc;

public class Singleton {

    private static Singleton singleton = null;

    public static Singleton getSingleton() {
        if (null == singleton) {
            singleton = new Singleton();
            return singleton;
        }
        return singleton;
    }

}
