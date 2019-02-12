package javabasic.reflect;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/10
 */
public class Robot {
	private String name;
	public void sayHi(String str){
		System.out.println(str+name);
	}
	private String throwHello(String tag){
		return "hello"+tag;
	}
}
