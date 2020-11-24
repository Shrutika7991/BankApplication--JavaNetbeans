/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw2bank_shrutika_rahul_.yash;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.*;
/**
 *
 * @author shrut
 */
public class Bank {
    ArrayList<Account> Accounts;
    final int maxAccounts;
    final String REGEX_FOR_NUMBERS = "[0-9]+";
    static String REGEX_FOR_STRING = "[a-z]*";
    private int currAccNo;
//  HashMap<String, Account> Accounts ;

    public Bank() {
        this.maxAccounts = 100;
        this.currAccNo = 10000;
//      Accounts = new HashMap<String, Account>(); 
        Accounts = new ArrayList<Account>(100);
    }

    public static boolean ValidateName(String firstName) {
        return firstName.matches(REGEX_FOR_STRING);
    }

    public boolean isInRange(String value, int min, int max) {
        if (!value.matches(REGEX_FOR_NUMBERS)) {
            return false;
        }
        if (Integer.parseInt(value) > max || Integer.parseInt(value) < min) {
            return false;
        }
        return true;
    }

    public void createAccount(String fisrtName, String lastName, int Balance) {
        boolean dupliAcc = false;
        int dupliAccNO = 0;
        for (int i = 0; i < Accounts.size(); i++) {
            Account account = Accounts.get(i);
            if (account.FirstName.equals(fisrtName) && account.LastName.equals(lastName)) {
                dupliAcc = true;
                dupliAccNO = account.AccountNo;
                break;
            }
        }

        if (dupliAcc != true) {
            Account account = new Account(fisrtName, lastName, Balance, currAccNo);
            System.out.println("---------------------------------------------------------------------------");            
            System.out.println("Account Created and Account Number is : " + currAccNo);
            Accounts.add(account);
            currAccNo++;
        } else {
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("Account Already Exist in system and Account Number is : " + dupliAccNO);
        }

    }

    // public int AccountNo;
    // public String FirstName;
    // public String LastName;
    // public int Balance;
    // public String Type;
    public void displayAllAccounts(String choice) {
        ArrayList<Account> DuplAccounts = Accounts;
        Collections.sort(DuplAccounts, new Comparator<Account>() {
            public int compare(Account s1, Account s2) {
                if (choice.equals("ASC")) {
                    return s1.FirstName.compareToIgnoreCase(s2.FirstName);
                } else {
                    return s2.FirstName.compareToIgnoreCase(s1.FirstName);
                }
            }
        });
        for (int i = 0; i < DuplAccounts.size(); i++) {
            Account account = DuplAccounts.get(i);
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("| Account Number : " + account.AccountNo + " | First Name : " + account.FirstName + " | Last Name : " + account.LastName + " | Balance : " + account.Balance + " |");
        }
    }

    public void DisplayInformation(int account) {
        boolean accExist = false;
        for (int i = 0; i < Accounts.size(); i++) {
            Account acc = Accounts.get(i);
            if (acc.AccountNo == account) {
                accExist = true;
                System.out.println("---------------------------------------------------------------------------");
                System.out.println(" | Account Number : " + acc.AccountNo + " | First Name : " + acc.FirstName + " | Last Name : " + acc.LastName + " | Balance : " + acc.Balance + " |");
                break;
            }
        }
        if (accExist == false) {
            System.out.println("---------------------------------------------------------------------------");            
            System.out.println("Sorry Account Does Not Exist");
        }
    }

    public void RemoveAccount(int account) {
        boolean accExist = false;
        System.out.println("---------------------------------------------------------------------------");
        for (int i = 0; i < Accounts.size(); i++) {
            Account acc = Accounts.get(i);
            if (acc.AccountNo == account) {
                accExist = true;
                Accounts.remove(i);
                System.out.println("Account Removed !!");
                break;
            }
        }
        if (accExist == false) {
            System.out.println("Sorry Account Does Not Exist");
        }
    }

    public void WithdrawAmount(int account, int amount) {
        boolean accExist = false;
        System.out.println("---------------------------------------------------------------------------");
        for (int i = 0; i < Accounts.size(); i++) {
            Account acc = Accounts.get(i);
            if (acc.AccountNo == account) {
                accExist = true;
                if (Accounts.get(i).Balance >= amount) {
                    Accounts.get(i).Balance -= amount;
                    System.out.println("Amount withdraw Done , current Balance is : " + Accounts.get(i).Balance);
                } else {
                    System.out.println("Insufficient Amounts , current Balance is : " + Accounts.get(i).Balance);
                }
                break;
            }
        }
        if (accExist == false) {
            System.out.println("Sorry Account Does Not Exist");
        }
    }

    public void DepositAmount(int account, int amount) {
        boolean accExist = false;
        System.out.println("---------------------------------------------------------------------------");
        for (int i = 0; i < Accounts.size(); i++) {
            Account acc = Accounts.get(i);
            if (acc.AccountNo == account) {
                accExist = true;
                Accounts.get(i).Balance += amount;
                System.out.println("Amount Deposit Done , current Balance is : " + Accounts.get(i).Balance);
                break;
            }
        }
        if (accExist == false) {
            System.out.println("Sorry Account Does Not Exist");
        }
    }

    public void DisplayAveragBalance() {
        int totalBal = 0;
        for (int i = 0; i < Accounts.size(); i++) {
            totalBal += Accounts.get(i).Balance;
        }
        System.out.println("---------------------------------------------------------------------------");        
        System.out.println("Average Balance is : " + totalBal / Accounts.size());
    }

    public void DisplayTotalBalance() {
        int totalBal = 0;
        for (int i = 0; i < Accounts.size(); i++) {
            totalBal += Accounts.get(i).Balance;
        }
        System.out.println("---------------------------------------------------------------------------");        
        System.out.println("Total Balance is : " + totalBal);
    }
}
