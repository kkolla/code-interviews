package sorting;

//http://www.cnblogs.com/yuzhangcmu/p/4177326.html
//inplace，并且O(N)时间复杂度的算法。
//1. 从左扫描到右边，遇到一个数字，先找到对应的bucket.比如
// 3 2 2 1 4
// 第一个3对应的bucket是index = 2 (bucket从0开始计算）
//2. Bucket 如果有数字，则把这个数字移动到i的position(就是存放起来），然后把bucket记为-1(表示该位置是一个计数器，计1）。
//3. Bucket 存的是负数，表示这个bucket已经是计数器，直接减1. 并把color[i] 设置为0 （表示此处已经计算过）
//4. Bucket 存的是0，与3一样处理，将bucket设置为-1， 并把color[i] 设置为0 （表示此处已经计算过）
//5. 回到position i，再判断此处是否为0（只要不是为0，就一直重复2-4的步骤）。
//6.完成1-5的步骤后，从尾部到头部将数组置结果。（从尾至头是为了避免开头的计数器被覆盖）
//例子(按以上步骤运算)：
//3 2 2 1 4
//2 2 -1 1 4
//2 -1 -1 1 4
//0 -2 -1 1 4
//-1 -2 -1 0 4
//-1 -2 -1 -1 0
public class SortColorsII {
	
	// O(n), because each element is only processed once
	public void sortColors2(int[] colors, int k) {
        for (int i = 0; i < colors.length; i++) {
        	if (colors[i] > 0) {
            	int j = colors[i] - 1;
            	if (colors[j] <= 0) { // j-th position is already a counter
            		colors[j]--;
            		colors[i] = 0; // mark i-th position is processed
            	} else {
            		colors[i] = colors[j];
            		colors[j] = -1;
            		i--;
            	}
        	}
        }
        
        for (int i = colors.length - 1; k > 0; k--) {
        	while (colors[k - 1] < 0) {
        		colors[k - 1]++;
        		colors[i--] = k;
        	}
        }
    }
}
