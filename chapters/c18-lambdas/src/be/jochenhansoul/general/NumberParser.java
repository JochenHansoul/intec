package be.jochenhansoul.general;

import java.math.BigDecimal;

@FunctionalInterface
public interface NumberParser {
    BigDecimal parse(String s);
}
