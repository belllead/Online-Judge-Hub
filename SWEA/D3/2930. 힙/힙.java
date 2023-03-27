import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int[] heap;
	static int idx;
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			heap = new int[10];
			idx = 0;
			
			sb.append("#" + tc + " ");
			
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = null;
			for (int i=0; i<N; i++) {
				 st = new StringTokenizer(br.readLine());
				 
				 if (Integer.parseInt(st.nextToken()) == 1)
					 add(Integer.parseInt(st.nextToken()));
				 else
					 sb.append(delete() + " ");	 
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static int delete() {
		if (idx == 0)
			return -1;
		
		int temp = heap[1];
		
		heap[1] = heap[idx];
		heap[idx--] = 0;
		
		matchHeapLogic2(1);		
		
		return temp;
	}
	
	static void add(int i) {
		idx++;
		
		if (idx > heap.length-1)
			heap = Arrays.copyOf(heap, heap.length*2);
		
		heap[idx] = i;
		
		matchHeapLogic1(idx);
	}
	
	static void matchHeapLogic1(int idx) {
		if (idx == 1)
			return;
				
		if (heap[idx] > heap[idx/2]) {
			int temp = heap[idx];
			heap[idx] = heap[idx/2];
			heap[idx/2] = temp;
			matchHeapLogic1(idx/2);
		}
	}
	
	static void matchHeapLogic2(int index) {
		if (index >= idx)
			return;
			
		int child = 0;
		int childIdx = 0;
		int t1 = 0;
		int t2 = 0;
		
		if (index*2 < heap.length) {
			t1 = heap[index*2];
		}
		
		if (index*2 + 1 < heap.length) {
			t2 = heap[index*2+1];
		}		
		
		if (t1 > t2) {
			child = t1;
			childIdx = index * 2;
		} else { 
			child = t2;
			childIdx = index * 2 + 1;
		}
		
		if (heap[index] < child) {
			int temp = heap[index];
			heap[index] = child;
			heap[childIdx] = temp;
			matchHeapLogic2(childIdx);
		}
	}
}