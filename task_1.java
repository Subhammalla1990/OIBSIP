/*

ONLINE RESERVATION SYSTEM

write a program in JAVA to create a online reservation system which will include all the necessary
fields which are required during online reservation system. the online reservation system will be
easy to use and can be used by any person. the basic behind this project is to save data in central
database which can be accessed by any authorized person to get information and saves time and burden
which are being faced by their customers.


 */
import java.util.Scanner;

public class task_1 {
    private static String[] availableSlots = {
            "Room 101",
            "Room 102",
            "Room 103"
            // we can add more slots in this
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Online Reservation System!");
        System.out.println("Available slots:");

        for (String slot : availableSlots) {
            System.out.println(slot);
        }

        System.out.print("Enter your name: ");
        String userName = sc.nextLine();

        System.out.print("Select a slot (e.g., Room 101): ");
        String selectedSlot = sc.nextLine();

        System.out.println("Reservation successful! " + userName + " booked " + selectedSlot);

        sc.close();
    }
}
