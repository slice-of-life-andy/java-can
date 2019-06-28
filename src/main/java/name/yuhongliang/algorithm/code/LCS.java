package name.yuhongliang.algorithm.code;

public class LCS {


	public static int  lcs(int[] sequence) {
		int m = sequence.length;
		int[] states = new int[m];

		for (int i = 0; i < states.length;i++) {
			states[i] = 1;
		}


		for (int i = 1; i < m; i++) {
			int max = 0;
			for (int j = 0; j < i;j++) {
				if (sequence[j] < sequence[i] &&  max < states[j] + 1) {
					max = states[j] + 1;
				}
			}
			if (states[i] < max) {
				states[i] = max;
			}
		}

		int result = states[0];
		for (int i = 1; i < states.length; i++) {
			System.out.println(states[i]);
			if (result < states[i]) {
				result = states[i];
			}
		}

		return result;

	}
	public static void main(String[] args) {
		int[] sequence = {2,9,3,6,5,1,7};
		System.out.println(LCS.lcs(sequence));
	}

}
