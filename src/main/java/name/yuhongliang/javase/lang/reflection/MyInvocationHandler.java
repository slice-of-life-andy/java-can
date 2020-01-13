package name.yuhongliang.javase.lang.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private Object target;
    public  MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Invoking sayHello from proxy!");
        if (method.getName().equals("sayGoodbye")) {
            System.out.println("catch you ! go go go!");
        }
        Object result = method.invoke(target,args);
        return result;
    }
}
