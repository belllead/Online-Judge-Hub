import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		int[] arr2 = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<M; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		
		StringBuilder sb = new StringBuilder();
		
		
		for (int i=0; i<M; i++) {
			if (arr2[i] > arr[N-1] || arr2[i] < arr[0]) {
				sb.append(0 + "\n");
				continue;
			} else {
				boolean flag = true;
				for (int j=0; j<N; j++) {
					if (arr2[i] == arr[j]) {
						sb.append(1 + "\n");
						flag = false;
						break;
					} 
				}
				if (flag)
					sb.append(0 + "\n");
			}
		}
		
		System.out.println(sb);
		
	}
}