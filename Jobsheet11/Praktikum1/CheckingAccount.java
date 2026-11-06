package Jobsheet11.Praktikum1;

public class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, Customer customer, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean canWithdraw(double amount) {
        return (balance + overdraftLimit) >= amount;
    }

    @Override
    public double monthlyFee() {
        return 5000.0;
    }

    @Override
    public void printInfo() {
        System.out.println("CheckingAccount [" + accountNumber + "] Balance: " + balance);
    }
}