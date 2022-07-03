package $01_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 单行输入
 */
public class SingleInput {
	public static void main(String[] args) throws IOException {
		//初始化输入流
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//读取一行
		String str = br.readLine();
		//根据空格切分
		String[] numStr = str.split(" ");

		//具体处理逻辑，每题需要自己写的部分
		int a = Integer.parseInt(numStr[0]);
		int b = Integer.parseInt(numStr[1]);
		System.out.println(a + b);
	}

}
