import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
		int e, w;

		public Node(int e, int w) {
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}

		@Override
		public String toString() {
			return "Node [e=" + e + ", w=" + w + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		List<Node>[] adjList = new ArrayList[V+1];
		for (int i=0; i<V+1; i++) 
			adjList[i] = new ArrayList<>();
		
		while (E-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adjList[s].add(new Node(e, w));
			adjList[e].add(new Node(s, w));
		}
		// 입력 완료
		
//		for (List<Node> l : adjList)
//			System.out.println(l);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		
		pq.addAll(adjList[1]);
		visited[1] = true;
		int pick = 1;
		int cost = 0;
		
		while (pick != V) {
			Node curr = pq.poll();
			
			if (visited[curr.e]) continue;
			
			visited[curr.e] = true;
			
			cost += curr.w;
			
			for (Node n : adjList[curr.e]) {
				pq.offer(n);
			}
			
			pick++;
		}
		
		System.out.println(cost);
	}
}