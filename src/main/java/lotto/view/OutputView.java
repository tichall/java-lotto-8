package lotto.view;

import java.util.List;
import lotto.Prompt;
import lotto.model.Lotto;

public class OutputView {
    public void printPurchasedLottoInfo(List<Lotto> lottos) {
        System.out.printf(Prompt.OUTPUT_PURCHASED_LOTTO.getValue(), lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getSortedNumbers());
        }
    }
}
