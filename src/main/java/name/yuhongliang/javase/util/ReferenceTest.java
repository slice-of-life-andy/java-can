package name.yuhongliang.javase.util;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class ReferenceTest {

    public static String aa = "aaaaaaaaaa";
//    public static String bb = "bbbbbbbbbbbbbb";
//    public static String cc = "cccccccccccccc";

    public static void test() {
        Object counter = new Object();
        ReferenceQueue refQueue = new ReferenceQueue<>();
        PhantomReference<Object> p = new PhantomReference<>(counter, refQueue);
        counter = null;
        System.gc();
        try {
            // Remove 是一个阻塞方法，可以指定 timeout，或者选择一直阻塞
            Reference<Object> ref = refQueue.remove(1000L);
            if (ref != null) {
                System.out.println("post ");
            }
        } catch (InterruptedException e) {
            // Handle it
        }
    }

    public static void main(String[] args) {
        ReferenceTest.test();
    }


}
