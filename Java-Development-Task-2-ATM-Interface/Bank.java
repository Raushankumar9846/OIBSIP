import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<String, Account> accounts = new HashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getUserId(), account);
    }

    public Account getAccount(String userId) {
        return accounts.get(userId);
    }

    public boolean transfer(Account sender, String recipientId, double amount) {
        Account recipient = accounts.get(recipientId);
        if (sender == null || recipient == null || sender == recipient
                || amount <= 0 || amount > sender.getBalance()) {
            return false;
        }
        // Apply both account updates only after all checks pass.
        sender.recordTransferOut(amount, recipientId);
        recipient.recordTransferIn(amount, sender.getUserId());
        return true;
    }
}
