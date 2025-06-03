import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        //입력값 저장
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        //n == k일 때는 만들 수 없는 수열
        if(N == K){
            bw.write("Impossible");
        }else{		//n != k일 때
            //순차적인 수열 초기화
            for(int i=0;i<N;i++){
                arr[i] = i + 1;
            }
            //교환해야 하는 개수, 점화식 : n - k - 1
            int dif = N- K - 1;
            //현재 인덱스
            int idx = 1;
            //교환 진행
            while(dif > 1){
                swap(arr, idx, idx+1);
                idx+=2;
                dif-=2;	//2개수의 수가 바뀌므로 2개씩 감소
            }
            //홀수일 때 1과 마지막 수 변경
            if(dif == 1){
                swap(arr, 0, N-1);
            }
            StringBuilder sb = new StringBuilder();
            //탐색한 수열 StringBuilder 저장
            for(int i=0;i<N;i++){
                sb.append(arr[i]).append(" ");
            }
            //결과 BufferedWriter 저장
            bw.write(sb.toString());
        }
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
    //서로의 수를 교환하는 함수
    static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}