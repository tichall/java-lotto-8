package lotto.view;

import java.util.List;
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

    public void printSeperator() {
        System.out.println();
    }
}
