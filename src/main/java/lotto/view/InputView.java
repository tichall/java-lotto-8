package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.ErrorMessage;
import lotto.Prompt;

public class InputView {
    public String readPurchasePrice() {
        System.out.println(Prompt.INPUT_PURCHASE_AMOUNT.getValue());
        return Console.readLine();
    }

    public String readWinningNumbers() {
        printSeperator();
        System.out.println(Prompt.INPUT_WINNING_NUMBERS.getValue());
        return Console.readLine();
    }

    public String readBonusNumber() {
        printSeperator();
        System.out.println(Prompt.INPUT_BONUS_NUMBER.getValue());
        return Console.readLine();
    }

    private int readInteger() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PARSE_INTEGER_ERROR.getMessage());
        }
    }

    public void printSeperator() {
        System.out.println();
    }
}
