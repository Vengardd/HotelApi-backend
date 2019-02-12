package com.spaghettiteam.hotelapi.validation;

import com.spaghettiteam.hotelapi.dto.TwoPriceSearch;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;

@Component
public class TwoPricesSearchValidator implements Validator<TwoPriceSearch> {

    private Collection<Rule<TwoPriceSearch>> twoPriceSearchRules = new LinkedList<>();

    @Override
    public void validate(TwoPriceSearch twoPriceSearch) {
        twoPriceSearchRules.add(new LowestPriceIsLower());
        for (Rule<TwoPriceSearch> r:
                twoPriceSearchRules) {
            r.validate(twoPriceSearch);
        }
    }
}
