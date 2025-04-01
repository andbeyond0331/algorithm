
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String target = bufferedReader.readLine();
        int q = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < q; i++) {

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            String s = stringTokenizer.nextToken();
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            String temp = target.substring(start, end+1);
            temp = temp.replaceAll(s, "");
            stringBuilder.append((target.substring(start, end+1).length()-temp.length())).append("\n");
        }



        bufferedWriter.write(String.valueOf(stringBuilder));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
