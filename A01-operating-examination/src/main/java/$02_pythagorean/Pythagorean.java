package $02_pythagorean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Pythagorean {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a1 = Integer.parseInt(br.readLine());
		int a2 = Integer.parseInt(br.readLine());
		//计算
		String res = compute(a1, a2);
		System.out.println(res);
	}

	private static String compute(int a1, int a2) {
		//构造出数组
		int len = a2 - a1 + 1;
		int[] nums = new int[len];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = a1;
			a1++;
		}

		//查找出所有的勾股数
		List<Integer[]> resTemp = new ArrayList<>();
		for (int i = 0; i < len - 2; i++) {
			for (int j = i + 1; j < len - 1; j++) {
				int target = nums[i] * nums[i] + nums[j] * nums[j];
				int index = binarySearch(nums, j + 1, nums.length - 1, target);
				if (index != -1) {
					resTemp.add(new Integer[]{nums[i], nums[j], nums[index]});
				}
			}
		}

		//对符合条件的三个数判断两两互斥
		int count = 0;
		StringBuilder sb = new StringBuilder();
		for (Integer[] integers : resTemp) {
			int a = integers[0];
			int b = integers[1];
			int c = integers[2];
			if (huChi(a, b) == 1 && huChi(b, c) == 1 && huChi(a, c) == 1) {
				sb.append(a).append(" ").append(b).append(" ").append(c).append(" ").append("\n");
				count++;
			}
		}
		//没有找到，输出Na
		if (count == 0) {
			sb.append("Na");
		}
		return sb.toString();
	}

	private static int binarySearch(int[] nums, int left, int right, int target) {
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] * nums[mid] == target) {
				return mid;
			} else if (nums[mid] * nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

	/**
	 * 两数最大公约数为1时，互斥
	 *
	 * @param a
	 * @param b
	 * @return
	 */
	private static int huChi(int a, int b) {
		if (a % b == 0) {
			return b;
		}
		return huChi(b, a % b);
	}

	@Test
	public void test() {
		String compute = compute(1, 20);
		Assertions.assertEquals("3 4 5 \n" +
				"5 12 13 \n" +
				"8 15 17 \n", compute);
		compute=compute(5,10);

		Assertions.assertEquals("Na", compute);
	}
}
