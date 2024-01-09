import java.util.Scanner;

class BankAccount {
    public String Transcation = "Transcation History \n1";
    private double balance;
    int s = 0;
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit (double amount) {
        if (amount > 0) {
            balance += amount;
            s++;
            Transcation += ("" + s + ": deposit=" + amount + " Total balance:" + balance+ "\n");
            System.out.println("Money Deposited: " + amount);
        } else {
            System.out.println("Invalid amount for deposit!");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            s++;
            Transcation += ("" + s + ": Withdraw=" + amount + "total balance:" + balance+ "\n");
            System.out.println("Money Withdraw: " + amount);
        } else {
            System.out.println("Invalid amount for Withdraw!");
        }
    }
    public void transfer(double ac_no, double amount)
    {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            s++;
            Transcation += ("" + s + ": Transfer=" + amount + "total balance:" + balance + "Transfer account number=" + ac_no + "\n");
            System.out.println("Money Transfered!: " + amount);
        } else {
            System.out.println("Invalid amount for transfered");
        }
    }
}
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    public void ShowMenu() {

        System.out.println("***************** WELCOME TO ATM ******************");
        System.out.println("ATM Menu: ");
        System.out.println(" 1.  Check balance");
        System.out.println(" 2.  Deposit Cash");
        System.out.println(" 3.  Withdraw Cash");
        System.out.println(" 4.  Show Trancation ");
        System.out.println(" 5.  Transfer Amount");
        System.out.println(" 6.  exit");
    }

    public void start() {
        System.out.println("Enter the pin");
        int pin = scanner.nextInt();
        if (pin == 9021) {
            int choice;
            do {
                ShowMenu();
                System.out.print("Enter the choice: ");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        withdraw();
                        break;
                    case 4:
                        System.out.printf(account.Transcation);
                        break;
                    case 5:
                        transfer();
                        break;
                    case 6:
                        System.out.println("Exiting ATM. Thank You!!!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option!");
                }
            } while (choice != 6);
        } else {
            System.out.println("Invalid pin \nPress 1.  Try again \nPress 0.  Exit");
            int choose = scanner.nextInt();
            if (choose == 1) {
                start();
            }
        }
    }
    private void checkBalance(){
        System.out.println("current balance: "+ account.getBalance());
    }
    private void deposit(){
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        }
        private void withdraw(){
            System.out.print("Enter withdrawl amount: ");
            double amount= scanner.nextDouble();
            account.withdraw(amount);
    }
    private void transfer(){
        System.out.println("Enter the Account Number");
        double ac_no=scanner.nextDouble();
        System.out.print("Enter Transfer amount: ");
        double amount = scanner.nextDouble();
                account . transfer(ac_no,amount);
        }
    }






