import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int mul = A * B * C;
		
		String s = Integer.toString(mul);
		
		int[] arr = new int[s.length()];
		int[] cnt = new int[10];
		
		for (int i=0; i<s.length(); i++) {
			arr[i] = Integer.parseInt(s.substring(i, i+1));
			cnt[arr[i]]++;
		}
		
		for (int i=0; i<10; i++) {
			System.out.println(cnt[i]);
		}
		
		
		
		
		
		
		
		
	}
}