import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] ans = new int[T];
		
		for (int i=0; i<T; i++) {
			int max = Integer.MIN_VALUE;
					
			for (int j=0; j<10; j++) {
				int num = sc.nextInt();
				if (max < num) max = num;
			}
			
			ans[i] = max;
		}
		
		for (int i=0; i<T; i++)
			System.out.println("#" + (i+1) + " " + ans[i]);
		
		
	}
	
}