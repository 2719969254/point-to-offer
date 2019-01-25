package exercises;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/24
 */
public class Demo {
	public static void main(String[] args) {
		int begin = 777;
		// 如果猜对的话是翻倍。如果猜错扣555
		String str = "vxvxvxvxvxvxvvx";
		// 第一种方法，将字符串转换成字符数组
		/*char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == 'v') {
				begin = begin * 2;
			} else if (chars[i] == 'x') {
				begin = begin - 555;
			}else {
				System.out.println("你输入的字符串有问题");
			}
		}
		System.out.println("begin = " + begin);*/
		// 第二种方法
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == 'v') {
				begin = begin * 2;
			} else if (c == 'x') {
				begin = begin - 555;
			} else {
				System.out.println("你输入的字符串有问题");
			}
		}
		System.out.println("begin = " + begin);
	}
}
