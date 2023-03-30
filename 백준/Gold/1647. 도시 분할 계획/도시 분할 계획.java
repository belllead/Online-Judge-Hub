import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
		int tar, w;

		public Node(int tar, int weight) {
			super();
			this.tar = tar;
			this.w = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}

		@Override
		public String toString() {
			return "Node [tar=" + tar + ", w=" + w + "]";
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Node>[] adjList = new ArrayList[N+1];
		for (int i=0; i<N+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adjList[s].add(new Node(e, w));
			adjList[e].add(new Node(s, w));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		
		pq.addAll(adjList[1]);
		visited[1] = true;
		
		int pick = 1;
		int cost = 0;
		int max = 0;
		
		while (pick != N) {
			Node curr = pq.poll();
			
			if (visited[curr.tar]) continue;
			
			visited[curr.tar] = true;
			cost += curr.w;
			max = Math.max(max, curr.w);
			pq.addAll(adjList[curr.tar]);
			pick++;
			
		}
		
		System.out.println(cost - max);
		
	}
	
}