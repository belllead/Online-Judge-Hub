import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	
	static List<Integer>[] adjList;
	static int[] inDegree;
	static boolean[] visited;
	static int V;
	static Stack<Integer> stack = new Stack<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc=1; tc<=10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			adjList = new ArrayList[V+1];
			for (int i=0; i<V+1; i++)
				adjList[i] = new ArrayList<>();
			
			inDegree = new int[V+1];
			visited = new boolean[V+1];
			
			st = new StringTokenizer(br.readLine());
			while (E-- > 0) {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				
				adjList[s].add(e);
				inDegree[e]++;
			}
			
			sb.append("#" + tc + " ");
			
			topoQ();
			
			for (int i=1; i<V+1; i++) {
				if (!visited[i] && inDegree[i] == 0)
					topoS(i);
			}
			
//			while (!stack.isEmpty())
//				sb.append(stack.pop() + " ");
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void topoQ() {
		Queue<Integer> q = new ArrayDeque<>();
		
		for (int v=1; v<V+1; v++) {
			if (inDegree[v] == 0) {
				q.offer(v);
			}
		}
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			sb.append(curr + " ");
			
			for (int v : adjList[curr]) {
				inDegree[v]--;
				
				if (inDegree[v] == 0)
					q.offer(v);
			}
		}
	}
	
	static void topoS(int v) {
		visited[v] = true;
		
		for (int u : adjList[v]) {
			if (!visited[u])
				topoS(u);
		}
		
		stack.push(v);
	}
}