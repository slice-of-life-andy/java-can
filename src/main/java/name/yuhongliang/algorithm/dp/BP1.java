package name.yuhongliang.algorithm.dp;

public class BP1 {

    private int maxW = Integer.MIN_VALUE;
    private int[] bpw = {2,2,4,6,3};
    private int n = 5;
    private int w = 9;
    private boolean[][] mem = new boolean[5][10];
    public void f(int i, int cw) {
        if (i == n ||cw == w) {
            if (cw > maxW) maxW = cw;
            return;
        }
        if (mem[i][cw]) {
            return;
        }
        System.out.println("" + i + "," + cw);
        mem[i][cw] = true;
        f(i + 1, cw);
        if (cw + bpw[i] <= w) {
            f(i + 1, cw + bpw[i]);
        }
    }

    public static void main(String[] args) {
        BP1 backPack = new BP1();
        backPack.f(0, 0);
    }
}

//(i,cw)表示考察过第i个物品后背包里的总重量