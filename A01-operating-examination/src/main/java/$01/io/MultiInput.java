package $01.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiInput {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//定义一个变量
		String str;
		//当读取的str不为null时，循环读取。注意括号位置
		while ((str = br.readLine()) != null) {
			String[] split = str.split(" ");
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[0]);
			System.out.println(a + b);
		}
	}
}
