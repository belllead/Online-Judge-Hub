import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] score = new int[N][3];
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<3; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dpMax = new int[N][3];
		int[][] dpMin = new int[N][3];
		for (int i=0; i<3; i++) {
			dpMax[0][i] = score[0][i];
			dpMin[0][i] = score[0][i];
		}
		
		if (N > 1) {
			for (int i=1; i<N; i++) {
				dpMax[i][0] = Math.max(dpMax[i-1][0], dpMax[i-1][1]) + score[i][0];
				dpMax[i][1] = Math.max(dpMax[i-1][0], Math.max(dpMax[i-1][1], dpMax[i-1][2])) + score[i][1];
				dpMax[i][2] = Math.max(dpMax[i-1][1], dpMax[i-1][2]) + score[i][2];

				dpMin[i][0] = Math.min(dpMin[i-1][0], dpMin[i-1][1]) + score[i][0];
				dpMin[i][1] = Math.min(dpMin[i-1][0], Math.min(dpMin[i-1][1], dpMin[i-1][2])) + score[i][1];
				dpMin[i][2] = Math.min(dpMin[i-1][1], dpMin[i-1][2]) + score[i][2];
			}
		}

		int max = Math.max(dpMax[N-1][0], Math.max(dpMax[N-1][1], dpMax[N-1][2]));
		int min = Math.min(dpMin[N-1][0], Math.min(dpMin[N-1][1], dpMin[N-1][2]));
		
		System.out.println(max + " " + min);
		
	}
	
}