# ATM Interface — Java Console Project

A console-based ATM simulation built with Core Java and Object-Oriented Programming for OASIS INFOBYTE Java Development Internship Task 3.

## Features
- User ID and PIN login; access denied after 3 incorrect attempts.
- Menu: Transaction History, Withdraw, Deposit, Transfer, Quit.
- Balance validation and `Insufficient Funds` message.
- Transaction history stored in an `ArrayList`.
- Transfers update both sender and recipient accounts.
- Input validation for menu choices and amounts.
- Five distinct classes: `Main`, `ATM`, `Account`, `Transaction`, and `Bank`.

## Demo credentials (local testing only)

| User ID | PIN | Opening balance |
|---|---:|---:|
| `USER001` | `1234` | ₹5,000.00 |
| `USER002` | `5678` | ₹3,000.00 |

This is an educational simulation, not a real banking application. Do not use real banking credentials.

## Requirements
- JDK 8 or newer
- Terminal / Command Prompt

## Compile and run
From this folder, run:

```bash
javac Main.java ATM.java Account.java Transaction.java Bank.java
java Main
```

## Project structure

```text
Java-Development-Task-3-ATM-Interface/
├── Main.java
├── ATM.java
├── Account.java
├── Transaction.java
├── Bank.java
└── README.md
```

## OOP concepts demonstrated
- Encapsulation with private fields and methods.
- Separate responsibilities across classes.
- `ArrayList<Transaction>` for transaction history.
- `switch-case`, loops, conditionals, and input validation.

## Test checklist
- [ ] Log in with `USER001` / `1234`.
- [ ] Enter incorrect credentials three times; verify access is denied.
- [ ] View transaction history.
- [ ] Deposit a positive amount and verify the balance.
- [ ] Withdraw within the available balance.
- [ ] Withdraw more than the balance and verify `Insufficient Funds`.
- [ ] Transfer to `USER002`; log in to `USER002` and verify the transfer.
- [ ] Try an unknown recipient and a transfer to the same account.
- [ ] Quit and verify the goodbye message.

## Suggested GitHub layout

```text
OIBSIP/
└── Java-Development-Task-3-ATM-Interface/
    ├── Main.java
    ├── ATM.java
    ├── Account.java
    ├── Transaction.java
    ├── Bank.java
    └── README.md
```

## Submission checklist
- [ ] Compile and test the project.
- [ ] Capture screenshots of login, transactions, history, and insufficient funds.
- [ ] Record a demo video with the title card required by the internship.
- [ ] Upload the folder to your public `OIBSIP` GitHub repository.
- [ ] Follow the official internship instructions for LinkedIn posting and submission.
