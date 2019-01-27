package edu.ithaca.dragon.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email)){
            this.email = email;
            this.balance = startingBalance;
        }
        else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
    }

    public double getBalance(){
        return balance;
    }

    public String getEmail(){
        return email;
    }

    /**
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     */
    public void withdraw (double amount)  {
        if(amount>0 && amount<balance){
            balance -= amount;
        }
    }

    public static boolean isAmountValid(double amount){
        /**
         * Takes a double to determine if amount is valid
         *  Returns true if amount has 2 decimal places, returns false if doesnt
         *  0.00, the '.' is at 3rd position from back of string
         */
        String amtStr= Double.toString(amount);
        if(amtStr.indexOf('.')!=amtStr.length()-3){
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean isEmailValid(String email){
        if (email.indexOf('@') == -1 || email.indexOf('.')== -1 || (email.indexOf('@') > email.indexOf('.'))){
            return false;
        }
        else {
            return true;
        }
    }
}
