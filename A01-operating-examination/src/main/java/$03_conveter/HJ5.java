package $03_conveter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//去掉前两位前缀方法
		String str = br.readLine().substring(2);
		int res = getRes(str);
		System.out.println(res);
	}

	private static int getRes(String str) {
		int res = 0;
		int k = 1;
		for (int i = str.length() - 1; i >= 0; i--) {
			char c = str.charAt(i);
			//char类型本质上是数字，所以可以直接相减。
			if (c >= 'A') {
				res += (c - 'A' + 10) * k;
			} else {
				res += (c - '0') * k;
			}
			//因为是16进制，所以乘以16
			k *= 16;
		}
		return res;
	}

	@Test
	public void test() {
		Assertions.assertEquals(170, getRes("AA"));
		Assertions.assertEquals(44, getRes("2C"));
	}
}