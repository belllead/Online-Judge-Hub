import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stackNum = new Stack<>();
		
		int[] inputNum = new int[N];
		for (int i=0; i<N; i++) {
			inputNum[i] = sc.nextInt();
		}
				
		int cnt = 1;
		
		for (int i=0; i<inputNum[0]; i++) {
			stackNum.push(cnt++);
			sb.append("+" + "\n");
		}
		
		stackNum.pop();
		sb.append("-" + "\n");
		
		boolean flag = true;
		
		for (int i=1; i<N; i++) {
			if (inputNum[i] > inputNum[i-1]) {
				for (int j=cnt; j<=inputNum[i]; j++) {
					stackNum.push(cnt++);
					sb.append("+" + "\n");
				}
				stackNum.pop();
				sb.append("-" + "\n");
			} else {
				int temp = stackNum.pop();
				sb.append("-" + "\n");
				if (temp == inputNum[i]) {
				} else {
					flag = false;
					break;
				}
			}
		}
		
		if (flag)
			System.out.println(sb);
		else
			System.out.println("NO");
		
		
		
	}
	
}