import java.util.*;
import java.io.*;

public class Solution {
	
	static char[] tree;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		
		for (int tc=1; tc<=T; tc++) {
			// 해당 테케의 트리크기
			int treeSize = Integer.parseInt(br.readLine());
			
			tree = new char[treeSize + 1];
			
			StringTokenizer st = null;
			
			while (treeSize-- > 0) {
				st = new StringTokenizer(br.readLine());
				int nodeNum = Integer.parseInt(st.nextToken());
				
				tree[nodeNum] = st.nextToken().charAt(0);
			}

			sb.append("#").append(tc).append(" ");
			printTree(1);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void printTree(int nodeNum) {
		
		if (nodeNum * 2 < tree.length) {
			printTree(nodeNum * 2);
		} 
		
//		System.out.println(tree[nodeNum]);
		sb.append(tree[nodeNum]);
		
		if (nodeNum * 2 + 1 < tree.length) {
			printTree(nodeNum * 2 + 1);
		}
		
		
	}
}