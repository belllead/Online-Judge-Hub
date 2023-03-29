import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static String input = "5 150\r\n" + "0 50 10\r\n" + "0 50 20\r\n" + "50 100 10\r\n" + "100 151 10\r\n"
			+ "110 140 90";

	static class Node implements Comparable<Node> {
		int edge;
		int weight;

		public Node(int edge, int weight) {
			super();
			this.edge = edge;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}

		@Override
		public String toString() {
			return "Node [edge=" + edge + ", weight=" + weight + "]";
		}

	}

	static List<Integer> vertex = new ArrayList<>();
	static Map<Integer, ArrayList<Node>> adjList = new HashMap<>();
	static Map<Integer, Integer> distance = new HashMap<>();
	static Map<Integer, Boolean> visited = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		InputStream is = new ByteArrayInputStream(input.getBytes());
//		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int[][] inputArr = new int[N][3];

		// 입력 배열 저장과 정점 배열 생성
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			inputArr[i][0] = s;
			inputArr[i][1] = e;
			inputArr[i][2] = w;

			if (!vertex.contains(s))
				vertex.add(s);
			if (!vertex.contains(e))
				vertex.add(e);
		}

		// 정점 정렬
		vertex.add(0);
		vertex.add(D);
		Collections.sort(vertex);
//		System.out.println("vertex: " + vertex);
//		System.out.println();

		// 인접리스트 초기화
		for (int i = 0; i < vertex.size(); i++) {
			int key = vertex.get(i);
			if (!adjList.containsKey(key))
				adjList.put(key, new ArrayList<>());
		}

		// 지름길 이어주기
		for (int i = 0; i < N; i++) {
			int s = inputArr[i][0];
			int e = inputArr[i][1];
			int w = inputArr[i][2];
			adjList.get(s).add(new Node(e, w));
		}

		// 기본 고속도로 이어주기
		for (int key : adjList.keySet()) {
			for (int vertex : vertex) {
				if (vertex > key && vertex <= D) {
					adjList.get(key).add(new Node(vertex, vertex - key));
				}
			}
		}

		// 인접리스트 출력
//		System.out.println("adjList");
//		for (int key : adjList.keySet()) {
//			System.out.printf("%d : ", key);
//			System.out.println(adjList.get(key));
//		}

		// 방문리스트 초기화
		for (int vertex : vertex) {
			visited.put(vertex, false);
		}

		// 방문리스트 출력
//		System.out.println();
//		System.out.println("visited");
//		for (int key : visited.keySet()) {
//			System.out.printf("%d : ", key);
//			System.out.println(visited.get(key));
//		}

		// 최단거리 초기화
		for (int vertex : vertex) {
			distance.put(vertex, Integer.MAX_VALUE);
		}
		distance.replace(0, 0);

		// 최단거리 출력
//		System.out.println();
//		System.out.println("distance1");
//		for (int key : distance.keySet()) {
//			System.out.printf("%d : ", key);
//			System.out.println(distance.get(key));
//		}

		dijkstra();

		// 최단거리 출력
//		System.out.println();
//		System.out.println("distance2");
//		for (int key : distance.keySet()) {
//			System.out.printf("%d : ", key);
//			System.out.println(distance.get(key));
//		}
		
//		System.out.println();
		System.out.println(distance.get(D));
	}

	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.offer(new Node(0, 0));

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			if (visited.get(curr.edge))
				continue;

			visited.replace(curr.edge, true);

			for (Node next : adjList.get(curr.edge)) {
				if (distance.get(next.edge) > distance.get(curr.edge) + next.weight) {
					distance.replace(next.edge, distance.get(curr.edge) + next.weight);
					pq.offer(new Node(next.edge, distance.get(next.edge)));
				}
			}

		}
	}

}