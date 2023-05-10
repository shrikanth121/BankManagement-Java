package src.main.model.account;

import src.main.model.account.impl.Taxable;

public class Chequing extends Account implements Taxable {

    private static final double OVERDRAFT_AMT = 5.50;
    private static final double OVERDRAFT_LIMIT = 200;
    private static final double TAXABLE_AMT = 3000;
    private static final double TAX_RATE = 0.15;

    public Chequing(String id, String name, double amount) {
        super(id, name, amount);
    }

    public Chequing(Chequing source) {
        super(source);
    }

    @Override
    public Account clone() {
        return new Chequing(this);
    }

    @Override
    public void deposit(double amount) {
        super.setAmount(super.round(super.getAmount() + amount));

    }

    @Override
    public boolean withdrawal(double amount) {
        if (super.getAmount() - amount < OVERDRAFT_LIMIT) {
            return false;
        }
        if (super.getAmount() - amount < 0) {
            super.setAmount(super.round((super.getAmount() - amount) - OVERDRAFT_AMT));
            return true;
        }
        super.setAmount(super.round(super.getAmount() - amount));
        return true;
    }

    @Override
    public void tax(double income) {
        double tax = Math.max(0, income - TAXABLE_AMT) * TAX_RATE;
        super.setAmount(super.round(super.getAmount() - tax));
    }
}
