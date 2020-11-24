
package pw2bank_shrutika_rahul_.yash;

import java.util.Scanner;

public class Pw2Bank_Shrutika_Rahul_Yash {
    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner s = new Scanner(System.in);
        String userChoice;
        final int MIN_ACCOUNT_NUMBER = 10000;
        final int MAX_ACCOUNT_NUMBER = 10099;
        final int MIN_ACCOUNT_BALANCE = 100;
        final int MAX_ACCOUNT_BALANCE = 999999;
        final int MIN_DEPOSIT_AMOUNT = 10;
        final int MIN_WITHDRAWAL_AMOUNT = 10;
        final int MIN_CHOICE_RANGE = 1;
        final int MAX_CHOICE_RANGE = 9;
        final String USER_CHOICE_EXIT = "9";
        final String REGEX_FOR_NUMBERS = "[0-9]+";

        do {
            //display menu to user
            //ask user for his choice and validate it (make sure it is between 1 and 9)
            System.out.println();
            System.out.println("1) Open a new bank account");
            System.out.println("2) Close a bank account");
            System.out.println("3) Display Information of a client");
            System.out.println("4) Deposit to a bank account");
            System.out.println("5) Withdraw to bank account");
            System.out.println("6) Display List of Clients");
            System.out.println("7) Print average balance of accounts");
            System.out.println("8) Print total balance of accounts");
            System.out.println("9) Exit");
            System.out.println();
            System.out.print("Enter choice [1-9]: ");
            userChoice = s.next();
            if (!bank.isInRange(userChoice, MIN_CHOICE_RANGE, MAX_CHOICE_RANGE)) {
                System.out.println("Enter valid choice");
            } else {
                switch (userChoice) {
                    case "1":
                        System.out.println("Enter a customers First name");
                        String fname = s.next().toLowerCase();
                        if (!bank.ValidateName(fname)) {
                            System.out.println("First name is not valid");
                            break;
                        }
                        System.out.println("Enter a customers Last name");
                        String lname = s.next().toLowerCase();
                        if (!bank.ValidateName(lname)) {
                            System.out.println("Last name is not valid");
                            break;
                        }
                        System.out.println("Enter  opening balance");
                        String balance = s.next();
                        if (!balance.matches(REGEX_FOR_NUMBERS) || Integer.parseInt(balance) < MIN_ACCOUNT_BALANCE || Integer.parseInt(balance) > MAX_ACCOUNT_BALANCE) {
                            System.out.println("Balance is not valid");
                            break;
                        }
                        bank.createAccount(fname, lname, Integer.parseInt(balance));
                        break;

                    case "2":
                        System.out.println("Enter an account number");
                        String accnumber = s.next();
                        if (!accnumber.matches(REGEX_FOR_NUMBERS) || Integer.parseInt(accnumber) < MIN_ACCOUNT_NUMBER || Integer.parseInt(accnumber) < MAX_ACCOUNT_NUMBER) {
                            System.out.println("Account Number is not valid");
                            break;
                        }
                        bank.RemoveAccount(Integer.parseInt(accnumber));
                        break;
                    case "3":
                        System.out.println("Enter an account number");
                        accnumber = s.next();
                        if (!accnumber.matches(REGEX_FOR_NUMBERS) || Integer.parseInt(accnumber) < MIN_ACCOUNT_NUMBER || Integer.parseInt(accnumber) > MAX_ACCOUNT_NUMBER) {
                            System.out.println("Account Number is not valid");
                            break;
                        }
                        bank.DisplayInformation(Integer.parseInt(accnumber));
                        break;
                    case "4":
                        System.out.println("Enter an account number");
                        accnumber = s.next();
                        if (!accnumber.matches(REGEX_FOR_NUMBERS) || Integer.parseInt(accnumber) < MIN_ACCOUNT_NUMBER || Integer.parseInt(accnumber) > MAX_ACCOUNT_NUMBER) {
                            System.out.println("Account Number is not valid");
                            break;
                        }
                        System.out.println("Enter the amount");
                        String amount = s.next();
                        if (!amount.matches(REGEX_FOR_NUMBERS) || Integer.parseInt(amount) < MIN_DEPOSIT_AMOUNT || Integer.parseInt(amount) > MAX_ACCOUNT_BALANCE) {
                            System.out.println("Amount is not valid. Minimum deposit : " + MIN_DEPOSIT_AMOUNT + " Maximum deposit : " + MAX_ACCOUNT_BALANCE);
                            break;
                        }
                        bank.DepositAmount(Integer.parseInt(accnumber), Integer.parseInt(amount));
                        break;
                    case "5":
                        System.out.println("Enter an account number");
                        accnumber = s.next();
                        if (!accnumber.matches(REGEX_FOR_NUMBERS) || Integer.parseInt(accnumber) < MIN_ACCOUNT_NUMBER || Integer.parseInt(accnumber) > MAX_ACCOUNT_NUMBER) {
                            System.out.println("Account Number is not valid");
                            break;
                        }
                        System.out.println("Enter the amount");
                        amount = s.next();
                        if (!amount.matches(REGEX_FOR_NUMBERS) || Integer.parseInt(amount) < MIN_WITHDRAWAL_AMOUNT || Integer.parseInt(amount) > MAX_ACCOUNT_BALANCE) {
                            System.out.println("Amount is not valid. Minimum withdrawal : " + MIN_WITHDRAWAL_AMOUNT + " Maximum withdrawal : " + MAX_ACCOUNT_BALANCE);
                            break;
                        }
                        bank.WithdrawAmount(Integer.parseInt(accnumber), Integer.parseInt(amount));
                        break;
                    case "6":
                        System.out.println("Sort By ? write ASC / DSC only");
                        String choicer = s.next().toUpperCase();
                        if (choicer.equals("ASC") || choicer.equals("DSC")) {
                            bank.displayAllAccounts(choicer);
                            break;
                        } else {
                            System.out.println("Wrong Choice Try again");
                            break;
                        }

                    case "7":
                        bank.DisplayAveragBalance();
                        break;
                    case "8":
                        bank.DisplayTotalBalance();
                        break;
                    case "9":
                        System.exit(0);
                    default:
                        System.out.println("Try Again , Press 9 to exit!");
                }
            }

        } while (!userChoice.equals(USER_CHOICE_EXIT));
    }
    
}
