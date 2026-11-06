package Jobsheet11.Praktikum1;

public class SavingsAccount extends Account implements InterestBearing {
    private Customer customer;
    private double interestRate;
    private static final double MINIMUM_BALANCE = 50000.0;

    public SavingsAccount(String accountNumber, Customer customer, double balance, double interestRate) {
        super(accountNumber, balance);
        this.customer = customer;
        this.interestRate = interestRate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public boolean canWithdraw(double amount) {
        return (balance - amount) >= MINIMUM_BALANCE;
    }

    @Override
    public void applyInterest() {
        double interest = balance * interestRate;
        deposit(interest);
    }

    @Override
    public double monthlyFee() {
        return 5000.0;
    }

    @Override
    public void printInfo() {
        System.out.println("SavingsAccount [" + accountNumber + "] Owner: " + customer.getName() + ", Balance: " + balance);
    }
}