import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int[] parent;
	static double E;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			double[] x = new double[N];
			double[] y = new double[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				x[i] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				y[i] = Integer.parseInt(st.nextToken());

//			System.out.println(Arrays.toString(x));
//			System.out.println(Arrays.toString(y));

			E = Double.parseDouble(br.readLine());

			// 입력 완료
			
			// 정점 배열 만들기
			double[][] vertex = new double[N][2];
			for (int i = 0; i < N; i++) {
				vertex[i] = new double[] { x[i], y[i] };
			}

			// 간선 리스트 만들기
			List<double[]> edge = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i != j) {
						edge.add(new double[] { i, j, getCost(vertex[i], vertex[j]) });
					}
				}
			}
			
			// 간선 리스트 정렬
			Collections.sort(edge, new Comparator<double[]>() {

				@Override
				public int compare(double[] o1, double[] o2) {
					return Double.compare(o1[2], o2[2]);
				}
				
			});
			
			// 간선 리스트 출력
//			for (double[] d : edge)
//				System.out.println(Arrays.toString(d));
			
			// makeSet
			parent = new int[N];
			for (int i=0; i<N; i++) {
				parent[i] = i;
			}
			
			double cost = 0;
			int tunnel = 0;
			
			for (double[] e : edge) {
				int px = findSet((int) e[0]);
				int py = findSet((int) e[1]);
				if (px != py) {
					union(px, py);
					cost += e[2];
					tunnel++;
				}
				
				if (tunnel == N-1) break;
			}
			
			long ans = (long) (Math.round(cost));
			
			sb.append("#" + tc + " ");
			sb.append(ans);
			sb.append("\n");
		}
		System.out.println(sb);
	} // main

	private static double getCost(double[] a, double[] b) {
		return E * Math.pow(Math.sqrt(Math.pow(a[0]-b[0], 2) + Math.pow(a[1]-b[1], 2)), 2);
	}

	static int findSet(int element) {
		if (parent[element] != element) {
			parent[element] = findSet(parent[element]);
		}
		
		return parent[element];
	} // findSet

	static void union(int x, int y) {
		parent[y] = x;
	} // union
}