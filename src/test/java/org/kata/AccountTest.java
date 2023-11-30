package org.kata;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import static org.mockito.Mockito.verify;

class AccountTest {
    @Test
    public void should_print_statement() {
        //given
        Statement statement = Mockito.mock(Statement.class);
        Account account = new Account(statement);

        //when
        account.printStatement();

        //then
        verify(statement).print();
    }

    @Test
    public void should_deposit() {
        //given
        Statement statement = Mockito.mock(Statement.class);
        Account account = new Account(statement);

        //when
        account.deposit(new BigDecimal("1000"), LocalDate.of(2012, Month.JANUARY, 10));

        //then
        verify(statement).deposit(new BigDecimal("1000"), LocalDate.of(2012, Month.JANUARY, 10));
    }

    @Test
    public void should_withdraw() {
        //given
        Statement statement = Mockito.mock(Statement.class);
        Account account = new Account(statement);

        //when
        account.withdraw(new BigDecimal("1000"), LocalDate.of(2012, Month.JANUARY, 10));

        //then
        verify(statement).withdraw(new BigDecimal("1000"), LocalDate.of(2012, Month.JANUARY, 10));
    }
}