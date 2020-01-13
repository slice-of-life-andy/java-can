package name.yuhongliang.javase.string;

import java.util.Base64;

import org.junit.Test;

public class StringTest {
	
	@Test
	public void testStringEncode() {
		String str1 = "型号";
		System.out.println(Base64.getEncoder().encode(str1.getBytes()));

		System.out.println("12345678910".hashCode());
	}
	
	public static String convertStr2HexStr(String input) {
// 		if (org.apache.commons.lang3.StringUtils.isBlank(input)) {
//			return null;
//		}
 		
 		String lowercaseStr = input.toLowerCase();
 		String removeSpaceStr = lowercaseStr.replaceAll("\\s+", "");
// 		if (org.apache.commons.lang3.StringUtils.isBlank(removeSpaceStr)) {
// 			return null;
// 		}
 		
 		try {
				char[] ascii_bytes = removeSpaceStr.toCharArray();
				StringBuilder accumulator = new StringBuilder();
				for (char ascii_char : ascii_bytes) {
					accumulator.append(Integer.toHexString(ascii_char));
				}
				return accumulator.toString();
			} catch (Exception e) {
				e.printStackTrace();
			}
 		return null;
 }

}
