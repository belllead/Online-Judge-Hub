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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] adjList = new ArrayList[N+1];
		for (int i=0; i<N+1; i++)
			adjList[i] = new ArrayList<>();
		
		int[] inDegree = new int[N+1];
		
		while (M-- > 0) {
			String[] s = br.readLine().split(" ");
			
			for (int i=1; i<s.length-1; i++) {
				int start = Integer.parseInt(s[i]);
				int end = Integer.parseInt(s[i+1]);
				
				adjList[start].add(end);
				inDegree[end]++;
			}
		}
		
//		for (List<Integer> l : adjList)
//			System.out.println(l);
//		
//		System.out.println(Arrays.toString(inDegree));
		
		//입력완료
		
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> q = new ArrayDeque<>();
		
		for (int i=1; i<N+1; i++) {
			if (inDegree[i] == 0)
				q.offer(i);
		}
		
		int cycleChk = 0;
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			
			sb.append(curr + "\n");
			cycleChk++;
			
			for (int v : adjList[curr]) {
				inDegree[v]--;
				
				if (inDegree[v] == 0)
					q.offer(v);
			}
		}
		
		if (cycleChk == N)
			System.out.println(sb);
		else 
			System.out.println(0);
	}
}