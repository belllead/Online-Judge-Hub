import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int N;
	static int top = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			
			switch (order) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				push(num);
				break;
			case "pop":
				sb.append(pop()).append("\n");
				break;
			case "size":
				sb.append(size()).append("\n");
				break;
			case "empty":
				sb.append(empty()).append("\n");
				break;
			case "top":
				sb.append(top()).append("\n");
			}
		}
		
		System.out.println(sb);
	}

	private static int top() {
		if (top > -1)
			 return arr[top];
		else 
			return top;
	}

	private static int empty() {
		if (top == -1)
			return 1;
		else
			return 0;
		
	}

	private static int size() {
		return top+1;
	}

	private static int pop() {
		if (top == -1) {
			return -1;
		} else {
			return arr[top--];
		}
	}

	private static void push(int num) {
		arr[++top] = num;
	}
	
	
	
	
}