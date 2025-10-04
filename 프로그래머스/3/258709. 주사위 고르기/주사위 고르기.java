import java.util.*;

class Solution {

    int n;
    boolean[] visited;
    int[] answer;
    int maxWinCount = -1;

    private void generateSumCases(int depth, int[] selectedDice, int[][] dice, List<Integer> results, int sum) {
        if (depth == selectedDice.length) {
            results.add(sum);
            return;
        }
        int diceIdx = selectedDice[depth];
        for (int face = 0; face < 6; face++) {
            generateSumCases(depth + 1, selectedDice, dice, results, sum + dice[diceIdx][face]);
        }
    }

    private void chooseDiceAndSimulate(int depth, int start, int[] selectedDice, int[][] dice) {
        if (depth == n / 2) {
            boolean[] isSelected = new boolean[n];
            for (int idx : selectedDice) isSelected[idx] = true;

            int[] otherDice = new int[n / 2];
            int pos = 0;
            for (int i = 0; i < n; i++) if (!isSelected[i]) otherDice[pos++] = i;

            List<Integer> aSums = new ArrayList<>();
            List<Integer> bSums = new ArrayList<>();
            generateSumCases(0, selectedDice, dice, aSums, 0);
            generateSumCases(0, otherDice, dice, bSums, 0);

            Collections.sort(aSums);
            Collections.sort(bSums);

            int[] bPrefixWins = new int[501];
            int prev = -1, count = 0;
            for (int val : bSums) {
                if (val != prev) {
                    for (int i = prev + 1; i <= val && i < bPrefixWins.length; i++) {
                        bPrefixWins[i] = count;
                    }
                    prev = val;
                }
                count++;
            }
            if (prev + 1 < bPrefixWins.length) {
                Arrays.fill(bPrefixWins, prev + 1, bPrefixWins.length, count);
            }

            int winCount = 0;
            for (int val : aSums) {
                winCount += (val < bPrefixWins.length ? bPrefixWins[val] : bPrefixWins[bPrefixWins.length - 1]);
            }

            if (winCount > maxWinCount) {
                maxWinCount = winCount;
                answer = Arrays.copyOf(selectedDice, selectedDice.length);
            }
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selectedDice[depth] = i;
                chooseDiceAndSimulate(depth + 1, i + 1, selectedDice, dice);
                visited[i] = false;
            }
        }
    }

    public int[] solution(int[][] dice) {
        n = dice.length;
        visited = new boolean[n];
        answer = new int[n / 2];
        chooseDiceAndSimulate(0, 0, new int[n / 2], dice);
        return Arrays.stream(answer).map(i -> i + 1).toArray(); // 1-based index
    }
}
