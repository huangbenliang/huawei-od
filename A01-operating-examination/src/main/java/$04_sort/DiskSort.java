package $04_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DiskSort {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Disk[] disks = new Disk[n];
		for (int i = 0; i < n; i++) {
			disks[i] = new Disk(br.readLine());
		}
		// 数组获取stream流方法
		// lambda表达式排序
		///List<Disk> res = Arrays.stream(disks).sorted((d1, d2) -> d1.val - d2.val).collect(Collectors.toList());
		List<Disk> res = Arrays.stream(disks).sorted(Comparator.comparingInt(d -> d.val)).collect(Collectors.toList());
		for (Disk re : res) {
			System.out.println(re.desc);
		}
	}
}

class Disk {
	String desc;
	int val;

	public Disk(String desc) {
		this.desc = desc;
		this.val = computer(desc);
	}

	private int computer(String desc) {
		int left = 0;
		int right = 0;
		int res = 0;
		//双指针解析字符串，需要重点掌握
		while (right < desc.length()) {
			char c = desc.charAt(right);
			if (Character.isDigit(c)) {
				right++;
				continue;
			} else {
				int num = Integer.parseInt(desc.substring(left, right));
				switch (c) {
					case 'M':
						res += num;
						break;
					case 'G':
						res += num * 1000;
						break;
					case 'T':
						res += num * 1000 * 1000;
				}
				right++;
				left = right;
			}
		}
		return res;
	}
}
