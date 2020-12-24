abstract class Account {
    private int userId;
    protected double balance;

    // initializing the constructor class
    Account() {
        this.userId = 1;
        this.balance = 0;
    }

    abstract void deposit(double amount);

    // implementing the withdraw method
    public void withdraw(double amount) {
        balance -= (amount + 5);
    }

    public int getUserId() {
        return userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setUserId(int id) {
        this.userId = id;
    }

    public void transferIn(String fromAccountNumber, double amount) {
        /*
         * getUserIdbyAccountNumber(String accountNumber)
         *  SELECT user_id 
         *  FROM accounts
         *  WHERE account_number = accountNumber;
         */
        int fromUserId = getUserIdbyAccountNumber(fromAccountNumber);
        if (this.user_id == fromUserId) {
            balance += amount;
        } else {
            balance += (amount - 50);
        }

    }
    public void transferOut(String toAccountNumber, double amount) {
        /*
         * getUserIdbyAccountNumber(String accountNumber)
         *  SELECT user_id 
         *  FROM accounts
         *  WHERE account_number = accountNumber;
         */
        int toUserId = getUserIdbyAccountNumber(toAccountNumber);
        if (this.user_id == fromUserId) {
            balance -= amount;
        } else {
            balance -= (amount + 50);
        }

    }
}

class Isuru extends Account {
    // implementation of the deposit method
    public void deposit(double amount) {
        balance += amount + amount * 0.05;
    }
}

class Nirogya extends Account {
    // implementation of the deposit method
    public void deposit(double amount) {
        balance += amount + amount * 0.1;
    }
}

public class Transaction {
    public static void main(String[] args) {
        double amount = 1000;
        int userId = 2;
        // creating a Isuru type object
        Isuru isuru = new Isuru();
        isuru.setUserId(userId);
        // calling the both deposit and withdraw methods
        isuru.deposit(amount);
        isuru.withdraw(amount);
        System.out.println(isuru.getUserId());
        System.out.println(isuru.getBalance());
    }
}