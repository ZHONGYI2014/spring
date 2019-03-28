package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 模拟了100米赛跑，10名选手已经准备就绪，只等裁判一声令下。当所有人都到达终点时，比赛结束
 * 10名选手相当于是个线程, 怎么知道这是个线程都完成了情况？ 所以你肯定是不能用简单的计数器来计算,
 */
public class CountDownLatchTest {

    static final int NUMBER_THREADS = 10;

    /** 开启10个线程相当于new 10个 Thread  */
    static final ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_THREADS);

    /** 初始化线程等待数量 */
    static final CountDownLatch begin = new CountDownLatch(1);

    static final CountDownLatch end = new CountDownLatch(10);

    public static void main(String[] args) throws InterruptedException {
        /** Java中会有一个主线程main */
        for (int index = 0; index < 10; index++) {
            final int NO = index +1;
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        //如果当前计数为零，则此方法立即返回
                        begin.await();
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println(Thread.currentThread()+"NO." + NO + " arrived");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        // 每个选手到达终点时, end就减一
                        end.countDown();
                    }
                }
            };
            executorService.submit(run);
        }
        System.out.println(Thread.currentThread()+"Game start");
        // begin 减一 开始游戏
        begin.countDown();
        // 等待end 变为0, 即所有选手到达终点
        end.await();
        System.out.println(Thread.currentThread()+"Game Over");
        executorService.shutdown();
    }
}
