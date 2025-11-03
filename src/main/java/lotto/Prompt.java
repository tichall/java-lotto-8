package lotto;

public enum Prompt {
    // Input prompt
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),

    // Output prompt
    OUTPUT_PURCHASED_LOTTO("%d개를 구매했습니다.")
    ;

    private final String value;

    Prompt(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
