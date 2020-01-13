package name.yuhongliang.javase.lang.reflection;

public class HelloImpl implements Hello {
    @Override
    public void sayHello() {
        System.out.println("Hello World");
    }

    @Override
    public void sayGoodbye() {
        System.out.println("say goodbye");
    }

}
