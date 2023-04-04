import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static Stack<Integer> dfs = new Stack<>();
	static boolean[] visited;
	static List<Integer>[] adjList;
	static String s1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			
			int[] team = new int[N+1];
			visited = new boolean[N+1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=1; i<N+1; i++) {
				team[i] = Integer.parseInt(st.nextToken()); 
			}
			
			adjList = new ArrayList[N+1];
			for (int i=0; i<N+1; i++)
				adjList[i] = new ArrayList<>();
			
			int[] inDegree = new int[N+1];
			
			for (int i=1; i<N; i++) {
				for (int j=i+1; j<N+1; j++) {
					adjList[team[j]].add(team[i]);
					inDegree[team[i]]++;
				}
			}
			
//			System.out.println(Arrays.toString(inDegree));
			
//			for (List<Integer> l : adjList)
//				System.out.println(l);
			
			int M = Integer.parseInt(br.readLine());
			
			while (M-- > 0) {
				st = new StringTokenizer(br.readLine());
				int c1 = Integer.parseInt(st.nextToken()); 
				int c2 = Integer.parseInt(st.nextToken());

				if (adjList[c2].contains(c1)) {
					for (int i=0; i<adjList[c2].size(); i++) {
						if (adjList[c2].get(i) == c1) {
							adjList[c2].remove(i);
							inDegree[c1]--;
							adjList[c1].add(c2);
							inDegree[c2]++;
							break;
						}
					}
				} else {
					for (int i=0; i<adjList[c1].size(); i++) {
						if (adjList[c1].get(i) == c2) {
							adjList[c1].remove(i);
							inDegree[c2]--;
							adjList[c2].add(c1);
							inDegree[c1]++;
							break;
						}
					}
				}
				
			}
			
//			System.out.println(Arrays.toString(inDegree));
//			
//			for (List<Integer> l : adjList)
//				System.out.println(l);
			
			// 입력완료
			
			Queue<Integer> q = new ArrayDeque<>();
			Stack<Integer> stack = new Stack<>();
			
			for (int v=1; v<N+1; v++) {
				if (inDegree[v] == 0)
					q.offer(v);
			}
			
			int isPossible = 0;
			
			while (!q.isEmpty()) {
				int curr = q.poll();

				stack.push(curr);
				isPossible++;
				
				for (int v : adjList[curr]) {
					inDegree[v]--;
					
					if (inDegree[v] == 0)
						q.offer(v);
				}
			}
			
			
			
			if (isPossible == N) {
				s1 = "";
				
				for (int i=1; i<N+1; i++) {
					if (!visited[i] && inDegree[i] == 0)
						topoDfs(i);
				}
				
				String s2 = "";
				
				while (!stack.isEmpty())
					s2 += stack.pop() + " ";
				
				if (s1.equals(s2))
					sb.append(s2 + "\n");
				else 
					sb.append("?\n");
					
			} else {
				sb.append("IMPOSSIBLE\n");
			}
		}
		System.out.println(sb);
	}
	
	static void topoDfs(int v) {
		visited[v] = true;
		
		for (int i : adjList[v]) {
			if (!visited[i])
				topoDfs(i);
		}
		
		s1 += v + " ";
	}
}