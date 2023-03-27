import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append("\n");
			
			int N = Integer.parseInt(in.readLine());
			int[][] tri = new int[N][N];
			
			for (int r=0; r<N; r++) {
				tri[r][0] = 1;
				tri[r][r] = 1;
				if (r>=2) {
					for (int c=1; c<r; c++) {
						tri[r][c] = tri[r-1][c-1] + tri[r-1][c];
					}
				}
			}
			
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					if (tri[r][c] != 0) {
						sb.append(tri[r][c]).append(" ");
					}
				}
				sb.append("\n");
			}
			
		}
		System.out.println(sb.toString());
		
	}
	
}

//0
//0, 1
//0, 1, 2
//0, 1, 2, 3
//0, 1, 2, 3, 4
//[r+1][c+1] = [r][c] + [r][c+1]