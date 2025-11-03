package lotto.service;

import java.util.List;
import lotto.ErrorMessage;
import lotto.model.Lotto;
import lotto.model.LottoConstants;
import lotto.model.LottoMachine;
import lotto.model.LottoRank;
import lotto.model.LottoResult;

public class LottoService {
    private final LottoMachine lottoMachine;

    public LottoService(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public List<Lotto> purchaseAndIssueLottos(int price) {
        return lottoMachine.issue(calculateQuantity(price));
    }

    public LottoResult calculateResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        LottoResult lottoResult = new LottoResult();

        for (Lotto lotto : lottos) {
            LottoRank rank = lotto.getLottoRank(winningNumbers, bonusNumber);
            lottoResult.updateStat(rank);
        }

        updateProfitRate(lottoResult, lottos);
        return lottoResult;
    }

    private int calculateQuantity(int price) {
        if (price % LottoConstants.PRICE.getValue() == 0) {
            return price / LottoConstants.PRICE.getValue();
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_PRICE_UNIT.getMessage());
    }

    private void updateProfitRate(LottoResult lottoResult, List<Lotto> lottos) {
        int purchasePrice = lottos.size() * LottoConstants.PRICE.getValue();
        double profitRate = lottoResult.calculateProfitRate(purchasePrice);
        lottoResult.setProfitRate(roundToSecondDecimal(profitRate));
    }

    private double roundToSecondDecimal(double rate) {
        return Math.round(rate * 10.0) / 10.0;
    }
}
