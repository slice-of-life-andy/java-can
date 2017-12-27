package name.yuhongliang.algorithm.code;

public class CopyRandomList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aabcde";
		int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        for (int i : count) {
        	System.out.println(i);
        }
        
	}

	
	
}
