package org.kata;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Statement {
    List<Transaction> transactions = new ArrayList<>();
    Map<Transaction, BigDecimal> TransactionTotalAmount = new HashMap<>();
    public String print() {
        transactions.sort(Comparator.comparing(Transaction::date));
        StringBuilder sb = new StringBuilder();
        sb.append("date | credit | debit | balance");
        BigDecimal totalAmount = BigDecimal.ZERO;
        for(var transaction: transactions){
            TransactionTotalAmount.put(transaction, totalAmount);
            totalAmount = totalAmount.add(transaction.amount());
        }

        transactions.sort(Comparator.comparing(Transaction::date).reversed());
        for(var transaction: transactions){
            sb.append("\n");
            sb.append(transaction.print(TransactionTotalAmount.get(transaction)));
        }


        return sb.toString();
    }

    public void deposit(BigDecimal amount, LocalDate date) {
        transactions.add(new Transaction(amount, date));
    }

    public void withdraw(BigDecimal amount, LocalDate date) {
        transactions.add(new Transaction(amount.negate(), date));
    }
}
