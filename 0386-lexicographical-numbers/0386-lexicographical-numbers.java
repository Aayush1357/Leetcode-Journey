public class Solution {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> ln = new ArrayList<>();
        for (int start = 1; start <= 9; ++start) {
            generateLexicalNumbers(start, n, ln);
        }
        return ln;
    }

    private void generateLexicalNumbers(
        int currentNumber,
        int l,
        List<Integer> result
    ) {
        if (currentNumber > l) return;

        result.add(currentNumber);

        for (int nextDigit = 0; nextDigit <= 9; ++nextDigit) {
            int nextNumber = currentNumber * 10 + nextDigit;
            if (nextNumber <= l) {
                generateLexicalNumbers(nextNumber, l, result);
            } else {
                break;
            }
        }
    }
}