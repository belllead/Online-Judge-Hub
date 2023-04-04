import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<Integer>[] adjList = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++)
			adjList[i] = new ArrayList<>();

		int[] inDegree = new int[N + 1];
		int[] workTime = new int[N + 1];

		for (int s=1; s<N+1; s++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			workTime[s] = Integer.parseInt(st.nextToken());
			
			int eNum = Integer.parseInt(st.nextToken());
			while (eNum-- > 0) {
				int e = Integer.parseInt(st.nextToken());
				adjList[s].add(e);
				inDegree[e]++;
			}
		}
		
//		System.out.println(Arrays.toString(inDegree));
//		System.out.println(Arrays.toString(workTime));
//		
//		for (List<Integer> l : adjList)
//			System.out.println(l);
		
		//입력완료
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> q = new ArrayDeque<>();
		int[] wait = new int[N+1];

		for (int v = 1; v < N + 1; v++) {
			if (inDegree[v] == 0) {
				q.offer(v);
			}
		}

		while (!q.isEmpty()) {
			int curr = q.poll();

			for (int v : adjList[curr]) {
				wait[v] = Math.max(wait[v], wait[curr]+workTime[curr]);
				
				inDegree[v]--;

				if (inDegree[v] == 0)
					q.offer(v);
			}
		}

		int max = 0;
		for (int i=1; i<N+1; i++) {
			int finalTime = wait[i] + workTime[i];
			max = Math.max(max, finalTime);
		}
		
		System.out.println(max);
	}

}