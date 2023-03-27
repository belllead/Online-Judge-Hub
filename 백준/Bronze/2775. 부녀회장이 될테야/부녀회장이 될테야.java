import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int[][] apart = new int[k+1][n+1];
			
			for (int r=0; r<=k; r++) {
				for (int c=1; c<=n; c++) {
					if (r == 0) {
						apart[r][c] = c;
					} else if (c == 1) {
						apart[r][c] = 1;
					} else {
						apart[r][c] = apart[r][c-1] + apart[r-1][c];
					}
				}
			}
			System.out.println(apart[k][n]);
			
		}
	}
}