package lotto;

public enum ErrorMessage {
    PREFIX("[ERROR]"),
    PARSE_INTEGER_ERROR("유효한 정수값을 입력해주세요."),
    ;

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return PREFIX.value + value;
    }
}
