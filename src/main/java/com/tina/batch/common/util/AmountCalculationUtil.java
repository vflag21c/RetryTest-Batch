package com.tina.batch.common.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class AmountCalculationUtil {

    private static final BigDecimal TAX_RATE = new BigDecimal("1.1");
    private static final MathContext mathContext = new MathContext(23, RoundingMode.HALF_UP);

    public static BigDecimal calculateFee(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }
        BigDecimal amountDividedByTax = amount.divide(TAX_RATE, mathContext).abs();
        return amountDividedByTax.multiply(signOf(amount));
    }

    public static BigDecimal calculateVatAmount(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }
        BigDecimal amountDividedByTax = amount.divide(TAX_RATE, mathContext).abs();
        BigDecimal difference = amount.abs().subtract(amountDividedByTax);
        return difference.multiply(signOf(amount));
    }

    // amount의 부호 구하기
    private static BigDecimal signOf(BigDecimal amount) {
        return amount.compareTo(BigDecimal.ZERO) != 0 ? amount.divide(amount.abs(), mathContext) : BigDecimal.ZERO;
    }

    public static void main(String[] args) {
        BigDecimal fee = calculateFee(new BigDecimal(1000));
        BigDecimal vatAmount = calculateVatAmount(new BigDecimal(1000));
        System.out.println(fee.add(vatAmount));
    }
}


