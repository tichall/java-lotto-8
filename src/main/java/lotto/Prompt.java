package lotto;

public enum Prompt {
    // Input prompt
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요"),

    // Output prompt
    OUTPUT_PURCHASED_LOTTO("%d개를 구매했습니다."),
    OUTPUT_RESULT_HEADER("당첨 통계\n---"),
    OUTPUT_RANK_RESULT("%d개 일치%s (%,d원) - %d개\n"),
    OUTPUT_RESULT_PROFIT("총 수익률은 %.1f%%입니다."),
    OUTPUT_ERROR_PREFIX("[ERROR]")
    ;

    private final String value;

    Prompt(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
