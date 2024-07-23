/*

ATM INTERFACE

write a program in JAVA to create a JAVA Interface which will consist of five different classes
and is a console based application. When system starts, the user is prompted with the user id and user pin.
On entering the details successfully, then ATM functions are unlocked.
The project allows to perform following operations
    1. Transaction history
    2. Withdraw
    3. Deposit
    4. Transfer
    5. Quit

 */


import java.util.Scanner;

class BankAccount{
    String name;
    String userName;
    String password;
    String accountNo;
    float balance = 100000f;
    int transaction = 0;
    String transactionHistory = "";

    public void register(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter your name: ");
        this.name = sc.nextLine();

        System.out.println("\nEnter your username: ");
        this.userName = sc.nextLine();

        System.out.println("\nEnter your password: ");
        this.password = sc.nextLine();

        System.out.println("\nEnter your Account no.: ");
        this.accountNo = sc.nextLine();

        System.out.println("\nRegistration completed... Kindly login");
    }

    public boolean login(){
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        while (!isLogin){
            System.out.println("\nEnter your Username: ");
            String Username = sc.nextLine();

            if (Username.equals(userName)){
                while (!isLogin){
                    System.out.println("\nEnter your password: ");
                    String Password = sc.nextLine();
                    if (Password.equals(password)){
                        System.out.println("\nLogin Successful");
                        isLogin = true;
                    }else {
                        System.out.println("Incorrect password");
                    }
                }
            }else {
                System.out.println("\nUsername not found.");
            }
        }
        return isLogin;
    }
    public void withdraw(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter amount to withdraw: ");
        float amount = sc.nextFloat();
        try{
            if (balance >= amount){
                transaction++;
                balance -= amount;
                System.out.println("\nWithdraw successfully");
                String str = amount + "Rs Withdrawed\n";
                transactionHistory = transactionHistory.concat(str);

            }else {
                System.out.println("\nInsufficient balance");
            }
        }
        catch (Exception e){
        }
    }

    public void deposit(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter amount to deposit: ");
        float amount = sc.nextFloat();

        try {
            if (amount <= 100000f){
                transaction++;
                balance += amount;
                System.out.println("\nSuccessfully deposited");
                String str = amount + "Rs deposited\n";
                transactionHistory = transactionHistory.concat(str);
            }else {
                System.out.println("\nSorry...Limit is 100000.00");
            }
        }
        catch (Exception e){
        }
    }
    public void transfer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Receipent's name: ");
        String receipent = sc.nextLine();
        System.out.println("\nEnter amount to transfer: ");
        float amount = sc.nextFloat();

        try {
            if (balance >= amount){
                if (amount <= 50000f){
                    transaction++;
                    balance -= amount;
                    System.out.println("\nSuccessfully Transfered to " + receipent);
                    String str = amount + "Rs transfered to " + receipent + "\n";
                    transactionHistory = transactionHistory.concat(str);
                }else {
                    System.out.println("\nSorry...Limit is 50000.");
                }
            }
            else {
                System.out.println("\nInsufficient balance");
            }
        }
        catch (Exception e){
        }
    }

    public void checkBalance(){
        System.out.println("\n" + balance + " Rs ");
    }

    public void transHistory(){
        if (transaction == 0){
            System.out.println("\nEmpty");
        }else {
            System.out.println("\n" + transactionHistory);
        }
    }
}



public class task_3 {
    public static int takeIntegerInput(int limit){
        int input = 0;
        boolean flag = false;

        while (!flag){
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;

                if (flag && input > limit || input < 1){
                    System.out.println("Choose the number between 1 to " + limit);
                    flag = false;
                }
            }
            catch (Exception e){
                System.out.println("Enter only integer value");
                flag = false;
            }
        }
        return input;
    }

    public static void main(String[]args){
        System.out.println("\n********************WELCOME TO OUR ATM********************");
        System.out.println("1. Register \n2. Exit");
        System.out.println("Enter your choice: ");
        int choice = takeIntegerInput(2);

        if (choice == 1){
            BankAccount b = new BankAccount();
            b.register();
            while(true){
                System.out.println("\n1. Login \n2. Exit");
                System.out.println("Enter your choice: ");
                int ch = takeIntegerInput(2);
                if (ch == 1){
                    if (b.login()){
                        System.out.println("\n\n********************WELCOME BACK " + b.name + "********************\n");
                        boolean isFinished = false;
                        while(!isFinished){
                            System.out.println("\n1. Withdraw \n2. Deposit \n3. Transfer \n4. Check Balance \nTransaction History");
                            System.out.println("\nEnter your choice: ");
                            int c = takeIntegerInput(2);
                            switch (c){
                                case 1:
                                    b.withdraw();
                                    break;
                                case 2:
                                    b.deposit();
                                    break;
                                case 3:
                                    b.transfer();
                                    break;
                                case 4:
                                    b.checkBalance();
                                    break;
                                case 5:
                                    b.transHistory();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;
                            }
                        }
                    }
                }
                else {
                    System.exit(0);
                }
            }
        }
        else {
            System.exit(0);
        }
    }
}
