public class BankAccount
{
    private String name;
    private int accountNumber;
    private int balance;

    public BankAccount()
    {
        this.name = "Javier";
        this.accountNumber = 101;
        this.balance = 500;
    }

    public BankAccount(String name, int accountNumber, int balance)
    {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void withdraw(int amount)
    {
        balance -= amount;
    }


    public void deposit(int amount)
    {
        balance += amount;
    }

    public String toString() {
        return String.format("Account: %s \nAccount number: %d \nBalance: $%d"
        , name, accountNumber, balance);
    }

}

