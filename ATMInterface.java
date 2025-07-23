import java.util.Scanner;

// Represents the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ ₹" + amount + " deposited successfully.");
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("❌ Insufficient balance.");
        } else if (amount <= 0) {
            System.out.println("❌ Invalid withdrawal amount.");
        } else {
            balance -= amount;
            System.out.println("✅ ₹" + amount + " withdrawn successfully.");
        }
    }
}

// Represents the ATM machine
class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== ATM Menu ====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("💰 Current Balance: ₹%.2f\n", account.getBalance());
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("👋 Thank you for using the ATM. Goodbye!");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}

// Main class to run the program
public class ATMInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String userName = sc.nextLine();

        System.out.print("Enter initial account balance: ₹");
        double initialBalance = sc.nextDouble();

        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount);

        System.out.println("\nWelcome, " + userName + "! 👋");
        atm.showMenu();

        sc.close();
    }
}
