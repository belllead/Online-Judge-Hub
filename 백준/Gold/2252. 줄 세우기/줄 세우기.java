import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] adjList = new ArrayList[N+1];
		for (int i=0; i<N+1; i++)
			adjList[i] = new ArrayList<>();
		
		int[] inDegree = new int[N+1];
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			adjList[s].add(e);
			inDegree[e]++;
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		
		for (int v=1; v<N+1; v++) {
			if (inDegree[v] == 0) {
				q.offer(v);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			sb.append(curr + " ");
			
			for (int v : adjList[curr]) {
				inDegree[v]--;
				if (inDegree[v] == 0)
					q.offer(v);
			}
		}
		System.out.println(sb);
	}
}