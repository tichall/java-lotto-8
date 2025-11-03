package lotto.model;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> winningStats;
    private double profitRate;

    public LottoResult() {
        winningStats = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            winningStats.put(rank, 0);
        }
    }

    public void updateStat(LottoRank rank) {
        if (rank != LottoRank.MISS) {
            winningStats.put(rank, winningStats.get(rank) + 1);
        }
    }

    public double calculateProfitRate(int purchasePrice) {
        if (purchasePrice == 0) {
            return 0.0;
        }

        long totalPrize = 0;
        for (LottoRank rank : LottoRank.values()) {
            int count = winningStats.getOrDefault(rank, 0);
            totalPrize += (long) rank.getPrize() * count;
        }

        return ((double) totalPrize / purchasePrice) * 100;
    }


    public Map<LottoRank, Integer> getWinningStats() {
        return Collections.unmodifiableMap(winningStats);
    }

    public double getProfitRate() {
        return profitRate;
    }

    public void setProfitRate(double profitRate) {
        this.profitRate = profitRate;
    }
}
