package org.kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

class TransactionTest {

    @Test
    public void should_print() {
        //given
        Transaction transaction = new Transaction(new BigDecimal("1000"), LocalDate.of(2012, Month.JANUARY, 10));

        //when
        var print = transaction.print(new BigDecimal(500));

        //then
        Assertions.assertEquals("10/01/2012 | 1000.00 | | 1500.00", print);

    }

}