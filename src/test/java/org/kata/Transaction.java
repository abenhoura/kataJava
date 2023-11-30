package org.kata;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public record Transaction(BigDecimal amount, LocalDate date) {

    public Transaction(BigDecimal amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    public String print(BigDecimal bigDecimal) {
        var balance = amount.add(bigDecimal);
        StringBuilder sb = new StringBuilder();
        sb.append(date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))); sb.append( " | ");
        if(amount.compareTo(BigDecimal.ZERO)>0){
            sb.append(setScale(amount)); sb.append( " | | ");
        } else{
            sb.append( "| "); sb.append(setScale(amount.negate())); sb.append( " | ");
        }
        sb.append(setScale(balance));
        return sb.toString();
    }

    private static BigDecimal setScale(BigDecimal balance) {
        return balance.setScale(2, RoundingMode.HALF_DOWN);
    }
}
