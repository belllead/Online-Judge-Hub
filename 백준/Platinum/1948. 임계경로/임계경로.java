import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int city, w;

		public Node(int city, int w) {
			super();
			this.city = city;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Node [city=" + city + ", w=" + w + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		List<Node>[] adjList = new ArrayList[N+1];
		for (int i=0; i<N+1; i++) 
			adjList[i] = new ArrayList<>();

		List<Node>[] bwdAdjList = new ArrayList[N+1];
		for (int i=0; i<N+1; i++) 
			bwdAdjList[i] = new ArrayList<>();
		
		int[] inDegree = new int[N+1];
		int[] wait = new int[N+1];
		
		while (M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adjList[s].add(new Node(e, w));
			bwdAdjList[e].add(new Node(s, w));
			inDegree[e]++;
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int startCity = Integer.parseInt(st.nextToken());
		int endCity = Integer.parseInt(st.nextToken());
		
//		System.out.println(Arrays.toString(inDegree));
//		
//		for (List<Node> l : adjList)
//			System.out.println(l);

		// 입력완료
		
		Queue<Node> q = new ArrayDeque<>();
		
		q.offer(new Node(startCity, 0));
		
		while (!q.isEmpty()) {
			Node curr = q.poll();
			
			for (Node n : adjList[curr.city]) {
				inDegree[n.city]--;
				
				wait[n.city] = Math.max(wait[n.city], wait[curr.city] + n.w);
				
				if (inDegree[n.city] == 0)
					q.offer(n);
			}
		}
		
//		System.out.println(Arrays.toString(wait));
		
		Queue<Node> bq = new ArrayDeque<>();
		boolean visited[] = new boolean[N+1];
		
		bq.offer(new Node(endCity, 0));
		
//		for (List<Node> l : bwdAdjList)
//			System.out.println(l);
		
		int cnt = 0;
		
		while (!bq.isEmpty()) {
			Node curr = bq.poll();
			
			for (Node n : bwdAdjList[curr.city]) {
				if (wait[n.city] == wait[curr.city] - n.w) {
					cnt++;
					
					if (!visited[n.city]) {
						visited[n.city] = true;
						bq.offer(n);
					}
				}
			}
		}
		
		
		int totalTime = wait[endCity];
		
		System.out.println(totalTime);
		System.out.println(cnt);
		
	}
}