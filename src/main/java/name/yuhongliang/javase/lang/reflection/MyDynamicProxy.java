package name.yuhongliang.javase.lang.reflection;

import java.lang.reflect.Proxy;

public class MyDynamicProxy {
    public static void main(String[] args) {
        HelloImpl hello = new HelloImpl();
        MyInvocationHandler invocationHandler = new MyInvocationHandler(hello);

        Hello helloProxy = (Hello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(),HelloImpl.class.getInterfaces(),invocationHandler);

        helloProxy.sayHello();
        helloProxy.sayGoodbye();
    }
}
