package name.yuhongliang.javase.string;

import java.util.Base64;

import org.junit.Test;

public class StringTest {
	
	@Test
	public void testStringEncode() {
		String str1 = "型号";
		System.out.println(Base64.getEncoder().encode(str1.getBytes()));
	}

}
