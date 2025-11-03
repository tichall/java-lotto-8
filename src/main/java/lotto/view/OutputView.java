package lotto.view;

import java.util.List;
import lotto.ErrorMessage;
import lotto.Prompt;
import lotto.model.Lotto;

public class OutputView {
    public void printPurchasedLottoInfo(List<Lotto> lottos) {
        printSeperator();
        System.out.printf(Prompt.OUTPUT_PURCHASED_LOTTO.getValue(), lottos.size());
        printSeperator();
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getSortedNumbers());
        }
    }

    public void printErrorMessage(String message) {
        System.out.println(Prompt.OUTPUT_ERROR_PREFIX + message);
    }

    private void printSeperator() {
        System.out.println();
    }
}
