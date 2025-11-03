package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import lotto.Prompt;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoResult;

public class OutputView {
    public void printPurchasedLottoInfo(List<Lotto> lottos) {
        printSeperator();
        System.out.printf(Prompt.OUTPUT_PURCHASED_LOTTO.getValue(), lottos.size());
        printSeperator();
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getSortedNumbers());
        }
    }

    public void printWinningResult(LottoResult lottoResult) {
        printSeperator();
        System.out.println(Prompt.OUTPUT_RESULT_HEADER.getValue());
        printRankStats(lottoResult.getWinningStats());
        System.out.printf(Prompt.OUTPUT_RESULT_PROFIT.getValue(), lottoResult.getProfitRate());
    }

    private void printRankStats(Map<LottoRank, Integer> winningStats) {
        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.MISS)
                .sorted(Comparator.reverseOrder()) // Enum 선언 순서 기반 역순
                .forEach(rank -> {
                    int count = winningStats.getOrDefault(rank, 0);

                    System.out.printf(Prompt.OUTPUT_RANK_RESULT.getValue(),
                            rank.getMatchCount(),
                            rank.getBonusText(),
                            rank.getPrize(),
                            count);
                });
    }

    public void printErrorMessage(String message) {
        System.out.println(Prompt.OUTPUT_ERROR_PREFIX.getValue() + message);
    }

    private void printSeperator() {
        System.out.println();
    }
}
