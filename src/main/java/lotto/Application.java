package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoMachine;
import lotto.model.NumberGenerator;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController controller = new LottoController(
                new InputView(),
                new OutputView(),
                new LottoService(new LottoMachine(new NumberGenerator()))
        );

        controller.run();
    }
}
