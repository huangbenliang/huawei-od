package $03_conveter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 功能描述
 *
 * @since 2022-06-01
 */
public class HJ33 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //.是特殊字符，需要转义
        String[] split = br.readLine().split("\\.");
        String n = br.readLine();
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            //转成二进制
            String str = toBinaryString(split[i]);
            //格式化，补齐0
            sb1.append(format(str));
        }
        long res = binaryToInteger(sb1.toString());
        System.out.println(res);

        String binaryString = toBinaryString(n);
        String formatString = format(binaryString);
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < formatString.length(); i += 8) {
            sb2.append(binaryToInteger(formatString.substring(i, i + 8))).append(".");
        }
        sb2.deleteCharAt(sb2.length() - 1);
        System.out.println(sb2);
    }
    //二进制转十进制，类似转16进制代码。需要返回long，因为十进制结果会溢出。
    private static long binaryToInteger(String binaryCode) {
        long res = 0L;
        int length = binaryCode.length();
        long k = 1;
        for (int i = 0; i < length; i++) {
            //等于'1'的时候，加起来。
            if (binaryCode.charAt(length - i - 1) == '1') res += k;
            k *= 2;
        }
        return res;
    }

    private static String toBinaryString(String s) {
        long num = Long.parseLong(s);
        if (num == 0) return "0";
        Stack<Long> stack = new Stack<>();
        while (num != 0) {
            stack.push(num % 2);
            num /= 2;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    /**
     * 补齐0
     *
     * @param str
     * @return
     */
    private static String format(String str) {
        int length = str.length();
        if (length % 8 != 0) {
            StringBuilder sb = new StringBuilder();
            //缺少0的个数即为 8-(length % 8)
            for (int i = 0; i < 8 - (length % 8); i++) {
                sb.append("0");
            }
            sb.append(str);
            return sb.toString();
        } else {
            return str;
        }
    }
}
