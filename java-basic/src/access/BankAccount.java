package access;

public class BankAccount {
    private int balance;

    public BankAccount() {
        balance = 0;
    }

    // public 메서드: deposit
    public void deposit(int amount){
        if(isAmountValid(amount)){
            balance += amount;
        }else{
            System.out.println("유효하지 않은 금액");
        }
    }

    public void withdraw(int amount){
        if(isAmountValid(amount) && balance - amount >= 0){
            balance -= amount;
        }else{
            System.out.println("우효하지 않은 금액");
        }
    }

    public int getBalance(){
        return balance;
    }

    private boolean isAmountValid(int amount){
        // private
        // 금액이 0보다 커야함
        return amount>0;
    }
}
