import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 目标对象拦截器，实现MethodInterceptor
 */
public class TargetInterceptor implements MethodInterceptor {
    /**
     * 重写方法拦截，在方法前后加入业务
     * @param o             目标对象
     * @param method        目标方法
     * @param objects       参数
     * @param methodProxy   方法代理对象
     * @return
     * @throws Throwable
     */
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用前");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println(" 调用后" + result);
        return result;
    }
}
