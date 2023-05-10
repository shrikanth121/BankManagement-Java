package src.main.model.account;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public abstract class Account {
    private String id;
    private String name;
    private double amount;

    public abstract void deposit(double amount);

    public abstract boolean withdrawal(double amount);

    public abstract Account clone();

    public Account(String id, String name, double amount) {
        if (id == null || id.isBlank() || name == null || name.isBlank()) {
            throw new IllegalArgumentException("INVALID PARAM");
        }
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public Account(Account source) {
        this.id = source.id;
        this.name = source.name;
        this.amount = source.amount;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("INVALID ID");
        }
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("INVALID NAME");
        }
        this.name = name;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    protected double round(double amount) {
        DecimalFormat formatter = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.ENGLISH));
        return Double.parseDouble(formatter.format(amount));
    }

    @Override
    public String toString() {
        return (this.getClass().getSimpleName()) + "    " +
                "\t" + this.id + "" +
                "\t" + this.name + "" +
                "\t$" + this.amount + "";
    }

}
