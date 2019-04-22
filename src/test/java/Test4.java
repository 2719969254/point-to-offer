import javax.sound.midi.Soundbank;
import java.util.Scanner;

/**
 * @author VicterTian
 * @version V1.0
 * @date 2019/4/14
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] arr = new int[len];
        for (int i = 0;i<len;i++){
            arr[i] = scanner.nextInt();
        }
        for (int count = 100;count<=1000000000;count++){
            int flag = count;
            for (int i = 0; i < len; i++) {
                if (arr[i]>flag){
                    flag -= arr[i]-flag;
                }else {
                    flag += flag-arr[i];
                }
                if (flag<=0){
                    break;
                }
                if (i==len-1){
                    System.out.println(count);
                    return;
                }
            }
        }
    }
}
