import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(0);
		arr[0] = Integer.parseInt(st.nextToken());
		
		for (int i=1; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			if (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
				while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
					arr[stack.pop()] = arr[i];					
				}
				stack.push(i);
			} else {
				stack.push(i);
			}		
			
		}
		
		while (!stack.isEmpty()) {
			arr[stack.pop()] = -1;
		}
		
		String s = Arrays.toString(arr).replace("[", "").replace("]", "").replace(",", "");
		bw.write(s);
		
		br.close();
		bw.close();
	}
	
	
	
}