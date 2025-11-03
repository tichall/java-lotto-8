package lotto.model;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    private final int matchCount;
    private final boolean bonusRequired;
    private final int prize;

    LottoRank(int matchCount, boolean bonusRequired, int prize) {
        this.matchCount = matchCount;
        this.bonusRequired = bonusRequired;
        this.prize = prize;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int getPrize() {
        return this.prize;
    }

    public String getBonusText() {
        return bonusRequired ? ", 보너스 볼 일치" : "";
    }

    public static LottoRank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount < 3) {
            return MISS;
        }
        if (matchCount == 5) {
            if (matchBonus) {
                return SECOND;
            }
            return THIRD;
        }
        for (LottoRank rank : values()) {
            if (rank.matchCount == matchCount) {
                return rank;
            }
        }
        return MISS;
    }
}
