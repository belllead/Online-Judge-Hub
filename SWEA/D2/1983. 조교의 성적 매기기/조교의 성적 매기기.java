import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int T, N, midTerm, finalTerm, assign, K;
	static int[][] score;	
	static double[] grade;
	static int[] rank;
	static String[] gradeName = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			score = new int[N][3];
			grade = new double[N];
			rank = new int[N];
			
			for (int stu=0; stu<N; stu++) {
				st = new StringTokenizer(br.readLine());
				for (int i=0; i<3; i++) {
					score[stu][i] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("#" + tc + " ").append(noyeah(score, K-1)).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static String noyeah(int[][] score, int student) {
		
		for (int stu=0; stu<N; stu++) {
			grade[stu] = score[stu][0] * .35 + score[stu][1] * .45 + score[stu][2] * .2;
		}
		
		for (int stu=0; stu<N; stu++) {
			for (int i=0; i<N; i++) {
				if (grade[stu] < grade[i])
					rank[stu]++;
			}
		}
		
		
//		0 N/10 2N/10 ... N*N/10
		for (int i=N-1; i>=0; i--) {
			if (rank[student] >= i*N/10 && rank[student] < (i+1)*N/10) {
				return gradeName[i];
			}
		}
		
		return null;		
	}
	
}