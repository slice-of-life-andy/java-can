/**
 *
 */
package name.yuhongliang.datastructure.skiplist;

/**
 * Jun 30, 2014
 * @author andy
 */

public class Test1 {
    public static void main(String[] args) {
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
