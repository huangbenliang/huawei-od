package $02_pythagorean;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ThreeSum {

	void threeSum(int[] arr, int target) {
		int len = arr.length;
		Arrays.sort(arr);
		for (int i = 0; i < len - 2; i++) {
			for (int j = i + 1; j < len - 1; j++) {
				for (int k = j + 1; k < len; k++) {
					if (arr[i] + arr[j] + arr[k] == target) {
						System.out.printf("%d %d %d\n", arr[i], arr[j], arr[k]);
					}
				}
			}
		}
	}
	void threeSumWithBinarySearch(int[] arr, int target) {
		int len = arr.length;
		Arrays.sort(arr);
		for (int i = 0; i < len - 2; i++) {
			for (int j = i + 1; j < len - 1; j++) {
				//相当于在[j+1,arr.length-1]中查找num
				int num = target - arr[i] - arr[j];
				int res = BinarySearch.binarySearchWithRecursive(arr, j + 1, arr.length - 1, num);
				if (res != -1) {
					System.out.printf("%d %d %d\n", arr[i], arr[j], arr[res]);
				}

			}
		}
	}

	@Test
	public void test() {
		int[] arr = {10, 5, 1, 9, 6};
		threeSum(arr, 16);
		threeSumWithBinarySearch(arr, 16);
	}
}
