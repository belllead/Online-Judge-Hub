import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] adjList = new ArrayList[N+1];
		for (int i=1; i<N+1; i++)
			adjList[i] = new ArrayList<>();
		
		int[] inDegree = new int[N+1];
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			adjList[s].add(e);
			inDegree[e]++;
		}
		//입력완료
		
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i=1; i<N+1; i++) {
			if (inDegree[i] == 0)
				pq.offer(i);
		}
		
		while (!pq.isEmpty()) {
			int curr = pq.poll();
			
			sb.append(curr + " ");
			
			for (int v : adjList[curr]) {
				inDegree[v]--;
				
				if (inDegree[v] == 0)
					pq.offer(v);
			}
		}
		System.out.println(sb);
	}
}