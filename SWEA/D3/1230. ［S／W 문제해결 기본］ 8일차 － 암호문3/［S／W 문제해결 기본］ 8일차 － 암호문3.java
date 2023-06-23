import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	// 정적할당을 이용해 링크드리스트를 만들어보자
	static final int MAX_NODE = 5000;
	static int nodeCount = 0;
	static Node[] nodePool = new Node[MAX_NODE];

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next + "]";
		}
	}

	static class LinkedList {
		Node head;
		Node tail;

		public LinkedList() {
		}

		private Node getNewNode(int data) {
			nodePool[nodeCount] = new Node(data);
			return nodePool[nodeCount++];
		}

		private void insert(int pos, int[] data) {
			// 제일 앞에 삽입할 때
			if (pos == 0) {
				// 리스트가 비어있으면
				if (head == null) {
					head = getNewNode(data[0]);
					
					// 입력할 값이 1개일 때 입력 종료
					if (data.length == 1) {
						tail = head;
						return;
					}
					
					// 1개 보다 많을 때
					Node cur = head;
					for (int i = 1; i < data.length; i++) {
						Node newNode = getNewNode(data[i]);
						cur.next = newNode;
						cur = newNode;
					}
					tail = cur;
				}
				// 리스트가 비어있지 않으면
				else {
					Node cur = getNewNode(data[data.length-1]);
					cur.next = head;
					
					// 입력할 값이 1개 보다 많을 
					if (data.length > 1) {
						for (int i = data.length-2; i>=0; i--) {
							Node newNode = getNewNode(data[i]);
							newNode.next = cur;
							cur = newNode;
						}
					}
					head = cur;
				}
			}

			// 중간에 삽입할 때
			else {
				Node cur = head;
				for (int i=0; i<pos-1; i++) {
					cur = cur.next;
				}
				
				// pos가 tail이라면
				if (cur.next == null) {
					for (int i=0; i<data.length; i++) {
						Node newNode = getNewNode(data[i]);
						cur.next = newNode;
						cur = newNode;
					}
				}
				
				else {
					for (int i=0; i<data.length; i++) {
						Node newNode = getNewNode(data[i]);
						newNode.next = cur.next;
						cur.next = newNode;
						cur = newNode;
					}
				}
			}
		}
		
		private void delete(int pos, int num) {
			Node cur = head;
			
			for (int i=0; i<pos-1; i++) {
				cur = cur.next;
			}
			
			for (int i=0; i<num; i++) {
				cur.next = cur.next.next;
				cur = cur.next;
			}
		}

		private void add(int[] data) {
			// 리스트가 비어있으면
			if (head == null) {
				head = getNewNode(data[0]);
				
				if (data.length == 1) return;
				
				Node cur = head;
				for (int i = 1; i < data.length; i++) {
					Node newNode = getNewNode(data[i]);
					cur.next = newNode;
					cur = newNode;
				}
				tail = cur;
			}
			
			// 리스트에 원소가 존재하면
			else {
				Node cur = tail;
				
				for (int i = 0; i < data.length; i++) {
					Node newNode = getNewNode(data[i]);
					cur.next = newNode;
					cur = newNode;
				}

				tail = cur;
			}
		}
		
		private void print() {
			Node cur = head;
			StringBuilder sb = new StringBuilder();
			
			for (int i=0; i<10; i++) {
				sb.append(cur.data).append(" ");
				cur = cur.next;
			}
			System.out.println(sb);
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = 1; 
		
		while (testCase <= 10) {
			nodeCount = 0;
			
			int N = Integer.parseInt(br.readLine());
					
			LinkedList list = new LinkedList();
	
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] initialInput = new int[N];
			
			for (int i=0; i<N; i++) {
				initialInput[i] = Integer.parseInt(st.nextToken());
			}
			
	//		System.out.println(initialInput);
			list.add(initialInput);
	//		System.out.println(list.head.data);
	//		System.out.println(list.tail.data);
			
			int M = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			
			for (int i=0; i<M; i++) {
				String op = st.nextToken();
				switch (op) {
				case "I":
					int x1 = Integer.parseInt(st.nextToken());
					int y1 = Integer.parseInt(st.nextToken());
					
					int[] input = new int[y1];
					for (int j=0; j<y1; j++) {
						input[j] = Integer.parseInt(st.nextToken());
					}
					
					list.insert(x1, input);
					break;
				case "D":
					int x2 = Integer.parseInt(st.nextToken());
					int y2 = Integer.parseInt(st.nextToken());
					
					list.delete(x2, y2);
					break;
				case "A":
					int y3 = Integer.parseInt(st.nextToken());
					
					int[] s = new int[y3];
					for (int j=0; j<y3; j++) {
						s[j] = Integer.parseInt(st.nextToken());
					}
					
					list.add(s);
					break;
				}
			}
			
			System.out.printf("#%d ", testCase++);
			list.print();
		}
	}
}