package com.spaghettiteam.hotelapi.dto;

public class TwoPriceSearch {

    private long lowestPrice;
    private long highestPrice;

    public TwoPriceSearch() {
    }

    public TwoPriceSearch(long lowestPrice, long highestPrice) {
        this.lowestPrice = lowestPrice;
        this.highestPrice = highestPrice;
    }

    public long getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(long lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public long getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(long highestPrice) {
        this.highestPrice = highestPrice;
    }
}
