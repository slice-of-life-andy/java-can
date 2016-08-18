package name.yuhongliang.datastructure.skiplist;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by andy on 16-7-18.
 */
public class SkipListTest {

    @Test
    public void test() {
        SkipList S = new SkipList();

        S.printHorizontal();
        System.out.println("------");
        // S.printVertical();
        // System.out.println("======");

        S.put("ABC", 123);
        S.printHorizontal();
        System.out.println("------");
        // S.printVertical();
         //System.out.println("======");

        S.put("DEF", 123);
        S.printHorizontal();
        System.out.println("------");
        // S.printVertical();
        // System.out.println("======");

        S.put("KLM", 123);
        S.printHorizontal();
        System.out.println("------");
        // S.printVertical();
        // System.out.println("======");

        S.put("HIJ", 123);
        S.printHorizontal();
        System.out.println("------");
        // S.printVertical();
        // System.out.println("======");

        S.put("GHJ", 123);
        S.printHorizontal();
        System.out.println("------");
        // S.printVertical();
        // System.out.println("======");

        S.put("AAA", 123);
        S.printHorizontal();
        System.out.println("------");
        // S.printVertical();
        // System.out.println("======");
    }
}