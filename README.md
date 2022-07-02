> 这是一篇Java语言的`华为社招od`刷题攻略集。在我备考过程中,没有发现优秀的、基于Java语言实现的刷题集，于是有了本系列题集。好的刷题攻略应当尽量`以拆解真题为主`，实现`知识点总结`和`类似题训练`。

## 考场规则
1. 考试共3道题（100、100、200），时长150分钟。 $得分 = \sum 每题用例通过率*该题分数$
2. 考场`不会给出错误用例`，所以不知道自己会错哪。这提升了考试难度。
3. 可以使用开发工具调试，然后复制到答题栏。
4. 可多次提交，以最后一次提交代码为准。

# 第0题 处理输入输出
1. 考试需要自己处理输入输出，使用输入流可以更快的读取数据。
2. 考试题目类名固定为Main。需要自己导包
### 处理单行输入
题目：输入两个整数，以空格分割。输出两数之和。
示例：

```
输入：
2 3
输出：
5
```

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 单行输入
 */
public class Main{
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
```

 ### 处理多行输入
 题目：输入两个整数，以空格分割。输出两数之和。题目需要处理多行输入，每个结果占一行
示例：

```
输入：
2 3
4 8
输出：
5
12
```
 
 ```java
 import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
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
 ```
