import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] farm = new int[N][N];
			for(int r=0; r<N; r++) {
				String s = br.readLine();
				for (int c=0; c<N; c++) {
					farm[r][c] = Integer.parseInt(s.substring(c, c+1));
					
				}
			}
			
			int sum = 0;
			
			for(int r=0; r<N; r++) {
				int temp = N/2-Math.abs(N/2-r);
				for (int c=N/2-temp; c<=N/2+temp; c++) {
//					System.out.print(farm[r][c]);
					sum += farm[r][c];
				}
//				System.out.println();
			}
			
			sb.append("#" + tc + " ").append(sum).append("\n");
		
			
		}
		System.out.println(sb.toString());
		
		
		
		
	}
}