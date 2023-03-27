import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static int N;
	static char[][] arr;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = sc.nextInt();
		
		arr = new char[N][N];
		
		printStar(N, 0, 0);
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				if (arr[r][c] == '\u0000')
					sb.append(" ");
				else sb.append(arr[r][c]);
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		sc.close();
		bw.close();
	}
	
	static void printStar(int a, int startR, int startC) {
		if (a == 3) {
			for (int r=startR; r<startR+3; r++) {
				for (int c=startC; c<startC+3; c++) {
					if (!(r == startR + 1 && c == startC + 1))
						arr[r][c] = '*';
				}
			}			
			return;
		}
		
		for (int r=startR; r<startR+a; r+=a/3) {
			for (int c=startC; c<startC+a; c+=a/3) {
				if (!(r == startR + a/3 && c == startC + a/3))
					printStar(a/3, r, c);
			}
		}
	}
	
}