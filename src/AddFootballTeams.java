import java.util.ArrayList;
import java.util.Scanner;

public class AddFootballTeams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> team = new ArrayList<>();
        int choice = 0;

        while (choice != 4) {
            System.out.println("Choose an operation: ");
            System.out.println("1. Add football teams");
            System.out.println("2. Remove football teams");
            System.out.println("3. Display football teams");
            System.out.println("4. Exit");

            choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Enter the name of the football team");
                scanner.nextLine(); // Consume the newline character left by scanner.nextInt()
                String teamAdd = scanner.nextLine();
                team.add(teamAdd);
            } else if (choice == 2) {
                System.out.println("Enter the index of the football team you want to remove");
                int index = scanner.nextInt();
                if (index >= 0 && index < team.size()) {
                    team.remove(index);
                    System.out.println("Team removed");
                } else {
                    System.out.println("Invalid input");
                }
            } else if (choice == 3) {
                System.out.println("Teams in display: ");
                for (String num : team) {
                    System.out.println(num);
                }
            } else if (choice == 4) {
                System.out.println("Exiting.......");
            } else {
                System.out.println("Wrong input. Try again");
            }
            System.out.println();
        }
        scanner.close();
    }
}
