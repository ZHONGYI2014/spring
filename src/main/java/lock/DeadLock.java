package lock;

/**
 * 死锁：两个或两个以上的线程互相持有对方所需资源
 * 例如：两个人都在做任务，一个人对另外一个人说，我手上有你想要的东西，你先把KK给我，我再给你，另外一个人说，我手上也有你想要的东西LL，
 * 你先把KK给我，我再给你，两个人互不相让就产生了"死锁"
 */
public class DeadLock {
    public static void main(String[] args) {
       final Object resourceA = "resourceA";
       final Object resourceB = "resourceB";
       Thread threadA = new Thread(()->{
           /** 线程A 先占有resourceA 再占有 resourceB */
           synchronized(resourceA) {
               System.out.println("threadA get resourceA");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               /** 线程A 尝试占有resourceB */
               synchronized(resourceB) {
                   System.out.println("线程A 尝试占有resourceB");
               }
           }
       });
        Thread threadB = new Thread(()->{
            /** 线程B 占有 resourceB 再占有resourceA */
            synchronized(resourceB) {
                System.out.println("threadB get resourceB");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                /** 线程B尝试获取 resourceA */
                synchronized(resourceA) {
                    System.out.println("线程B 尝试占有resourceA");
                }
            }
        });
        threadA.start();
        threadB.start();
    }
}
