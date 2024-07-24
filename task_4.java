/*

ONLINE EXAMINATION

write a JAVA program to create a Online Examination which should be capable of the following functions.
    1. login
    2. Update Profile and Password
    3. Selecting Answers and MCQs
    4. Timer and Auto Submit
    5. Closing session and Logout

 */

import java.util.Scanner;

public class task_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean loggedIn = false;
        String username = "";

        while (true) {
            System.out.println("Welcome to the Online Exam System!");
            System.out.println("1. Login");
            System.out.println("2. Update Profile and Password");
            System.out.println("3. Start Exam");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    if (loggedIn) {
                    } else {
                        System.out.println("Please log in first.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the Online Exam System!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
