package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.utils.InputParser;
import lotto.utils.LottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        List<Lotto> lottos = purchaseLottos();
        outputView.printPurchasedLottoInfo(lottos);

        List<Integer> winningNumbers = setWinningNumbers();
        Integer bonusNumber = setBonusNumber();
    }

    private List<Lotto> purchaseLottos() {
        try {
            int price = inputView.readPurchasePrice();
            return lottoService.purchaseAndIssueLottos(price);
        } catch(IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return purchaseLottos();
        }
    }

    private List<Integer> setWinningNumbers() {
        try {
            List<Integer> winningNumbers = InputParser.parseNumbers(inputView.readWinningNumbers());
            LottoValidator.validateLottoNumbers(winningNumbers);
            return winningNumbers;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return setWinningNumbers();
        }
    }

    private Integer setBonusNumber() {
        try {
            Integer bonusNumber = InputParser.parseNumber(inputView.readBonusNumber());
            LottoValidator.validateNumberInRange(bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return setBonusNumber();
        }
    }
}