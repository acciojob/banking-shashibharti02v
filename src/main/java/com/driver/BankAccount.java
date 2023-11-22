package com.driver;

import java.util.Random;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
          this.name = name;
          this.balance = balance;
          this.minBalance = minBalance;
    }

    public double getBalance() {
        return balance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if(digits == 0)
            throw new RuntimeException("Account Number can not be generated");
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int pass[] = new int[digits];
        for(int i=0; i<pass.length; i++){
            int maxPossibel = Math.min(9, sum);
            int generateDigit = random.nextInt(maxPossibel+1);
            if(i == digits-1 && generateDigit != sum)
                throw new RuntimeException("Account Number can not be generated");
            pass[i] = generateDigit;
            sum -= generateDigit;
        }
        for(int digit: pass)
            sb.append(digit);
        return sb.toString();
    }

    public void deposit(double amount) {
        //add amount to balance
        balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if((balance - amount) < minBalance)
            throw new RuntimeException("Insufficent Balance");
        else{
            balance -= amount;
        }
    }

}