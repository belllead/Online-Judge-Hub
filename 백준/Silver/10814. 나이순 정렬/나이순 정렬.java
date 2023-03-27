import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
    static class Person {
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

		@Override
		public String toString() {
			return age + " " + name;
		}
    }
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    	int N = Integer.parseInt(br.readLine());
    	
    	Person[] p = new Person[N];
    	
    	StringTokenizer st = null;
    	for (int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int age = Integer.parseInt(st.nextToken());
    		String name = st.nextToken();
    		
    		p[i] = new Person(age, name); 
    	}
    	
    	Arrays.sort(p, (o1, o2) -> {
    		return o1.age - o2.age; 
    	});
    	
    	for (int i=0; i<N; i++) {
    		System.out.println(p[i]);
    	}
    	
    	
    }
}