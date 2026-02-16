package Bank.app;

import java.util.Scanner;

public class BankApp {

    public static void main(String[] args) {

        Service service = new Service();
        Scanner sc = new Scanner(System.in);

        while (true) {

            try {

                System.out.println("\n===== BANK MENU =====");
                System.out.println("1. Create Account");
                System.out.println("2. Delete Account");
                System.out.println("3. Deposit");
                System.out.println("4. Withdraw");
                System.out.println("5. Show Balance");
                System.out.println("6. Show Account Details");
                System.out.println("7. Exit");
                System.out.print("Choose option: ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Acc No: ");
                        int accNo = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Address: ");
                        String address = sc.nextLine();

                        System.out.print("Account Type: ");
                        String type = sc.nextLine();

                        System.out.print("Initial Balance: ");
                        double bal = sc.nextDouble();

                        System.out.print("Minimum Balance: ");
                        double minBal = sc.nextDouble();

                        service.createAccount(
                                new Account(accNo, name, address, type, bal, minBal)
                        );
                        break;

                    case 2:
                        System.out.print("Acc No: ");
                        service.deleteAccount(sc.nextInt());
                        break;

                    case 3:
                        System.out.print("Acc No: ");
                        int dAcc = sc.nextInt();
                        System.out.print("Amount: ");
                        service.deposit(dAcc, sc.nextDouble());
                        break;

                    case 4:
                        System.out.print("Acc No: ");
                        int wAcc = sc.nextInt();
                        System.out.print("Amount: ");
                        service.withdraw(wAcc, sc.nextDouble());
                        break;

                    case 5:
                        System.out.print("Acc No: ");
                        service.showBalance(sc.nextInt());
                        break;

                    case 6:
                        System.out.print("Acc No: ");
                        service.showAccount(sc.nextInt());
                        break;

                    case 7:
                        System.out.println("Exiting...");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice");
                }

            } catch (BankException e) {
                System.out.println("" + e.getMessage());

            } catch (Exception e) {
                System.out.println("Technical error: " + e.getMessage());
            }
        }
    }
}
