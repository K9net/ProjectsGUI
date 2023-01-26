package NetworkAndThreads.BankOperations;

public class BankAccount {
    private int balance = 1000;

    public int getBalance(){
        return balance;
    }

    public void withdraw(int amount){
        balance = balance - amount;
    }
}
