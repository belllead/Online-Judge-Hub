import java.util.Scanner;

public class Main {
	static int saveCnt = 0, K, ans = -1;
	static int[] temp; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		K = sc.nextInt();
		int[] A = new int[N];
		temp = new int[A.length];
		
		for (int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		
		mergeSort(A, 0, N-1);
		
//		System.out.println(save.toString());
//		System.out.println(Arrays.toString(A));
		
		System.out.println(ans);
		
		sc.close();
	}
	

	static void mergeSort(int[] A, int p, int r) {
		if (saveCnt > K) return;
		
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(A, p, q);
			mergeSort(A, q+1, r);
			merge(A, p, q, r);
		}
	}
	
	static void merge(int[] A, int p, int q, int r) {
		int i = p;
		int j = q + 1;
		int t = 0;
				
		while (i <= q && j <= r) {
			if (A[i] <= A[j])
				temp[t++] = A[i++];
			else
				temp[t++] = A[j++];				
		}
		
		while (i <= q) {
			temp[t++] = A[i++];			
		}			

		while (j <= r) {
			temp[t++] = A[j++];			
		}			
		
		i = p;
		t = 0;
		
		while (i <= r) {
			saveCnt++;
			if (saveCnt == K) {
				ans = temp[t];
				break;
			}
			A[i++] = temp[t++];
		}
		
	}
}