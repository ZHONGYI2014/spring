package thread;

/**
 * 我的第一个线程类
 */
public class SleepThread implements Runnable{

    /** 同步对象 */
    private SynchronizedService synchronizedService;

    public SleepThread(SynchronizedService o) {
        this.synchronizedService = o;
    }

    @Override
    public void run() {
        synchronizedService.threadSleep();
    }
}
