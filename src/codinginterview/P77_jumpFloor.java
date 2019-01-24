package codinginterview;

/**
 * 青蛙跳台阶问题
 * <p>
 * 如果只有一级台阶，只有一种跳法，如果有两级台阶，那就有两种跳法。
 * 将问题扩大化，如果有n级台阶，每一跳有两种可能
 * 如果第一次只跳一级台阶，那么跳法数目等于后面（n-1)的跳法数目
 * 如果第一次跳了两级台阶，那么跳法数目等于后面（n-2)的跳法数目
 * 因此，n级台阶的不同跳法 总数就等于f(n) = f(n-1) + f(n-2)
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/23
 */
public class P77_jumpFloor {

	/**
	 * 递归实现
	 *
	 * @param n
	 * @return
	 */
	public int jumpFloor(int n) {
		if (n == 1 || n == 2) {
			return n;
		} else {
			return jumpFloor(n - 1) + jumpFloor(n - 2);
		}
	}

	/**
	 * 非递归实现
	 */
	public int jumpFloor1(int n) {
		int preOne = 1;
		int preTwo = 2;
		int result = 0;
		if (n == 1 || n == 2) {
			return n;
		} else {
			for (int i = 3; i <= n; i++) {
				result = preOne + preTwo;
				preOne = preTwo;
				preTwo = result;
			}
			return result;
		}
	}

	public static void main(String[] args) {
		P77_jumpFloor jumpFloor = new P77_jumpFloor();
		System.out.println("jumpFloor.jumpFloor(5) = " + jumpFloor.jumpFloor(5));
		System.out.println("jumpFloor.jumpFloor1(5) = " + jumpFloor.jumpFloor1(5));

	}
}
