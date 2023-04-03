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
	
	static int[] buildTime, inDegree;
	static List<Integer>[] adjList;
	static List<Integer>[] bwdAdjList;
	static List<Integer> necessaryBuild = new ArrayList<>();
	static int N, W;
	static int[] memo;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			buildTime = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for (int i=1; i<N+1; i++)
				buildTime[i] = Integer.parseInt(st.nextToken());
			
			adjList = new ArrayList[N+1];
			for (int i=0; i<N+1; i++)
				adjList[i] = new ArrayList<>();
			
			bwdAdjList = new ArrayList[N+1];
			for (int i=0; i<N+1; i++)
				bwdAdjList[i] = new ArrayList<>();
			
			inDegree = new int[N+1];
			memo = new int[N+1];
			
			while (K-- > 0) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				
				adjList[s].add(e);
				inDegree[e]++;

				bwdAdjList[e].add(s);
			}
			
			W = Integer.parseInt(br.readLine());
			//입력완료
			
//			System.out.println(Arrays.toString(buildTime));
			
			findNecessaryBuild();
//			System.out.println(necessaryBuild);
			
			Arrays.fill(memo, -1);
			
			for (int i=1; i<N+1; i++) {
				if (inDegree[i] == 0)
					memo[i] = buildTime[i];
			}
			
			sb.append(dp(W) + "\n");
		}
		System.out.println(sb);
	}
	
	static int dp(int v) {
		if (memo[v] != -1) 
			return memo[v];
		
		int preBuild = 0;
		for (int i : bwdAdjList[v])
			preBuild = Math.max(preBuild, dp(i));
		
		memo[v] = preBuild + buildTime[v];
		
		return memo[v];
	}
	
	
	static void findNecessaryBuild() {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		
		q.offer(W);
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			
			necessaryBuild.add(curr);
			
			for (int v : bwdAdjList[curr]) {
				if (!visited[v]) {
					q.offer(v);
					visited[v] = true;
				}
			}
		}
	}
}