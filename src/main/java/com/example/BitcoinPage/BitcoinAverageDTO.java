package com.example.BitcoinPage;

public class BitcoinAverageDTO {
    private long bitcoinAverageValue;
    private int amountAveragedOver;

    public  BitcoinAverageDTO(long bitcoinAverageValue, int amountAveragedOver) {
        this.bitcoinAverageValue = bitcoinAverageValue;
        this.amountAveragedOver = amountAveragedOver;
    }

    public long getAverage() {
        return bitcoinAverageValue;
    }

    public int getAmountAveragedOver() {
        return amountAveragedOver;
    }
}
