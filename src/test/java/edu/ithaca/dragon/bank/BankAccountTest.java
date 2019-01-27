package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance());
        assertNotEquals(0,bankAccount.getBalance());
        assertNotEquals(-10,bankAccount.getBalance());
        assertNotEquals(400,bankAccount.getBalance());
    }

    @Test
    void withdrawTest() {
        /**
         * Tests should determine whether or not the account has enough money for the transaction
         * Test for negative, test for OOB, test for normal case
         */
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        bankAccount.withdraw(100);
        assertEquals(100, bankAccount.getBalance());
        bankAccount.withdraw(-100);
        assertEquals(100,bankAccount.getBalance());
        bankAccount.withdraw(300);
        assertEquals(100,bankAccount.getBalance());
    }

    @Test
    void isEmailValidTest(){
        /**
         * Valid email address has at least an @, a '.' and text. @ before '.', and neither can be last in email.
         */
        assertTrue(BankAccount.isEmailValid( "a@b.com"));
        assertFalse( BankAccount.isEmailValid(""));
        assertFalse(BankAccount.isEmailValid("abc@com"));
        assertFalse(BankAccount.isEmailValid("abc.com@"));
        assertFalse(BankAccount.isEmailValid("abc.com"));
    }

    @Test
    void isAmountValidTest(){

        assertTrue(BankAccount.isAmountValid(200.01));
        assertFalse(BankAccount.isAmountValid(200.001));
        assertFalse(BankAccount.isAmountValid(200));
        assertFalse(BankAccount.isAmountValid(200.1));
        assertFalse(BankAccount.isAmountValid(200.000000001));


    }
    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance());
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
    }

}