import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int index = 1;
		int room = 1;
		
		for (int i=0; i<N; i++) {
			index += 6*i;
			if (N > index) {
				continue;
			} else {
				room = i+1;
				break;
			}	
		}
		
		System.out.println(room);
		
		sc.close();
	}
}