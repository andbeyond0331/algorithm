import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(stringTokenizer.nextToken()); //바퀴 길이
        int K = Integer.parseInt(stringTokenizer.nextToken()); //숫자 횟수

        char[] wheel = new char[N];
        int arrow = 0;
        int updateIdx = 0;

        //K번만큼 반복
        while (K-- > 0) {
            stringTokenizer = new StringTokenizer(br.readLine());
            //숫자입력
            int change = Integer.parseInt(stringTokenizer.nextToken());
            char current = stringTokenizer.nextToken().charAt(0);

            //첫번째 숫자일 경우 초기화
            if (wheel[0] == '\u0000') {
                wheel[0] = current;
                continue;
            }

            //화살표 위치 업데이트
            arrow += change;
            updateIdx = arrow % N;
            try {
                //바퀴 업데이트
                updateWheel(current, updateIdx, wheel);
            } catch (Exception e) {
                System.out.println("!");
                return;
            }
        }

        System.out.print(createAnswer(wheel, updateIdx));
    }

    //비밀번호 문자열
    private static String createAnswer(char[] wheel, int updateIdx) {
        StringBuilder stringBuilder = new StringBuilder();

        //왼쪽
        for (int i = updateIdx; i >= 0; i--) {
            char update = wheel[i]== '\u0000' ? '?' : wheel[i];
            stringBuilder.append(update);
        }

        //오른쪽
        for (int i = wheel.length - 1; i > updateIdx; i--) {
            char update = wheel[i]== '\u0000' ? '?' : wheel[i];
            stringBuilder.append(update);
        }
        return stringBuilder.toString();
    }

    //바퀴 업데이트
    private static void updateWheel(char current, int updateIdx, char[] wheel) {

        // 같은 것이 들어있는 경우
        if (wheel[updateIdx] == current) {
            return;
        }

        // 비어있는 경우 && 중복이 아닌경우
        if (wheel[updateIdx]== '\u0000' && !duplicate(current, wheel)) {
            wheel[updateIdx] = current;
            return;
        }

        // 다른 것이 들어있거나 중복인 경우
        throw new IllegalArgumentException();

    }
    
    // 중복 검사
    private static boolean duplicate(char current, char[] wheel) {
        // 배열을 스트림으로 변환하여 중복 여부 확인
        return IntStream.range(0, wheel.length).mapToObj(i-> wheel[i]).anyMatch(alphabet -> alphabet == current);
    }
}