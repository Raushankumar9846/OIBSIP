import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account {
    private final String userId;
    private final String pin;
    private double balance;
    private final ArrayList<Transaction> transactions = new ArrayList<>();

    public Account(String userId, String pin, double openingBalance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = openingBalance;
        transactions.add(new Transaction("OPENING BALANCE", openingBalance, "Account initialized"));
    }

    public String getUserId() { return userId; }
    public boolean verifyPin(String enteredPin) { return pin.equals(enteredPin); }
    public double getBalance() { return balance; }
    public List<Transaction> getTransactions() { return Collections.unmodifiableList(transactions); }

    public void deposit(double amount, String details) {
        balance += amount;
        transactions.add(new Transaction("DEPOSIT", amount, details));
    }

    public boolean withdraw(double amount, String details) {
        if (amount <= 0 || amount > balance) return false;
        balance -= amount;
        transactions.add(new Transaction("WITHDRAWAL", amount, details));
        return true;
    }

    public void recordTransferOut(double amount, String recipientId) {
        balance -= amount;
        transactions.add(new Transaction("TRANSFER OUT", amount, "To account " + recipientId));
    }

    public void recordTransferIn(double amount, String senderId) {
        balance += amount;
        transactions.add(new Transaction("TRANSFER IN", amount, "From account " + senderId));
    }
}
