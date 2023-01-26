package NetworkAndThreads.BankOperations;

public class FamilyValeraAndCat implements Runnable{

    private BankAccount bankAccount = new BankAccount();

    public static void main(String[] args) {
        FamilyValeraAndCat family = new FamilyValeraAndCat();
        Thread valera = new Thread(family);
        Thread cat = new Thread(family);
        valera.setName("Валера");
        cat.setName("Кот");
        valera.start();
        cat.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            makeWithdraw(120);
            if(bankAccount.getBalance() < 0){
                System.out.println("Не хватает средств!");
            }
        }
        System.out.println(bankAccount.getBalance());
    }

    private void makeWithdraw(int amount){
        if(bankAccount.getBalance() >= amount){
            System.out.println(Thread.currentThread().getName() + " пытается снять деньги");
            try {
                System.out.println(Thread.currentThread().getName() + " заснул");
            } catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " просыпается");
            bankAccount.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " заканчивает транзакцию. Баланс: " + bankAccount.getBalance());
        }
         else{
            System.out.println("Для клиента " + Thread.currentThread().getName() + " не хватет средств на счете");
        }
    }
}
