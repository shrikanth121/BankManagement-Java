package src.main.model.account;

public class Savings extends Account {

    private static final double WITHDRAWAL_FEE = 5.00;

    public Savings(String id, String name, double amount) {
        super(id, name, amount);
    }

    public Savings(Savings source) {
        super(source);
    }

    @Override
    public Account clone() {
        return new Savings(this);
    }

    @Override
    public void deposit(double amount) {
        super.setAmount(super.round(super.getAmount() + amount));
    }

    @Override
    public boolean withdrawal(double amount) {
        super.setAmount(super.round(super.getAmount() - amount - WITHDRAWAL_FEE));
        return true;
    }
}
