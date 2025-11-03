package lotto;

public enum ErrorMessage {
    PARSE_INTEGER_ERROR("유효한 정수값을 입력해주세요."),
    INVALID_SIZE_FOR_RANGE("요청한 숫자의 개수가 생성 가능한 숫자 범위를 초과했습니다."),
    PRICE_MUST_BE_POSITIVE("구입 금액은 양수여야 합니다."),
    INVALID_PRICE_UNIT("구입 금액이 로또 금액으로 나누어 떨어지지 않습니다."),
    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    DUPLICATED_LOTTO_NUMBER("중복된 번호로 로또를 생성할 수 없습니다."),
    LOTTO_NUMBER_IS_OUT_OF_RANGE("로또 번호가 범위를 벗어났습니다.")
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
