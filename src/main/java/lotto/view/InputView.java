package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.ErrorMessage;
import lotto.Prompt;

public class InputView {
    public int readPurchasePrice() {
        System.out.println(Prompt.INPUT_PURCHASE_AMOUNT);
        return readInteger();
    }

    private int readInteger() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PARSE_INTEGER_ERROR.getValue());
        }
    }
}
