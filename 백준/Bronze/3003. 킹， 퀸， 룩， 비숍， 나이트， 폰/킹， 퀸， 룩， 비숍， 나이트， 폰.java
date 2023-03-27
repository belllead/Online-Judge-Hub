import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] chess = {1, 1, 2, 2, 2, 8};
		int[] in = new int[chess.length];
		
		for (int i=0; i<6; i++) {
			in[i] = sc.nextInt();
			System.out.printf("%d ", chess[i] - in[i]);
		}
		
	}
}