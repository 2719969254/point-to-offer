import java.util.Scanner;

/**
 * @author VicterTian
 * @version V1.0
 * @date 2019/4/14
 */
public class Test5 {
    public static void main(String[] args) {
        int[][] arr = new int[10][10];
        Scanner sc = new Scanner(System.in);
        int row = 0;
        int col = 0;
        int count = 0;
        int minCount = 0;
        String numLine;
        while (true) {
            numLine = sc.nextLine();
            if (numLine.equals("")) {
                break;
            }
            String[] split = numLine.split(" ");
            col = 0;
            for (String numStr : split) {
                if (Integer.valueOf(numStr) == 1){
                    count++;
                }
                arr[row][col++] = Integer.valueOf(numStr);
            }
            row++;
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                if (arr[i][j] == 2) {
                    try {
                        if (arr[i + 1][j] == 1) {
                            arr[i + 1][j] = -1;
                            count--;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                    try {
                        if (arr[i - 1][j] == 1) {
                            arr[i - 1][j] = -1;
                            count--;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                    try {
                        if (arr[i][j + 1] == 1) {
                            arr[i][j + 1] = -1;
                            count--;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                    try {
                        if (arr[i][j - 1] == 1) {
                            arr[i][j - 1] = -1;
                            count--;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                    minCount++;
                }
                if (count == 0){
                    System.out.println(minCount);
                    return;
                }

                for (int m = 0; m < 10; m++) {
                    for (int n = 0; n < 10; n++) {
                        if (arr[m][n] == -1){
                            arr[m][n] = 2;
                        }
                    }
                }

            }
        }
        System.out.println(-1);
    }
}
