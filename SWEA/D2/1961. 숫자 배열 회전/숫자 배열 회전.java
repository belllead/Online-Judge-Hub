import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] arr, rotatedArr;
	
	public static void main(String[] args) throws IOException {
		
		int T = Integer.parseInt(in.readLine());
		StringBuilder ans = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			ans.append("#" + tc + "\n");

			int N = Integer.parseInt(in.readLine());
			arr = new int[N][N];
			
			for (int r=0; r<N; r++) {
				st = new StringTokenizer(in.readLine());
				for (int c=0; c<N; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] r90 = rotate(arr, N);
			int[][] r180 = rotate(r90, N);
			int[][] r270 = rotate(r180, N);
			
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					ans.append(r90[r][c]);				
				}
				ans.append(" ");
				for (int c=0; c<N; c++) {
					ans.append(r180[r][c]);				
				}
				ans.append(" ");
				for (int c=0; c<N; c++) {
					ans.append(r270[r][c]);				
				}
				ans.append("\n");
			}			
		}	
		System.out.println(ans.toString());
	}
	
	public static int[][] rotate(int[][] arr, int N) throws IOException {
		rotatedArr = new int[N][N];
				
		for (int r=0, rc=0; r<N; r++, rc++) {
			for (int c=0, rr=N-1; c<N; c++, rr--) {
				rotatedArr[r][c] = arr[rr][rc];					
			}
		}
		
		return rotatedArr;
	}
	
}



//00 01  10 00
//10 11  11 01

//00 01 02   20 10 00
//10 11 12   21 11 01
//20 21 22   22 12 02