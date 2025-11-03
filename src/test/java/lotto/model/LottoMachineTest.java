package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import lotto.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoMachineTest {
    private LottoMachine lottoMachine;

    @BeforeEach
    void init() {
        this.lottoMachine = new LottoMachine(new NumberGenerator());
    }

    @ParameterizedTest
    @CsvSource({"1000, 1", "5000, 5", "10000, 10"})
    @DisplayName("금액을 받아 알맞은 개수만큼 로또를 발행한다.")
    void issue(int money, int expected) {
        List<Lotto> result = lottoMachine.issue(money);

        assertAll(
                () -> assertThat(result.size())
                        .as("로또 개수 검증")
                        .isEqualTo(expected)
        );
    }

    @Nested
    @DisplayName("issue 예외 테스트")
    class Fail {
        @Test
        @DisplayName("구입 금액이 음수인 경우 예외가 발생한다.")
        void issue_예외_금액_음수() {
            assertThatThrownBy(() -> lottoMachine.issue(-1000))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.PRICE_MUST_BE_POSITIVE.getValue());
        }

        @ParameterizedTest
        @ValueSource(ints = {100, 1800})
        @DisplayName("구입 금액이 로또 금액으로 나누어 떨어지지 않으면 예외가 발생한다.")
        void issue_예외_나누어_떨어지지_않는_금액(int money) {
            assertThatThrownBy(() -> lottoMachine.issue(money))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.INVALID_PRICE_UNIT.getValue());
        }
    }
}
