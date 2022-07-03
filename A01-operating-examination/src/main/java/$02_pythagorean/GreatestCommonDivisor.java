package $02_pythagorean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GreatestCommonDivisor {
	public int greatestCommonDivisor(int a, int b) {
		//a能被b整除，说明最大公约数就是b
		if (a % b == 0) {
			return b;
		}
		//如果不能整除。看较小数与余数是否能整除
		return greatestCommonDivisor(b, a % b);
	}

	@Test
	public void test() {
		Assertions.assertEquals(3, greatestCommonDivisor(15, 6));
		Assertions.assertEquals(3, greatestCommonDivisor(6, 15));
		Assertions.assertEquals(1, greatestCommonDivisor(5, 6));
	}
}


