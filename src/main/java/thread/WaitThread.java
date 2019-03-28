package thread;

/**
 * 我的第二个线程类
 */
public class WaitThread implements Runnable {

    /** 同步对象 */
    private SynchronizedService synchronizedService;

    public WaitThread(SynchronizedService o) {
        this.synchronizedService = o;
    }

    @Override
    public void run() {
        synchronizedService.objectWait();
    }
}
