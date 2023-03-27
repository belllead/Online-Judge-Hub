import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int N, minSDiff;
	static int[][] S;
	static int[] ingri1, ingri2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			S = new int[N][N];
			
			ingri1 = new int[N/2];
			ingri2 = new int[N/2];
			
			for (int r=0; r<N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c=0; c<N; c++) {
					S[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
//			for (int[] i : S)
//				System.out.println(Arrays.toString(i));
			minSDiff = Integer.MAX_VALUE;
			combi(0, 0);
			
			sb.append("#" + tc + " ");
			sb.append(minSDiff);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void combi(int idx, int sidx) {
		
		if (sidx >= N/2) {
//			System.out.println("ingri1: " + Arrays.toString(ingri1));
			int[][] ingris = ingri(ingri1);
			
//			for (int[] i : ingris)
//				System.out.println(Arrays.toString(i));
			
			int s1 = getSynergy(ingris[0]);
			int s2 = getSynergy(ingris[1]);
//			System.out.println(s1);
//			System.out.println(s2);
			minSDiff = Math.min(minSDiff, Math.abs(s1-s2));
			return;
		}

		if (idx == N) {
			return;
		}
		
		ingri1[sidx] = idx+1;
		combi(idx+1, sidx+1);
		combi(idx+1, sidx);
		
	}
	
	static int[][] ingri(int[] ingri1) {
		List<Integer> tempList = new ArrayList<>();
		
		for (int i=1; i<=N; i++) {
			tempList.add(i);
		}

		for (int i=0; i<N/2; i++) {
			tempList.remove(tempList.indexOf(ingri1[i]));
		}
		
//		System.out.println("ingri2: " + tempList);
//		System.out.println();
		
		int[] ingri2 = new int[N/2];
		for (int i=0; i<N/2; i++)
			ingri2[i] = tempList.get(i);
		
		return new int[][] {ingri1, ingri2};
	}
	
	static int getSynergy(int[] ingri) {
		int syn = 0;
		
		for (int i=0; i<N/2; i++) {
			for (int j=0; j<N/2; j++) {
				syn += S[ingri[i]-1][ingri[j]-1];
			}
		}
		
		return syn;
	}
}