package org.kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StatementTest {
    @Test
    public void should_print() {
        //given
        Statement statement = new Statement();

        //when
        String print = statement.print();

        //then
        Assertions.assertEquals("date | credit | debit | balance", print);
    }
}