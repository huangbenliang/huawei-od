package $02_pythagorean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearch {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] numStr = br.readLine().split(" ");
		int target = Integer.parseInt(br.readLine());

		int[] nums = new int[numStr.length];
		for (int i = 0; i < numStr.length; i++) {
			nums[i] = Integer.parseInt(numStr[i]);
		}
		int res = binarySearch(nums, target);
		System.out.println(res);
	}

	/**
	 * 迭代版本
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int binarySearch(int[] nums, int target) {
		//两端都是闭区间
		int left = 0;
		int right = nums.length - 1;
		//注意有等号，相等时判断自己
		while (left <= right) {
			//取重点，这样可以防止整数溢出
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				//如果相等，说明找到，直接返回
				return mid;
			} else if (nums[mid] > target) {
				//中点值大于目标值，说明目标值只能在[left,mid-1]中出现，右边界左移。
				right = mid - 1;
			} else if (nums[mid] < target) {
				//中点值小于目标值，说明目标值只能在[mid+1,right]中出现，左边界右移。
				left = mid + 1;
			}
		}
		//当左边界大于右边界，比如[6，5]区间.区间已无意义，说明没找到.
		return -1;
	}

	/**
	 * 递归版本
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	private int binarySearchWithRecursive(int[] nums, int target) {
		return binarySearchWithRecursive(nums, 0, nums.length - 1, target);
	}

	public static int binarySearchWithRecursive(int[] nums, int left, int right, int target) {
		//递归结束条件，当左边界大于右边界时，没有意义，返回-1
		if (left > right) {
			return -1;
		}

		//递归体：缩小边界
		int mid = left + (right - left) / 2;
		if (nums[mid] == target) {
			return mid;
		} else if (nums[mid] > target) {
			right = mid - 1;
		} else {
			//可以直接简写为else。前两个if走完,nums[mid]<target必成立。
			left = mid + 1;
		}
		return binarySearchWithRecursive(nums, left, right, target);
	}


	@Test
	public void test() {
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};

		int res1 = binarySearch(nums, 6);
		Assertions.assertEquals(5, res1);

		int res2 = binarySearch(nums, 10);
		Assertions.assertEquals(-1, res2);

		int res3 = binarySearchWithRecursive(nums, 6);
		Assertions.assertEquals(5, res3);

		int res4 = binarySearchWithRecursive(nums, 10);
		Assertions.assertEquals(-1, res4);
	}
}
