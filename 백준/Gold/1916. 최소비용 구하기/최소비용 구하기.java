import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class City implements Comparable<City> {
		int cityNum;
		int weight;
		
		public City(int target, int weight) {
			super();
			this.cityNum = target;
			this.weight = weight;
		}

		@Override
		public int compareTo(City o) {
			return this.weight - o.weight;
		}

		@Override
		public String toString() {
			return "City [cityNum=" + cityNum + ", weight=" + weight + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		List<City>[] adjList = new ArrayList[N+1];
		for (int i=0; i<N+1; i++)
			adjList[i] = new ArrayList<>();
		
		while (M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adjList[s].add(new City(t, w));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
//		for (List<City> c : adjList)
//			System.out.println(c);

		// 입력 완료
		
		int[] distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		// dijkstra
		PriorityQueue<City> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		
		pq.offer(new City(start, 0));
		
		while (!pq.isEmpty()) {
			City curr = pq.poll();
			
			if (visited[curr.cityNum]) continue;
			
			visited[curr.cityNum] = true;
			
			for (City target : adjList[curr.cityNum]) {
				if (distance[target.cityNum] > distance[curr.cityNum] + target.weight) {
					distance[target.cityNum] = distance[curr.cityNum] + target.weight;
					pq.offer(new City(target.cityNum, distance[target.cityNum]));
				}
			}
		}
		
		System.out.println(distance[end]);
	}
}