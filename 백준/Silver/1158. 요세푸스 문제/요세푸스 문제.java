import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		List<Integer> list = new ArrayList<>();
		
		for (int i=0; i<N; i++) 
			list.add(i+1);
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		int idx = K-1;
		while (list.size() > 1) {
			sb.append(list.get(idx) + ", ");
			list.remove(idx);
			idx--;
			idx = (idx+K) % list.size();
		}
		
		sb.append(list.get(0));
		sb.append(">");
		
		System.out.println(sb);
		sc.close();
	}
}