package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import lotto.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberGeneratorTest {
    private NumberGenerator numberGenerator;

    @BeforeEach
    void init() {
        this.numberGenerator = new NumberGenerator();
    }

    @Test
    @DisplayName("요청한 숫자 범위 내에서 중복되지 않는 난수 리스트를 개수만큼 뽑아 반환한다.")
    void generateDistinctNumbers() {
        // given
        int size = 5;
        int min = 1;
        int max = 10;

        // when
        List<Integer> result = numberGenerator.generateDistinctNumbers(size, min, max);

        // then
        long distinctCount = result.stream().distinct().count();

        assertAll(
                () -> assertThat(result)
                        .as("리스트 크기 검증")
                        .hasSize(size),
                () -> assertThat(result)
                        .as("숫자 범위 검증")
                        .allMatch(num -> num >= min && num <= max),
                () -> assertThat(distinctCount)
                        .as("중복 숫자 없음 검증")
                        .isEqualTo(size)
        );
    }

    @Test
    @DisplayName("범위의 크기와 요청 크기가 같으면 전체 숫자를 포함해야 한다.")
    void generateDistinctNumbers_경계값_검증() {
        // given
        int size = 3;
        int min = 1;
        int max = 3;

        // when
        List<Integer> result = numberGenerator.generateDistinctNumbers(size, min, max);

        assertThat(result)
                .as("포함된 숫자 검증")
                .containsExactlyInAnyOrder(1, 2, 3);
    }

    @Test
    @DisplayName("예외 테스트 : 요청한 숫자의 개수가 생성 가능한 숫자 범위를 초과한 경우 예외가 발생한다.")
    void generateDistinctNumbers_예외_유효하지_않은_size() {
        // given
        int size = 5;
        int min = 1;
        int max = 2;

        assertThatThrownBy(() -> numberGenerator.generateDistinctNumbers(size, min, max))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_SIZE_FOR_RANGE.getValue());
    }
}