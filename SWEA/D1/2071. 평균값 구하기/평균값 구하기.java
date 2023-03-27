import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] ans = new int[T];
		
		for (int i=0; i<T; i++) {
			double sum = 0;
					
			for (int j=0; j<10; j++) {
				int num = sc.nextInt();
					sum += num;
			}
			
			ans[i] = (int) Math.round(sum / 10);
		}
		
		for (int i=0; i<T; i++)
			System.out.println("#" + (i+1) + " " + ans[i]);
		
	}
	
}