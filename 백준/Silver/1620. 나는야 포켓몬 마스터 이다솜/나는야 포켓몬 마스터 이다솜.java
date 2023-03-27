import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		Map<String, Integer> pokedex = new HashMap<>();
		String[] pokedexNames = new String[N];
		
		int idx = 1;
		for (int i=0; i<N; i++) {
			String s = br.readLine();
			pokedex.put(s, idx++);
			pokedexNames[i] = s;
		}
		
		for (int i=0; i<M; i++) {
			String s = br.readLine();
			
			try {
				int num = Integer.parseInt(s);
				sb.append(pokedexNames[num-1] + "\n");
			} catch (Exception e) {
				sb.append(pokedex.get(s) + "\n");
			}
		}
		
		System.out.println(sb);
	}
}