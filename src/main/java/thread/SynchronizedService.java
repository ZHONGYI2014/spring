package thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.TimeUtil;

/**
 * Thread.sleep 和 Object.wait() 区别
 */
public class SynchronizedService {

    private static Logger logger = LoggerFactory.getLogger(SynchronizedService.class);

//    public void threadSleep() {
//        /** 获取对象锁 */
//        synchronized(this) {
//            try {
//                logger.info("enter sleep current time : {}", TimeUtil.getCurrentTime());
//                logger.info("at this moment will sleep five seconds");
//                Thread.sleep(5000);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
//
//    public void objectWait() {
//        /** 获取对象锁 */
//        synchronized(this) {
//            try {
//                logger.info("enter wait current time : {}", TimeUtil.getCurrentTime());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//    }



    public void threadSleep() {
        /** 获取对象锁 */
        synchronized(this) {
            try {
                logger.info("enter sleep current time : {}", TimeUtil.getCurrentTime());
                logger.info("at this moment will sleep five seconds");
                Thread.sleep(5000);
                this.notifyAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void objectWait() {
        /** 获取对象锁 */
        synchronized(this) {
            try {
                logger.info("enter wait current time : {}", TimeUtil.getCurrentTime());
                // 代码块用synchronized获取对象锁, 使用 Object.wait() 方法能够释放对象锁, 这样其它线程能够使用该资源对象
                // wait() 方法会让本线程等待 5s , 不影响其它线程
                this.wait(5000);
                logger.info(TimeUtil.getCurrentTime());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
