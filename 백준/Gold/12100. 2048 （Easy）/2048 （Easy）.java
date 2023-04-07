import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	static int N, maxBlock;
	static int[][] board;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		board = new int[N][N];
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				board[r][c] = sc.nextInt();
			}
		}
		
//		for (int[] i : board)
//			System.out.println(Arrays.toString(i));
		
		for (int i=0; i<4; i++) {
			int[][] nB = swipe(i, board);
			dfs(1, nB);
		}
		
		System.out.println(maxBlock);
		sc.close();
	}
	
	private static void dfs(int move, int[][] board) {

		if (move == 5) {
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					maxBlock = Math.max(maxBlock, board[r][c]);
				}
			}
			return;
		}

		// 각 4방향으로 스와이프 후 다음 단계로 보내본다.
		for (int i=0; i<4; i++) {
			int[][] nB = swipe(i, board);
			dfs(move+1, nB);
		}
		
	}
	
	// 보드를 받아서 주어진 방향으로 스와이프 한 보드를 반환
	private static int[][] swipe(int direction, int[][] board) {
		int[][] rst = new int[N][N];
		for (int i=0; i<N; i++)
			rst[i] = Arrays.copyOf(board[i], N);
		
		// 위쪽으로 스와이프 (위가 우선)
		if (direction == 0) {
			for (int c=0; c<N; c++) {
				int[] temp = new int[N];
				
				// 원래 세로 줄을 꺼내서
				for (int r=0; r<N; r++) {
					temp[r] = rst[r][c];
				}
				
				// 병합 작업을 한 후
				temp = mergeLine(temp);
				
				// 원래 줄에 붙여넣기
				for (int r=0; r<N; r++) {
					rst[r][c] = temp[r];
				}
			}
		}
		
		// 아래쪽으로 스와이프 (아래가 우선)
		if (direction == 1) {
			for (int c=0; c<N; c++) {
				int[] temp = new int[N];
				
				// 원래 세로 줄을 거꾸로 꺼내서
				for (int r=0; r<N; r++) {
					temp[N-1-r] = rst[r][c];
				}
				
				// 병합 작업을 한 후
				temp = mergeLine(temp);
				
				// 원래 줄에 거꾸로 붙여넣기
				for (int r=0; r<N; r++) {
					rst[N-1-r][c] = temp[r];
				}
			}
		}
		
		// 왼쪽으로 스와이프 (왼이 우선)
		if (direction == 2) {
			for (int r=0; r<N; r++) {
				int[] temp = new int[N];
				
				// 원래 가로 줄을 꺼내서
				for (int c=0; c<N; c++) {
					temp[c] = rst[r][c];
				}
				
				// 병합 작업을 한 후
				temp = mergeLine(temp);
				
				// 원래 줄에 붙여넣기
				for (int c=0; c<N; c++) {
					rst[r][c] = temp[c];
				}
			}
		}
		
		// 오른쪽으로 스와이프 (오른 우선)
		if (direction == 3) {
			for (int r=0; r<N; r++) {
				int[] temp = new int[N];
				
				// 원래 가로 줄을 꺼내서
				for (int c=0; c<N; c++) {
					temp[c] = rst[r][N-1-c];
				}
				
				// 병합 작업을 한 후
				temp = mergeLine(temp);
				
				// 원래 줄에 붙여넣기
				for (int c=0; c<N; c++) {
					rst[r][N-1-c] = temp[c];
				}
			}
		}
		
		return rst;
	}
	
	private static int[] mergeLine(int[] line) {
		int[] rst = new int[N];
		Stack<Integer> stack = new Stack<>();
		// 앞에가 합쳐진 수인지 아닌지 판단 필요
		boolean isMerged = false;
		
		for (int i=0; i<N; i++) {
			if (line[i] == 0) continue;
			
			// 스택의 탑과 현재 값이 같으면
			// pop 후 더해서 push
			if (!stack.isEmpty() && !isMerged && stack.peek() == line[i]) {
				stack.push(stack.pop()*2);
				isMerged = true;
			} else {
				stack.push(line[i]);
				isMerged = false;
			}
		}
		
		for (int i=stack.size()-1; i>=0; i--) {
			rst[i] = stack.pop();
		}

		return rst;
	}
}