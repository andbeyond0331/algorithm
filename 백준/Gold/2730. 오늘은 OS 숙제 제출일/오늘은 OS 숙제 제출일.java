import java.io.*;

public class Main {
    static final int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    static int toDays(int y, int m, int d) {
        int days = d;
        for (int i = 0; i < m - 1; i++) {
            days += monthDays[i];
        }
        if (m > 2 && isLeap(y)) days += 1;
        days += 365 * (y - 1);
        days += (y - 1) / 4 - (y - 1) / 100 + (y - 1) / 400;
        return days;
    }
    static boolean isValid(int y, int m, int d) {
        if (m == 2) {
            return d <= (isLeap(y) ? 29 : 28);
        }
        return true;
    }
    static boolean isLeap(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            String[] deadLine = input[0].split("/");
            String[] report = input[1].split("/");

            final int deadMonth = Integer.parseInt(deadLine[0]);
            final int deadDay = Integer.parseInt(deadLine[1]);
            final int deadYear = Integer.parseInt(deadLine[2]);
            final int deadDays = toDays(deadYear, deadMonth, deadDay);

            final int reportMonth = Integer.parseInt(report[0]);
            final int reportDay = Integer.parseInt(report[1]);

            int bestDiff = Integer.MAX_VALUE;
            int bestSignedDiff = 0;
            String bestDate = null;

            // Solve
            for (int y = deadMonth - 1; y <= deadYear + 1; ++y) {
                if (!isValid(y, deadMonth, deadDay)) {
                    continue;
                }
                final int reportDays = toDays(y, reportMonth, reportDay);
                final int diff = Math.abs(deadDays - reportDays);
                if (diff < bestDiff) {
                    bestDiff = diff;
                    bestSignedDiff = reportDays - deadDays;
                    bestDate = reportMonth + "/" + reportDay + "/" + y;
                }
            }

            // Output
            if (bestDiff == 0) {
                sb.append("SAME DAY\n");
            } else if (bestDiff <= 7) {
                sb.append(bestDate).append(" IS ").append(bestDiff)
                        .append(" DAY")
                        .append(bestDiff == 1 ? " " : "S ")
                        .append(bestSignedDiff > 0 ? "AFTER\n" : "PRIOR\n");
            } else {
                sb.append("OUT OF RANGE\n");
            }
        }
        System.out.println(sb);
    }
}