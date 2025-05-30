import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int[] groupMarbleCnt;
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        //입력값 저장.
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int[] marble = new int[N];
        groupMarbleCnt = new int[M];
        int sum = 0;
        int min = Integer.MAX_VALUE;
        //숫자구슬 정보 저장 및 최소/최대값 구하기
        for(int i=0;i<N;i++){
            marble[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, marble[i]);	//최소값 : 숫자구슬 최소값
            sum += marble[i];	//최대값 : 모든 숫자구슬의 합
        }
        //이분 탐색을 통해 최소값 구하기
        int result = search(marble, min, sum, N, M);
        //최소값 BufferedWriter 저장
        bw.write(String.valueOf(result));
        bw.newLine();
        //각 그룹의 숫자구슬 개수 BufferedWriter 저장
        for(int i=0;i<M;i++){
            bw.write(String.valueOf(groupMarbleCnt[i]));
            bw.write(" ");
        }
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
    //이분 탐색을 통해 최소값을 탐색하는 함수
    public static int search(int[] marble, int min, int sum, int N, int M){
        int left = min;
        int right = sum;
        while(left < right){
            int mid = (left + right) / 2;
            //M개의 그룹을 만들 수 있을 때
            if(marbleCheck(marble, mid, N, M)){
                right = mid;
            }else{		//M개의 구슬을 만들 수 없을 때
                left = mid + 1;
            }
        }
        return left;	//최소값 출력
    }
    //중간값이 최소값이라고 가정할 때 M개의 구슬을 만들 수 있는지 확인하는 함수
    public static boolean marbleCheck(int[] marble, int mid, int N, int M){
        //현재 그룹 개수
        int gCnt = 1;
        //탐색한 숫자구슬 개수
        int mCnt = 0;
        //현재 그룹의 숫자구슬의 합
        int sum = 0;
        int[] marbleCnt = new int[M];
        //M개의 그룹을 만들 수 있는지 확인하기
        for(int i=0;i<N;i++){
            //그룹의 개수가 M개보다 크거나, 단일 숫자 구슬이 최소값보다 클 때
            if(gCnt > M || marble[i] > mid){
                return false;
            }
            //최소값보다 커졌을 때거나, 남은 숫자구슬 개수 == 남은 그룹 개수
            if(sum + marble[i] > mid || N-i <= M - gCnt){
                //현재 그룹에 속한 숫자구슬 개수 저장
                marbleCnt[gCnt-1] = mCnt;
                gCnt++;		//새로운 그룹 생성
                mCnt = 1;	//새로운 그룹에 숫자구슬 저장
                sum = marble[i];	//새로운 그룹에 맞는 합 초기화
            }else{		//그룹에 숫자구슬 추가
                mCnt++;	
                sum += marble[i];
            }
        }
        //M개의 숫자그룹을 만들 수 없을 때
        if(gCnt > M){
            return false;
        }
        //M개의 숫자구슬을 만들 수 있을 때
        marbleCnt[gCnt-1] = mCnt;
        //현재 M개을 만들었을 때 각 그룹의 속한 숫자구슬 개수 저장
        for(int i=0;i<M;i++){
            groupMarbleCnt[i] = marbleCnt[i];
        }
        return true;
    }
}