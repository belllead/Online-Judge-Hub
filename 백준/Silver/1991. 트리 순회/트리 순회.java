import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static String[] tree;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		tree = new String[N+1];
		
		tree[1] = "A";
		
		StringTokenizer st = null;
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			String t1 = st.nextToken();
			String t2 = st.nextToken();
			String t3 = st.nextToken();
			
			for (int i=0; i<tree.length; i++) {
				if (t1.equals(tree[i])) {
					if (2*i+1 >= tree.length) {
						tree = Arrays.copyOf(tree, tree.length*2);
					}
					tree[2*i] = t2;
					tree[2*i+1] = t3;
				}
			}
			
		}
		
//		System.out.println(Arrays.toString(tree));
		
		VLR(1);
		sb.append("\n");
		LVR(1);
		sb.append("\n");
		LRV(1);
		sb.append("\n");
		System.out.println(sb);
	}
	
	static void VLR(int idx) {
		if (idx >= tree.length)
			return;
		
		if (tree[idx] != null && !tree[idx].equals(".")) {
			sb.append(tree[idx]);
			VLR(idx*2);
			VLR(idx*2 + 1);
		}
	}

	static void LVR(int idx) {
		if (idx >= tree.length)
			return;
		
		if (tree[idx] != null && !tree[idx].equals(".")) {
			LVR(idx*2);
			sb.append(tree[idx]);
			LVR(idx*2 + 1);
		}
	}
	
	static void LRV(int idx) {
		if (idx >= tree.length)
			return;
		
		if (tree[idx] != null && !tree[idx].equals(".")) {
			LRV(idx*2);
			LRV(idx*2 + 1);
			sb.append(tree[idx]);
		}
	}
}