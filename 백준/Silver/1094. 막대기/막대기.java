import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int x;
	static int stick;
	static int left;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		x = Integer.parseInt(br.readLine());
		stick = 1<<6;
		left = 0;
		System.out.println(Integer.bitCount(cut(stick)) + left);
	}
	static int cut(int i) {
		if (i == x) {
			return i;
		}
//		if(i > x) {
		int min = (i & (-i)) >> 1;
		int temp = i & (i - 1);
		if (min + temp < x) {
			x -= min;
			left++;
		}
		return cut(min + temp);
//		} else {

//		if(i+left==x) {
//			return i;
//		}
//		if(i+left>x) {
//			int temp = i&i-1;
//			int min = (temp&-temp)>>1;
//			if(min + temp+left>=x) {
//				return cut(min + temp);
//			}else {
//				left = min;
//				return cut(temp + min);
//			}
//		}
	}
}

// 64 -> 32 32 ->
