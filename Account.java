/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw2bank_shrutika_rahul_.yash;

/**
 *
 * @author shrut
 */
public class Account {
    public int AccountNo;
    public String FirstName;
    public String LastName;
    public int Balance;

    public Account(String fname, String lname, int balance, int accNum) {
        this.FirstName = fname;
        this.LastName = lname;
        this.Balance = balance;
        this.AccountNo = accNum;
    }
}
