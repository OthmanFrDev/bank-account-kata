package dev.othmanfr.model;

import lombok.Getter;

/**
 * @author {Othman Fr}
 **/
@Getter
public enum Currency {
    EUR("€"), USD("$"), GBP("£");
    private final String symbol;
    Currency(String symbol) {
        this.symbol = symbol;
    }
}
