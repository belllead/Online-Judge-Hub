import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Integer> sn = new ArrayList<>();
		for (int i=1; i<=10000; i++) {
			int t = d(i);
			if (!sn.contains(t))
				sn.add(t);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i=1; i<=10000; i++) {
			if (!sn.contains(i))
				sb.append(i + "\n");
		}
		
		System.out.println(sb);
	
	}
	
	static int d(int n) {
		int rst = n;
		
		rst += (n / 10000) % 10;
		rst += (n / 1000) % 10;
		rst += (n / 100) % 10;
		rst += (n / 10) % 10;
		rst += n % 10;
		
		return rst;
	}
}