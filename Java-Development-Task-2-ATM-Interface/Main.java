public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        // Demo accounts for local testing only. Do not use real banking credentials.
        bank.addAccount(new Account("USER001", "1234", 5000.00));
        bank.addAccount(new Account("USER002", "5678", 3000.00));
        new ATM(bank).start();
    }
}
