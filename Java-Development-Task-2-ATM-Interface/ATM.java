import java.util.Scanner;

public class ATM {
    private static final int MAX_LOGIN_ATTEMPTS = 3;
    private final Bank bank;
    private final Scanner scanner = new Scanner(System.in);

    public ATM(Bank bank) { this.bank = bank; }

    public void start() {
        System.out.println("=================================");
        System.out.println("          JAVA ATM");
        System.out.println("=================================");
        Account account = authenticate();
        if (account == null) {
            System.out.println("Access denied. Too many incorrect attempts.");
            scanner.close();
            return;
        }

        System.out.println("\nLogin successful. Welcome, " + account.getUserId() + "!");
        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Choose an option (1-5): ");
            switch (choice) {
                case 1: showHistory(account); break;
                case 2: withdraw(account); break;
                case 3: deposit(account); break;
                case 4: transfer(account); break;
                case 5:
                    System.out.println("Thank you for using Java ATM. Goodbye!");
                    running = false;
                    break;
                default: System.out.println("Invalid choice. Please select 1 to 5.");
            }
        }
        scanner.close();
    }

    private Account authenticate() {
        for (int attempt = 1; attempt <= MAX_LOGIN_ATTEMPTS; attempt++) {
            System.out.print("Enter User ID: ");
            String userId = scanner.nextLine().trim();
            System.out.print("Enter PIN: ");
            String pin = scanner.nextLine().trim();
            Account account = bank.getAccount(userId);
            if (account != null && account.verifyPin(pin)) return account;
            int remaining = MAX_LOGIN_ATTEMPTS - attempt;
            if (remaining > 0) {
                System.out.println("Incorrect User ID or PIN. Attempts remaining: " + remaining);
            }
        }
        return null;
    }

    private void printMenu() {
        System.out.println("\n----------- MAIN MENU -----------");
        System.out.println("1. Transaction History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");
        System.out.println("---------------------------------");
    }

    private void showHistory(Account account) {
        System.out.println("\n------ TRANSACTION HISTORY ------");
        if (account.getTransactions().isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (Transaction transaction : account.getTransactions()) System.out.println(transaction);
        }
        System.out.printf("Current balance: ₹%.2f%n", account.getBalance());
    }

    private void withdraw(Account account) {
        double amount = readAmount("Enter amount to withdraw: ₹");
        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
        } else if (amount > account.getBalance()) {
            System.out.println("Insufficient Funds.");
        } else if (account.withdraw(amount, "Cash withdrawal")) {
            System.out.printf("Withdrawal successful. New balance: ₹%.2f%n", account.getBalance());
        }
    }

    private void deposit(Account account) {
        double amount = readAmount("Enter amount to deposit: ₹");
        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
            return;
        }
        account.deposit(amount, "Cash deposit");
        System.out.printf("Deposit successful. New balance: ₹%.2f%n", account.getBalance());
    }

    private void transfer(Account account) {
        System.out.print("Enter recipient account ID: ");
        String recipientId = scanner.nextLine().trim();
        double amount = readAmount("Enter amount to transfer: ₹");
        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
            return;
        }
        Account recipient = bank.getAccount(recipientId);
        if (recipient == null) {
            System.out.println("Recipient account not found.");
            return;
        }
        if (recipient == account) {
            System.out.println("You cannot transfer money to your own account.");
            return;
        }
        if (amount > account.getBalance()) {
            System.out.println("Insufficient Funds.");
            return;
        }
        if (bank.transfer(account, recipientId, amount)) {
            System.out.printf("Transfer successful to %s. New balance: ₹%.2f%n",
                    recipientId, account.getBalance());
        } else {
            System.out.println("Transfer failed. Please check the details and try again.");
        }
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    private double readAmount(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid amount, e.g. 500 or 250.50.");
            }
        }
    }
}
