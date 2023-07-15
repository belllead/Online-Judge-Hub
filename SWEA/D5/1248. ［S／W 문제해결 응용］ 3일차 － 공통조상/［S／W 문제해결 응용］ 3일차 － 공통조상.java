import java.util.*;
import java.io.*;

public class Solution {

	static class Node {
		int parent;
		List<Integer> children;

		public Node(int parent) {
			this.parent = parent;
			this.children = new ArrayList<>();
		}

		@Override
		public String toString() {
			return "Node [parent=" + parent + ", children=" + children + "]";
		}
	}
	
	static int subTreeSize;
	static Node[] tree;
	static List<Integer> ancestorList1, ancestorList2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			subTreeSize = 0;
			ancestorList1 = new ArrayList<>();
			ancestorList2 = new ArrayList<>();
			
			tree = new Node[V+1];
			tree[1] = new Node(0);
			
			st = new StringTokenizer(br.readLine());
			while (E-- > 0) {
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				if (tree[p] == null)
					tree[p] = new Node(0);
				
				tree[p].children.add(c);
				
				if (tree[c] == null)
					tree[c] = new Node(p);
				
				tree[c].parent = p;
			}
			
			findAncestor(node1, 1);
			findAncestor(node2, 2);
			
			int lca = findLCA();
			
//			for (int i : ancestorList1)
//				System.out.print(i + " ");
//			System.out.println();
//			for (int i : ancestorList2)
//				System.out.print(i + " ");
//			System.out.println();
//			
//			System.out.println(lca);

			findSubTreeSize(lca);
			
//			System.out.println(subTreeSize);
			
			sb.append("#").append(tc).append(" ");
			sb.append(lca).append(" ");
			sb.append(subTreeSize).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	
	
	private static void findSubTreeSize(int lca) {
		subTreeSize++;
		
		for (int c : tree[lca].children)
			findSubTreeSize(c);
	}



	private static int findLCA() {
		int rst = 0;
		
		int limit = Math.min(ancestorList1.size(), ancestorList2.size());
		
		for (int i=0; i<limit; i++) {
			if (ancestorList1.get(i).intValue() == ancestorList2.get(i).intValue())
				rst = ancestorList1.get(i);
			else break;
		}
		
		return rst;
	}
	
	private static void findAncestor(int node, int listNum) {
		if (listNum == 1)
			ancestorList1.add(0, node);
		
		else if (listNum == 2)
			ancestorList2.add(0, node);
		
		if (tree[node].parent == 0) return;

		findAncestor(tree[node].parent, listNum);
	}
}