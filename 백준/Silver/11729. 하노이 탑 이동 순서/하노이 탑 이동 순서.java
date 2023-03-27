import java.util.Scanner;

public class Main {
	static int start = 1, detour = 2, target = 3, move = 0;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		start = N;
		
		hanoiTower(N, 1, 2, 3);
		
		System.out.println(move);
		System.out.println(sb);
	}
	
	static void hanoiTower(int n, int start, int detour, int target) {
		if (n == 1) {
			move++;
			sb.append(start + " ").append(target + "\n");
			return;
		}
		
		hanoiTower(n-1, start, target, detour);
		sb.append(start + " ").append(target + "\n");
		move++;
		hanoiTower(n-1, detour, start, target);			
	}
}