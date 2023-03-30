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
		int tR, tC, weight;

		public Node(int targetR, int targetC, int weight) {
			this.tR = targetR;
			this.tC = targetC;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

	static final int INF = Integer.MAX_VALUE;
	static int startR = 0, startC = 0, endR, endC, N;
	static int[][] distance, caveWeight, caveNum;
	static List<Node>[] adjList;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String s = null;
		int tc = 1;

		while (!(s = br.readLine()).equals("0")) {
			N = Integer.parseInt(s);

			caveWeight = new int[N][N];
			caveNum = new int[N][N];
			
			adjList = new ArrayList[N * N];
			for (int i=0; i<N*N; i++) {
				adjList[i] = new ArrayList<>();
			}
			distance = new int[N][N];

			int cIdx = 0;
			for (int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					caveWeight[r][c] = Integer.parseInt(st.nextToken());
					caveNum[r][c] = cIdx++;
				}
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					for (int i = 0; i < 4; i++) {
						int tmpR = r + dr[i];
						int tmpC = c + dc[i];
						if (tmpR >= 0 & tmpR < N && tmpC >= 0 && tmpC < N) {
							adjList[caveNum[r][c]].add(new Node(tmpR, tmpC, caveWeight[tmpR][tmpC]));
						}
					}
				}
			}
			
			for (int[] r : distance)
				Arrays.fill(r, INF);

			distance[0][0] = caveWeight[0][0];

			endR = N - 1;
			endC = N - 1;
			// 입력 완료

			dijkstra();
			
			sb.append("Problem " + tc++ + ": ");
			sb.append(distance[endR][endC]);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[N][N];
		
		pq.offer(new Node(startR, startC, caveWeight[startR][startC]));
		
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if (curr.tR == endR && curr.tC == endC) return;
			
			if (visited[curr.tR][curr.tC]) continue;
			
			visited[curr.tR][curr.tC] = true;
			
			for (Node next : adjList[caveNum[curr.tR][curr.tC]]) {
				if (distance[next.tR][next.tC] > distance[curr.tR][curr.tC] + caveWeight[next.tR][next.tC]) {
					distance[next.tR][next.tC] = distance[curr.tR][curr.tC] + caveWeight[next.tR][next.tC];
					pq.offer(new Node(next.tR, next.tC, distance[next.tR][next.tC]));
				}
			}
		}
	}
}