import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] line = new int[N+1];
		
		for (int i=1; i<N+1; i++) {
			line[i] = i;
		}
		
		for (int i=1; i<N+1; i++) {
			int pick = sc.nextInt();
			
			for (int j=i; j>=i-pick+1; j--) {
				int temp = line[j];
				line[j] = line[j-1];
				line[j-1] = temp;
			}
		}
		
		for (int i=1; i<N+1; i++)
			System.out.print(line[i] + " ");
		
		sc.close();
	}
}