import java.util.Scanner;

public class Main {

	static int N, M, L, cnt;
	static int[] caught;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		L = sc.nextInt();
		
		caught = new int[N];
		
		pass(0);
		
		System.out.println(cnt-1);
	}
	
	static void pass(int person) {
		cnt++;
		caught[person]++;
		
		if (caught[person] == M)
			return;
		
		
		if (caught[person] % 2 == 0) {
			int t = person - L >= 0 ? person - L : person - L + N;
			pass(t);
		} else {
			pass((person + L) % N);
		}
			
			
	}
}