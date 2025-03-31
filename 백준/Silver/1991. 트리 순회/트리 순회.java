import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Node {
	char left;
	char num;
	char right;
	public Node(char left, char num, char right) {
		this.left = left;
		this.num = num;
		this.right = right;
	}
}
public class Main {
	static int N;
	static Map<Character, Node> map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new TreeMap<>();
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char num = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			map.put(num, new Node(left, num, right));
		}
		if(N==1) {
			System.out.println('A');
			System.out.println('A');
			System.out.println('A');
			return;
		}
		preOrder('A');
		System.out.println();
		inOrder('A');
		System.out.println();
		postOrder('A');
	}
	static void preOrder(char c) {
		if(c == '.') {
			return;
		}
		if(map.containsKey(c)) {
			System.out.print(map.get(c).num);
			preOrder(map.get(c).left);
			preOrder(map.get(c).right);
		}
	}
	static void inOrder(char c) {
		if(c == '.') {
			return;
		}
		if(map.containsKey(c)) {
			inOrder(map.get(c).left);
			System.out.print(map.get(c).num);
			inOrder(map.get(c).right);
		}
	}
	static void postOrder(char c) {
		if(c == '.') {
			return;
		}
		if(map.containsKey(c)) {
			postOrder(map.get(c).left);
			postOrder(map.get(c).right);
			System.out.print(map.get(c).num);
		}
	}
}
