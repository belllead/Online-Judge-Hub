import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int max = -1;
		int min = 10001;
		double sum = 0;
		int mean = 0;
		int[] arr = new int[10];
		
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=0; i<10; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if (max < arr[i]) max = arr[i];
				if (min > arr[i]) min = arr[i];
			}
			
			for (int i=0; i<10; i++) {
				if (arr[i] != max && arr[i] != min)
					sum += arr[i];
			}

			mean = (int) Math.round(sum / 8);
			
			max = -1;
			min = 10001;
			sum = 0;
			
			sb.append("#" + tc + " ").append(mean).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
}