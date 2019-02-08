package exercises;

/**
 * 凑算式
 *
 * @author 33188
 */

public class Equation {
	public static void main(String[] args) {
		//获取开始时间
		long startTime = System.nanoTime();
		// 最初为0
		int sum = 0;
		// 对九个字母进行循环
		for (double a = 1; a < 10; a++) {
			for (double b = 1; b < 10; b++) {
				if (b != a)
					for (double c = 1; c < 10; c++) {
						if (c != a && c != b)
							for (double d = 1; d < 10; d++) {
								if (d != a && d != b && d != c)
									for (double e = 1; e < 10; e++) {
										if (e != a && e != b && e != c && e != d)
											for (double f = 1; f < 10; f++) {
												if (f != a && f != b && f != c && f != d && f != e)
													for (double g = 1; g < 10; g++) {
														if (g != a && g != b && g != c && g != d && g != e && g != f)
															for (double h = 1; h < 10; h++) {
																if (h != a && h != b && h != c && h != d && h != e && h != f && h != g)
																	for (double i = 1; i < 10; i++) {
																		if (i != a && i != b && i != c && i != d && i != e && i != f && i != g && i != h) {
																			double m1 = (d * 100 + e * 10 + f);
																			double m2 = (g * 100 + h * 10 + i);
																			if (a + (b * 1.0 / c) + (m1 * 1.0 / m2) == 10.0) {
																				System.out.println(a + "-" + b + "-" + c + "-" + d + "-" + e + "-" + f + "-" + g + "-" + h + "-" + i);
																				sum++;
																			}
																		}
																	}
															}
													}
											}
									}
							}
					}
			}
		}
		System.out.println("sum = " + sum);
		// 获取结束时间
		long endTime = System.nanoTime();
		System.out.println("程序运行时间： " + (endTime - startTime) + "ns");
	}
}
