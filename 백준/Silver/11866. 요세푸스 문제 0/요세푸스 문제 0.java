import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		List<Integer> num = new LinkedList<>();
		List<Integer> joseph = new ArrayList<>();
				
		for (int i=0; i<N; i++) {
			num.add(i+1);
		}
		
		int idx = -1;
		
		while (joseph.size() < N) {
			idx += K;
			while (idx >= num.size()) 
				idx -= num.size();
			
//			System.out.println(idx);
			
			joseph.add(num.get(idx));
			num.remove(idx);
			idx--;
			
			
//			System.out.println(num.toString());
//			System.out.println(joseph.toString());
		}
		
		String ans = joseph.toString();
		ans = ans.replace('[', '<');
		ans = ans.replace(']', '>');
		System.out.println(ans);
		sc.close();
	}
}