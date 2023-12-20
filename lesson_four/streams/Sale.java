package lesson_four.streams;

import java.time.LocalDate;

public class Sale {
    private String product;
    private LocalDate date;
    private int amount;

    public Sale(String product, LocalDate date, int amount) {
        this.product = product;
        this.date = date;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public String getProduct() {
        return this.product;
    }

    public int getAmount() {
        return this.amount;
    }
}
