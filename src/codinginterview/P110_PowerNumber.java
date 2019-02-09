package codinginterview;

/**
 * 数值的整数次方
 * <p>
 * 实现函数double power（double base，int exponent），求base的exponent次方。不能使用库函数，不需要考虑大数问题。
 * 可能我们的第一想法永远是利用循环进行求值，如果要考虑到0和整数，可以将指数先求绝对值，然后算出结果后取倒数。
 * 既然要求倒数，我们很自然的想到，有没有可能对0取倒数
 * 同时需要说明，0的零次方是没有意义的，返回0或者1都可以
 * 这样的话 我们可能需要循环指数-1次
 * <p>
 * 如果输入的指数是32.那么需要循环31次，我们换一种思路：
 * 我们的目标是求一个数字的32次方，如果我们知道它的16次方，那么只要在16次方的基础上在平方就可以了
 * 而16是8次方的平方，以此类推，求32次方只需要做5次乘法
 * 如果是奇数，则再多求一次乘法
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/9
 */
public class P110_PowerNumber {
	private static boolean invalidInput = false;

	private static double power(double base, int exponent) {
		if (exponent == 0) {
			return 1;
		}
		if (exponent == 1) {
			return base;
		}
		if (exponent < 0) {
			if (equal(base, 0)) {
				invalidInput = true;
				return -1;
			} else {
				return 1.0 / powerWithPositiveExponent(base, -1 * exponent);
			}
		} else {
			return powerWithPositiveExponent(base, exponent);
		}
	}

	private static double powerWithPositiveExponent(double base, int exponent) {
		if (exponent == 0) {
			return 1;
		}
		if (exponent == 1) {
			return base;
		}
		double result = powerWithPositiveExponent(base, exponent >> 1);
		result = result * result;
		// 用位于运算代替取余符号判断一个数是偶数还是奇数
		if ((exponent & 0x1) == 1) {
			result = base * result;
		}
		return result;

	}

	private static boolean equal(double base, int i) {
		return -0.00001 < base - i && base - i < 0.00001;
	}

	public static void main(String[] args) {
		System.out.println("2^3=" + power(2, 3) + "\t是否报错:" + invalidInput);
		System.out.println("2^-3=" + power(2, -3) + "\t是否报错:" + invalidInput);
		System.out.println("0^3=" + power(0, 3) + "\t是否报错:" + invalidInput);
		System.out.println("0^-3=" + power(0, -3) + "\t是否报错:" + invalidInput);
	}
}
