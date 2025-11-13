import java.util.*;
import java.io.*;

public class Main {

public static void main(String[] args) throws IOException {

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

int n = Integer.parseInt(br.readLine());

StringTokenizer st = new StringTokenizer(br.readLine());

int min = Integer.MAX_VALUE;

int max = Integer.MIN_VALUE;

for(int i = 0; i < n; i++) {

int temp = Integer.parseInt(st.nextToken());

min = Math.min(min, temp);

max = Math.max(max, temp);

}

StringBuilder sb = new StringBuilder();

sb.append(min).append(" ").append(max);

System.out.println(sb);

}

}