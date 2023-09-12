package columndivision.divisionprocess;

import java.util.Arrays;

public class DivisionProcess {

    private String prepareHead(int dividend, int divisor) {

        Integer divisorSum;
        Integer addedDigits;

        StringBuilder firstString = new StringBuilder();
        StringBuilder separateFigures = new StringBuilder();

        firstString.append(" _").append(dividend).append("|").append(divisor).append("\n");

        int dividendCounter = String.valueOf(dividend).length();

        String[] dividedDigits = String.valueOf(dividend).split("");

        for (int i = 0; i < dividedDigits.length; i++) {

            separateFigures.append(dividedDigits[i]);

            addedDigits = Integer.parseInt(separateFigures.toString());

            if (addedDigits >= divisor) {

                divisorSum = addedDigits / divisor * divisor;

                int y = (divisorSum.toString().length());
                char[] hyphenCounter = new char[y];
                Arrays.fill(hyphenCounter, '-');

                int k = (dividendCounter - divisorSum.toString().length());
                char[] spaceCounter = new char[k];
                Arrays.fill(spaceCounter, ' ');

                firstString.append("  ").append(divisorSum).append(spaceCounter).append("|").append("\n");
                firstString.append("  ").append(hyphenCounter).append(spaceCounter).append("|");

                break;
            }
        }
        return firstString.toString();
    }

    private String prepareBody(int dividend, int divisor) {

        Integer divisorSum;
        Integer firstRemainder;
        Integer addedDigits;
        Integer secondAddedNumbers;

        StringBuilder remainder = new StringBuilder();
        StringBuilder separateFigures = new StringBuilder();
        StringBuilder nextDividendSpases = new StringBuilder();

        StringBuilder nextString = new StringBuilder();

        String[] dividedDigits = String.valueOf(dividend).split("");

        for (int i = 0; i < dividedDigits.length; i++) {

            separateFigures.append(dividedDigits[i]);

            addedDigits = Integer.parseInt(separateFigures.toString());

            if (addedDigits >= divisor) {

                firstRemainder = addedDigits % divisor;
                remainder.append(firstRemainder);

                break;
            }
        }

        int p = (separateFigures.length());
        char[] spaceCounterSeparateFigures = new char[p];
        Arrays.fill(spaceCounterSeparateFigures, ' ');

        for (int i = p; i < dividedDigits.length; i++) {

            int u = (separateFigures.toString().length() - remainder.toString().length());
            char[] dividendCounterSpases = new char[u];
            Arrays.fill(dividendCounterSpases, ' ');
            nextDividendSpases.append(dividendCounterSpases);

            remainder.append(dividedDigits[i]);
            secondAddedNumbers = Integer.parseInt(remainder.toString());

            if (secondAddedNumbers >= divisor) {

                divisorSum = secondAddedNumbers / divisor * divisor;
                separateFigures.replace(0, separateFigures.length(), divisorSum.toString());

                int y = (divisorSum.toString().length());
                char[] hyphenCounter = new char[y];
                Arrays.fill(hyphenCounter, '-');

                nextString.append(" ").append(nextDividendSpases).append("_").append(secondAddedNumbers).append("\n");
                nextString.append("  ").append(nextDividendSpases).append(divisorSum).append("\n");
                nextString.append("  ").append(nextDividendSpases).append(hyphenCounter).append("\n");

                firstRemainder = secondAddedNumbers % divisor;

                remainder.replace(0, remainder.length(), firstRemainder.toString());
            }
        }

        nextString.append("   ").append(nextDividendSpases).append(remainder);

        return nextString.toString();
    }

    private String prepareQuotient(int dividend, int divisor) {

        Integer addedDigits;
        Integer firstRemainder;

        StringBuilder quotient = new StringBuilder();
        StringBuilder remainder = new StringBuilder();

        String[] dividedDigits = String.valueOf(dividend).split("");

        for (int i = 0; i < dividedDigits.length; i++) {

            remainder.append(dividedDigits[i]);

            addedDigits = Integer.parseInt(remainder.toString());

            if (addedDigits >= divisor) {

                firstRemainder = addedDigits % divisor;

                remainder.replace(0, remainder.length(), firstRemainder.toString());

                quotient.append(addedDigits / divisor);
            } else {
                quotient.append(0);
            }
        }
        return quotient.toString();
    }

    public String prepareHyphenOfQuotient(int dividend, int divisor) {

        StringBuilder hyphenOfQuotient = new StringBuilder();

        int k = (prepareQuotient(dividend, divisor).length());
        char[] hyphenOfQuotientCounter = new char[k];
        Arrays.fill(hyphenOfQuotientCounter, '-');

        hyphenOfQuotient.append(hyphenOfQuotientCounter);

        return hyphenOfQuotient.toString();
    }

    public String divisionResult(int dividend, int divisor) {

        if (divisor == 0) {

            throw new IllegalArgumentException("Divisor can't be 0");
        }

        if (dividend < divisor) {

            return "";
        }

        String[] dividedPrepareHead = String.valueOf(prepareHead(dividend, divisor)).split("\n");

        StringBuilder finalString = new StringBuilder();

        finalString.append(dividedPrepareHead[0]).append("\n");
        finalString.append(dividedPrepareHead[1]).append(prepareHyphenOfQuotient(dividend, divisor)).append("\n");
        finalString.append(dividedPrepareHead[2]).append(prepareQuotient(dividend, divisor)).append("\n");
        finalString.append(prepareBody(dividend, divisor));

        return finalString.toString();
    }
}
