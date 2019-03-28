package thread;

import util.TimeUtil;

public class ThreadDemo {


    public static void main(String[] args) {
        System.out.println(TimeUtil.getCurrentTime());
        SynchronizedService synchronizedService = new SynchronizedService();

        //两个线程共用一个对象
        Thread t1 = new Thread(new SleepThread(synchronizedService));
        Thread t2 = new Thread(new WaitThread(synchronizedService));
        t2.start();
        t1.start();
    }
}
