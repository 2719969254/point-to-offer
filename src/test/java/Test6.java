import java.util.Scanner;
import java.util.Stack;

/**
 * @author VicterTian
 * @version V1.0
 * @date 2019/4/17
 */
public class Test6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        StringBuffer stringBuffer = new StringBuffer();
        while (num != 0) {
            stack.push(num % 15);
            num = num / 15;
        }
        while (stack.size() > 0) {
            Integer pop = stack.pop();
            if (pop >= 10 && pop <= 15) {
                stringBuffer.append((char) (pop + 55));
            } else {
                stringBuffer.append(pop);
            }
        }
        System.out.println(stringBuffer);
    }
}
