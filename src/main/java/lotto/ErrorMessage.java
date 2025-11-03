package lotto;

public enum ErrorMessage {
    PREFIX("[ERROR]"),
    PARSE_INTEGER_ERROR("유효한 정수값을 입력해주세요."),
    INVALID_SIZE_FOR_RANGE("요청한 숫자의 개수가 생성 가능한 숫자 범위를 초과했습니다."),
    PRICE_MUST_BE_POSITIVE("구입 금액은 양수여야 합니다."),
    INVALID_PRICE_UNIT("구입 금액이 로또 금액으로 나누어 떨어지지 않습니다."),
    ;

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return PREFIX.value + value;
    }
}
