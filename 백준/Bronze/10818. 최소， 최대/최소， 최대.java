import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for (int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		
		System.out.printf("%d %d", min, max);
		
		
		
				
	}
}