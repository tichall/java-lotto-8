package lotto.service;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoMachine;

public class LottoService {
    private final LottoMachine lottoMachine;

    public LottoService(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public List<Lotto> purchaseAndIssueLottos(int price) {
        return lottoMachine.issue(price);
    }
}
