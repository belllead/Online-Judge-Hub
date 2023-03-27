import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			Stack<Character> stack = new Stack<>();
			
			String s = br.readLine();
			
			if (s.equals(".")) break;
			else s = s.replaceAll("[A-Za-z\\s.]", "");
						
			for (int i=0; i<s.length(); i++) {
				
				char temp = s.charAt(i);
				
				if (temp == '(' || temp == '[') {
					stack.push(temp);
					
				} else if (temp == ')') {
					if (stack.isEmpty() || stack.peek() != '(')
						stack.push(temp);
					else
						stack.pop();

				} else if (temp == ']') {
					if (stack.isEmpty() || stack.peek() != '[')
						stack.push(temp);
					else if (stack.peek() == '[') 
						stack.pop();					
				}
			}
			
			if (stack.isEmpty()) {
				sb.append("yes" + "\n");
			} else {
				sb.append("no" + "\n");
				stack.clear();
			}
		}
		
		System.out.println(sb);
		br.close();
	}
}