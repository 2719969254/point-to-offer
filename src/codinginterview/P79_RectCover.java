package codinginterview;

/**
 * 矩形覆盖
 *
 * 问题描述：
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，
 * 总共有多少种方法？
 *
 * 问题思路：
 * 当n=1的时候，只有一个2*1的矩形，所以只有一种方法，记为f(1)=1
 * 当n=2的时候，是两个2*1的矩形，这时候具有两种方式去覆盖这个矩形了（这时候应该是一个正方形），一种是竖着放，一种是横着放，所以有两种方法，记为f(2)=2
 * 当n=3的时候，仍然只能采用横着放或者竖着放的方式去覆盖这个矩形，
 * 我们仍首先考虑使用竖着放的方式，当竖着放的时候，由于已经覆盖了左边（假设是从左边开始覆盖的，从右边的覆盖的效果是一样的）一个2*1的矩形，所以还有2个2*1的矩形，而这种情况我们已经在n=2的时候计算出来了，就是f(2)；
 * 接下来我们考虑横着放的情况，由于是横着放，在水平方向已经覆盖了一个2*1的矩形，所以要想覆盖这由3个2*1组成的矩形，只能在水平方向的覆盖的那个矩形下面继续覆盖一个，那么只剩下一个2*1的矩形了，这也通过前面的分析计算出来了，就是f(1)。
 * 综合以上分析，当n=3的时候，覆盖的方法是f(3)=f(1)+f(2)
 * 其他以此类推，我们发现这仍然是一个斐波那契数列
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/23
 */
public class P79_RectCover {
	public int RectCover(int target) {
		if(target <= 0){
			return 1;
		}
		if(target == 1 || target == 2){
			return target;
		}
		return RectCover(target - 1) + RectCover(target - 2);
	}

	public static void main(String[] args) {
		P79_RectCover cover = new P79_RectCover();
		System.out.println("cover.RectCover(3) = " + cover.RectCover(3));
	}

}
