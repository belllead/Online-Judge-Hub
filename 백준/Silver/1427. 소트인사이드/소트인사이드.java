import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		
		char[] arr = N.toCharArray();
		int[] ans = new int[N.length()];
		
		for (int i=0; i<arr.length; i++) {
			ans[i] = arr[i] - '0';
		}
		
		for (int i=0; i<ans.length; i++) {
			int minIndex = i; 
			for (int j=i+1; j<ans.length; j++) {
				if (ans[minIndex] < ans[j]) {
					minIndex = j;
				}
			}
			int temp = ans[i];
			ans[i] = ans[minIndex];
			ans[minIndex] = temp;
		}
		
		for (int i=0; i<ans.length; i++) {
			System.out.print(ans[i]);
		}
		
		
	}
}