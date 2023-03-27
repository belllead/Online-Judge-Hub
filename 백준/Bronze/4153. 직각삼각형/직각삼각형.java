import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(s);
			List<Integer> list = new ArrayList<>();
			
			int max = 0;
			int maxIndex = -1;
			for (int i=0; i<3; i++) {
				list.add(Integer.parseInt(st.nextToken()));
				if (max < list.get(i)) {
					max = list.get(i);
					maxIndex = i;
				}
			}
			
			if (list.get(0) == 0) break;
						
			double c = Math.pow(list.get(maxIndex), 2);
			list.remove(maxIndex);
			double a = Math.pow(list.get(0), 2);
			double b = Math.pow(list.get(1), 2);
			
			if (c == a + b) System.out.println("right");
			else System.out.println("wrong");
			
			
		}
		
	}
}