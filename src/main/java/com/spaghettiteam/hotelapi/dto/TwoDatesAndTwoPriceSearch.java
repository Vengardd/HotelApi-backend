package com.spaghettiteam.hotelapi.dto;

public class TwoDatesAndTwoPriceSearch {

    private TwoDatesSearch twoDates;
    private TwoPriceSearch twoPrices;

    public TwoDatesAndTwoPriceSearch(TwoDatesSearch twoDates, TwoPriceSearch twoPrices) {
        this.twoDates = twoDates;
        this.twoPrices = twoPrices;
    }

    public TwoPriceSearch getTwoPrices() {
        return twoPrices;
    }

    public void setTwoPrices(TwoPriceSearch twoPrices) {
        this.twoPrices = twoPrices;
    }

    public TwoDatesSearch getTwoDates() {
        return twoDates;
    }

    public void setTwoDates(TwoDatesSearch twoDates) {
        this.twoDates = twoDates;
    }
}
