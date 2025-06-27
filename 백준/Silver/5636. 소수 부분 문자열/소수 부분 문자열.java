import java.io.*;
import java.util.*;

public class Main {

    static boolean[] isPrime = new boolean[100001];
    static List<Integer> primeList = new ArrayList<>();

    public static void isPrime(){ // 100,000까지의 소수 먼저 확인
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(long i = 2; i < 100001; i++){
            if(isPrime[(int)i]){
                primeList.add((int)i);
                for(long j = i * i; j < 100001; j += i){
                    isPrime[(int)j] = false;
                }
            }
        }
        Collections.sort(primeList, Comparator.reverseOrder()); // 소수 역순 정렬
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        isPrime();
        String testCase = br.readLine();
        while(!testCase.equals("0")){ // 0이 아닌 입력이라면
            for(int i = 0; i < primeList.size(); i++){ // 큰 소수부터 확인
                if(testCase.contains(primeList.get(i).toString())){
                    System.out.println(primeList.get(i));
                    break;
                }
            }
            testCase = br.readLine();
        }
    }
}