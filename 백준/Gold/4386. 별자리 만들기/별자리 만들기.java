import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

//	static String input = "4\r\n" + "1.0 1.0\r\n" + "2.0 2.0\r\n" + "3.0 3.0\r\n" + "2.0 4.0";

	static class Node implements Comparable<Node> {
		int startNum, tarNum;
		double tarX, tarY, slope, dist;

		public Node(int startNum, int tarNum, double tarX, double tarY, double slope, double dist) {
			this.startNum = startNum;
			this.tarNum = tarNum;
			this.tarX = tarX;
			this.tarY = tarY;
			this.slope = slope;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return Double.compare(this.dist, o.dist);
		}

		@Override
		public String toString() {
			return "Node [startNum=" + startNum + ", tarNum=" + tarNum + ", tarX=" + tarX + ", tarY=" + tarY
					+ ", slope=" + slope + ", dist=" + dist + "]";
		}
	}

	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		InputStream is = new ByteArrayInputStream(input.getBytes());
//		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		int N = Integer.parseInt(br.readLine());
		double[] starX = new double[N];
		double[] starY = new double[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			starX[i] = Double.parseDouble(st.nextToken());
			starY[i] = Double.parseDouble(st.nextToken());
		}

//		System.out.println(Arrays.toString(starX));
//		System.out.println(Arrays.toString(starY));
		
		List<Node>[] adjList = new ArrayList[N];
		for (int i=0; i<N; i++)
			adjList[i] = new ArrayList<>();
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (i!=j) {
//					System.out.printf("%f %f \n" ,starX[i], starY[i]);
//					System.out.printf("%f %f \n" ,starX[j], starY[j]);
//					System.out.println();
					double slope = getSlope(starX[i], starY[i], starX[j], starY[j]);
					double distance = getDistance(starX[i], starY[i], starX[j], starY[j]);
					adjList[i].add(new Node(i, j, starX[j], starY[j], slope, distance));
				}
			}
		}
		
		List<Node> filteredAdjList = new ArrayList<>();
		
		for (int i=0; i<N; i++) {
			Collections.sort(adjList[i]);
			List<Double> slopeList = new ArrayList<>();
			for (Node n : adjList[i]) {
				if (!slopeList.contains(n.slope)) {
					slopeList.add(n.slope);
//					System.out.println(n);
					filteredAdjList.add(n);
				}
			}
//			System.out.println();
		}
		
		Collections.sort(filteredAdjList);
		
//		for (Node n : filteredAdjList) {
//			System.out.println(n);
//		}
		
		parent = new int[N];
		for (int i=0; i<N; i++)
			parent[i] = i;
		
		double cost = 0;
		int pick = 0;
		
		int idx = 0;
		while (pick != N-1) {
			Node curr = filteredAdjList.get(idx++);
			int px = findSet(curr.startNum);
			int py = findSet(curr.tarNum);
//			System.out.println();
//			System.out.println(curr);
//			System.out.println(px);
//			System.out.println(py);
//			System.out.println();
			if (px != py) {
				union(px, py);
				cost += curr.dist;
				pick++;
			}
		}
		
		System.out.printf("%.2f", cost);
	}
	
	static int findSet(int num) {
		if (parent[num] != num) {
			parent[num] = findSet(parent[num]);
		}
		return parent[num];
	}

	static void union(int x, int y) {
		parent[y] = x;
	}
	
	static double getSlope(double x1, double y1, double x2, double y2) {
		if (x2 == x1) return 0;
		if (y2 == y1) return Double.MAX_VALUE;
		return (y2 - y1) / (x2 - x1);
	}
	
	static double getDistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt((Math.pow((y2 - y1), 2) + Math.pow((x2 - x1), 2)));
	}
}