package src.main.model.account;

public class Loan extends Account {

    private static final double INTEREST_RATE = 0.02;
    private static final double MAX_DEBT = 0.02;

    public Loan(String id, String name, double amount) {
        super(id, name, amount);
    }

    public Loan(Loan source) {
        super(source);
    }

    @Override
    public Account clone() {
        return new Loan(this);
    }

    @Override
    public void deposit(double amount) {
        super.setAmount(super.round(super.getAmount() - amount));

    }

    @Override
    public boolean withdrawal(double amount) {
        if (super.getAmount() + amount > MAX_DEBT) {
            return false;
        }
        super.setAmount(super.round(super.getAmount() + amount + (amount * INTEREST_RATE)));
        return true;
    }
}
