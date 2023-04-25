import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static long[] arr, segmentTree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		arr = new long[N];
		segmentTree = new long[N*4];
		
		for (int i=0; i<N; i++)
			arr[i] = Long.parseLong(br.readLine());

		init(0, N-1, 1);
//		System.out.println(Arrays.toString(segmentTree));
		// 입력 완료
		
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			long b = Long.parseLong(st.nextToken());
//			System.out.println("order: " + order);
			switch (order) {
			case 1:
				int targetIdx = a - 1;
				long newNum = b;
				long diff = newNum - arr[targetIdx];
				arr[targetIdx] = newNum;
//				System.out.println("arr[targetIdx]: " + arr[targetIdx]);
//				System.out.println("newNum: " + newNum);
//				System.out.println("diff : " + diff);
				updateTree(0, N-1, 1, targetIdx, diff);
				break;
			case 2:
				int first = a - 1;
				int last = (int) b - 1;
				long sum = sumTree(0, N-1, 1, first, last);
				sb.append(sum);
				sb.append("\n");
				break;
			}
//			System.out.println("task " + (i+1) + ": " + Arrays.toString(segmentTree));
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static long sumTree(int start, int end, int node, int first, int last) {
		if (first > end || last < start) return 0;
		
		if (first <= start && end <= last) return segmentTree[node];
		
		int mid = (start + end) / 2;

		return sumTree(start, mid, node*2, first, last) + sumTree(mid+1, end, node*2+1, first, last);
	}

	private static void updateTree(int start, int end, int node, int targetIdx, long diff) {
		if (start > targetIdx || targetIdx > end) return;
		
		segmentTree[node] += diff;
		
		if (start == end) return;
		
		int mid = (start + end) / 2;
		updateTree(start, mid, node*2, targetIdx, diff);
		updateTree(mid+1, end, node*2+1, targetIdx, diff);
	}

	private static long init(int start, int end, int node) {
		if (start == end) {
			return segmentTree[node] = arr[start];
		}
		
		int mid = (start + end) / 2;
		
		return segmentTree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
	}
}