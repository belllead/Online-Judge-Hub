import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int cnt;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static int[] hackComNum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N+1];
		
		for (int i=0; i<N+1; i++)
			adjList[i] = new ArrayList<Integer>();
				
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adjList[a].add(b);
		}
		
		hackComNum = new int[N+1];
		
		for (int i=1; i<N+1; i++) {
			visited = new boolean[N+1];
			visited[i] = true;
			dfs(i);
//			System.out.println(Arrays.toString(visited));
		}
		
		int max = 0;
		for (int i=1; i<N+1; i++) {
			max = Math.max(max, hackComNum[i]);
		}
		
		for (int i=1; i<N+1; i++) {
			if (hackComNum[i] == max)
				sb.append(i + " ");
		}
		
//		for (Node n : adjList)
//			System.out.println(n);

//		System.out.println(Arrays.toString(hackComNum));
		
		System.out.println(sb);
	}
	
	static void dfs(int a) {
		for (int i : adjList[a]) {
			
			if (!visited[i]) {
//			System.out.println(node + " -> " + node.data);
				hackComNum[i]++;
				visited[i] = true;
				if (adjList[i] != null)
					dfs(i);
			}
		}
	}
}