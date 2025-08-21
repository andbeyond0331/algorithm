import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    // 단어를 매칭 키로 변환하는 함수
    public static String matchingKeyGenerator(String word) {
        String key = word;
        if (word.length() > 2) {
            char first = word.charAt(0);
            char last = word.charAt(word.length() - 1);
            char[] middle = word.substring(1, word.length() - 1).toCharArray();
            Arrays.sort(middle);
            key = first + "-" + last + "-" + new String(middle);
        } else if (word.length() == 2) {
            key = word.charAt(0) + "-" + word.charAt(1);
        }
        return key;
    }

    // 단어 리스트를 매칭 딕셔너리로 변환
    public static Map<String, String> wordMatchingDict(List<String> wordList) {
        Map<String, String> matchingDict = new HashMap<>();
        for (String word : wordList) {
            String key = matchingKeyGenerator(word);
            matchingDict.put(key, word);
        }
        return matchingDict;
    }

    // 우월효과 적용
    public static String wordSuperiorityEffect(List<String> wordList, String S) {
        StringBuilder answer = new StringBuilder();
        String[] wordSList = S.split(" ");
        Map<String, String> matchingDict = wordMatchingDict(wordList);

        for (int i = 0; i < wordSList.length; i++) {
            String word = wordSList[i];
            String key = matchingKeyGenerator(word);
            if (matchingDict.containsKey(key)) {
                answer.append(matchingDict.get(key));
            } else {
                answer.append(word);
            }
            if (i < wordSList.length - 1) answer.append(" ");
        }
        return answer.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> wordList = new ArrayList<>();

        int N = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < N; i++) {
            wordList.add(br.readLine().trim());
        }

        int M = Integer.parseInt(br.readLine().trim());
        String S = br.readLine().trim();

        System.out.println(wordSuperiorityEffect(wordList, S));
    }
}
