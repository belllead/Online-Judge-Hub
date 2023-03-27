import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayList<String> list = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(st.nextToken());
		}
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length())
					return o1.compareTo(o2);				
				return o1.length() - o2.length();
			}
		});
				
		List<String> list2 = new ArrayList<>();
		
		for (int i=0; i<N; i++) {
			if (!(list2.contains(list.get(i))))
				list2.add(list.get(i));
		}
		
		for (int i=0; i<list2.size(); i++) {
			sb.append(list2.get(i) + "\n");
		}
		
		System.out.println(sb);
	}
}