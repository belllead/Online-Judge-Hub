import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int maxR = 0;
		int maxCIdx = 0;
		int maxC = 0;
		
		int[] row = new int[N];
		int[] col = new int[N];
		int idx = 0;
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			row[idx] = Integer.parseInt(st.nextToken());
			col[idx] = Integer.parseInt(st.nextToken());
						
			maxR = Math.max(maxR, row[idx]);
			
			if (maxC < col[idx]) {
				maxC = col[idx];
				maxCIdx = idx;
			}
			
			idx++;
		}
		
		int[][] warehouse = new int[maxR+1][maxC+1];
		
		for (int i=0; i<N; i++) {
			for (int c=0; c<col[i]; c++) {
				warehouse[row[i]][c] = 1;
			}
		}
		
		for (int r=1; r<row[maxCIdx]; r++) {
			for (int c=0; c<maxC+1; c++) {
				if (warehouse[r-1][c] == 1) {
					warehouse[r][c] = 1;
				}
			}
		}
		
		for (int r=maxR-1; r>=row[maxCIdx]+1; r--) {
			for (int c=0; c<maxC+1; c++) {
				if (warehouse[r+1][c] == 1) {
					warehouse[r][c] = 1;
				}
			}
		}
		
//		for (int[] i : warehouse)
//			System.out.println(Arrays.toString(i));
		
		int sum = 0;
		for (int r=0; r<maxR+1; r++) {
			for (int c=0; c<maxC+1; c++) {
				sum += warehouse[r][c];
			}
		}
		
		System.out.println(sum);
						
					
			
		
	}
}