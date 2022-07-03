package $03_conveter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * HJ5 进制转换
 */
public class NumberSystemConversion {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while ((str = br.readLine()) != null) {
			int num = Integer.parseInt(str);
			String res = converter(num);
			System.out.println("res = " + res);
		}
	}

	private static String converter(int num) {
		Stack<Character> stack = new Stack<>();
		while (num != 0) {
			int i = num % 16;
			//大于9时，说明以字母存储，计算从'A'开始的偏移量。否则i即为从'0'开始的偏移量。
			stack.push(i > 9 ? (char) (i - 10 + 'A') : (char) (i + '0'));
			num /= 16;
		}
		StringBuilder sb = new StringBuilder("0x");
		while (stack.size() > 0) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}
}
