package generator;

import configuration.Configuration;

import java.util.Random;
public class NumberGenerator {



    private static final String REGION = "116 RUS";
    private static final String[] CHARS = new String[]{"A", "B", "E", "K", "M", "H", "O", "P", "C", "T", "Y", "X" };
    private static final String[] DIGITS = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    private static int[] currentNumber = Configuration.getStartNumber();



    public static String getRandomNumber() {
        Random r = new Random();
        int[] symbols = new int[6];
        symbols[0] = r.nextInt(12);

        for (int i = 1; i <= 3; i++) {
            symbols[i] = r.nextInt(10);
        }

        symbols[4] = r.nextInt(12);
        symbols[5] = r.nextInt(12);

        StringBuilder builder = new StringBuilder();
        builder.append(CHARS[symbols[0]]);
        builder.append(DIGITS[symbols[1]]);
        builder.append(DIGITS[symbols[2]]);
        builder.append(DIGITS[symbols[3]]);
        builder.append(CHARS[symbols[4]]);
        builder.append(CHARS[symbols[5]]);
        builder.append(" " + REGION);

        return builder.toString();
    }

    public static String getNextNumber() throws NumbersLimitException {
        int number = currentNumber[1] * 100 + currentNumber[2] * 10 + currentNumber[3];
        if (number >= 0 && number < 999) {
            number++;
            currentNumber[1] = number / 100;
            currentNumber[2] = (number / 10) % 10;
            currentNumber[3] = (number % 100) % 10;
        } else {
            if (currentNumber[5] < 11) {
                currentNumber[5]++;
            } else if (currentNumber[5] == 11) {
                if (currentNumber[4] < 11) {
                    currentNumber[4]++;
                    currentNumber[5] = 0;
                } else if (currentNumber[4] == 11) {
                    if (currentNumber[0] < 11) {
                        currentNumber[0]++;
                        currentNumber[4] = 0;
                        currentNumber[5] = 0;
                    } else if (currentNumber[0] == 11) {
                        throw new NumbersLimitException();
                    }
                }
            }
            currentNumber[1] = 0;
            currentNumber[2] = 0;
            currentNumber[3] = 0;
        }

        StringBuilder builder = new StringBuilder();
        builder.append(CHARS[currentNumber[0]]);
        builder.append(DIGITS[currentNumber[1]]);
        builder.append(DIGITS[currentNumber[2]]);
        builder.append(DIGITS[currentNumber[3]]);
        builder.append(CHARS[currentNumber[4]]);
        builder.append(CHARS[currentNumber[5]]);
        builder.append(" " + REGION);

        return builder.toString();
    }
}
