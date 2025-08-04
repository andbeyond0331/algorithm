
import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.sqrt;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter( new OutputStreamWriter(System.out));

        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer st;
        String str = bufferedReader.readLine();

        st = new StringTokenizer(str, " ");

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for(int i = M; i<N+1; i++){

                int count =0;

                if(i==1){
                  count=1;
                }else if(i%2!=0){
                    for (int j = 2; j <= sqrt(i); j++) {
                        if(i%j==0){
                            count++;
                        }
                        if(count>0){
                            break;
                        }
                    }
                }else if(i==2){

                    count=0;
                }else{
                    count++;
                }

                if(count==0){
                    stringBuilder.append(i).append("\n");
                }


        }

        bufferedWriter.write(String.valueOf(stringBuilder));

        bufferedWriter.flush();


        bufferedReader.close();
        bufferedWriter.close();

    }
}
