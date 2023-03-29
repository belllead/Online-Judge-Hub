import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] element, parent, rank;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			element = new int[N+1];
			parent = new int[N+1];
			rank = new int[N+1];

			for (int i=0; i<N+1; i++)
				parent[i] = i;
			
			sb.append("#" + tc + " ");
			
			while (M-- > 0) {
				st = new StringTokenizer(br.readLine());
				int order = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				int px = findSet(x);
				int py = findSet(y);
				
				switch (order) {
				case 0:
					union(px, py);
					break;
				case 1:
					if (px == py)
						sb.append(1);
					else sb.append(0);
					break;
				}
			}
			
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static int findSet(int element) {
//		if (parent[element] == element)
//			return element;
//		
//		return findset(parent[element]);
		
		if (parent[element] != element) {
			parent[element] = findSet(parent[element]);
		}
		
		return parent[element];
	}

	static void union(int x, int y) {
//		if (rank[x] > rank[y]) {
//			parent[findSet(y)] = findSet(x);
//		} else {
//			parent[findSet(x)] = findSet(y);
//			
//			if (rank[findSet(x)] == rank[findSet(y)])
//				rank[findSet(y)]++;
//		}
		
		if (rank[x] > rank[y]) {
			parent[y] = x;
		} else {
			parent[x] = y;
			
			if (rank[x] == rank[y])
				rank[y]++;
		}
	}
}