package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.ErrorMessage;

public class LottoMachine {
    private final NumberGenerator numberGenerator;

    public LottoMachine(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> issue(int money) {
        validateMoney(money);
        return issueMultiple(calculateQuantity(money));
    }

    private List<Lotto> issueMultiple(int quantity) {
        List<Lotto> issuedLottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            issuedLottos.add(issueSingle());
        }
        return issuedLottos;
    }

    private Lotto issueSingle() {
        List<Integer> numbers = numberGenerator.generateDistinctNumbers(
                LottoConstants.NUMBER_COUNT.getValue(),
                LottoConstants.MIN_NUMBER.getValue(),
                LottoConstants.MAX_NUMBER.getValue()
        );

        return new Lotto(numbers);
    }

    private void validateMoney(int insertedMoney) {
        if (insertedMoney <= 0) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_MUST_BE_POSITIVE.getValue());
        }
    }

    private int calculateQuantity(int money) {
        if (money % LottoConstants.PRICE.getValue() == 0) {
            return money / LottoConstants.PRICE.getValue();
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_PRICE_UNIT.getValue());
    }
}
