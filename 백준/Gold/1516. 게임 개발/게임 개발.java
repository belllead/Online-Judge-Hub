import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<Integer>[] adjList = new ArrayList[N+1];
		for (int i=0; i<N+1; i++)
			adjList[i] = new ArrayList<>();
		
		int[] inDegree = new int[N+1];
		int[] buildTime = new int[N+1];
		
		for (int e=1; e<N+1; e++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			buildTime[e] = Integer.parseInt(st.nextToken());
			
			while (true) {
				int s = Integer.parseInt(st.nextToken());
				
				if (s == -1) break;
				
				adjList[s].add(e);
				inDegree[e]++;
			}
		}
		
//		System.out.println(Arrays.toString(buildTime));
//		
//		for (List<Integer> l : adjList)
//			System.out.println(l);

		// 입력완료
		
		int[] wait = new int[N+1];
		
		Queue<Integer> q = new ArrayDeque<>();
		
		for (int i=1; i<N+1; i++) {
			if (inDegree[i] == 0)
				q.offer(i);
		}
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			
			for (int v : adjList[curr]) {
				wait[v] = Math.max(wait[v], wait[curr]+buildTime[curr]);
				inDegree[v]--;
				
				if (inDegree[v] == 0) {
					q.offer(v);
				}
			}
		}
		
		for (int i=1; i<N+1; i++) {
			System.out.println(wait[i] + buildTime[i]);
		}
		
	}
}