package aop.proxy;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.UserService;
import service.impl.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理工厂类
 */
public class ProxyFactory {

    private Object target;

    private static final Logger logger = LoggerFactory.getLogger(ProxyFactory.class);

    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 返回代理目标对象的实例
     * @return
     */
    public Object getProxyInstance() {

        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        logger.info("---------开始执行目标方法 ： {}", method.getName());
                        Object obj = method.invoke(target, args);
                        logger.info("---------目标方法执行结束 ： {}", method.getName());
                        return obj;
                    }
                });
    }

    public static void main(String[] args) {
        UserService target = new UserServiceImpl();
        UserService proxy =(UserService) new ProxyFactory(target).getProxyInstance();
        proxy.getUserByName("haha");
    }

}
