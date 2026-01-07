import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();

        boolean running = true;

        while (running) {
            System.out.println("\n=== GYM MANAGEMENT MENU ===");
            System.out.println("1. Add Member");
            System.out.println("2. Add Trainer");
            System.out.println("3. View All");
            System.out.println("4. Polymorphism Demo");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Member ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Phone: ");
                String phone = scanner.nextLine();

                System.out.print("Visits: ");
                int visits = scanner.nextInt();

                people.add(new Member(id, name, phone, visits));
                System.out.println("Member added");

            } else if (choice == 2) {
                System.out.print("Trainer ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Specialization: ");
                String spec = scanner.nextLine();

                System.out.print("Rate: ");
                double rate = scanner.nextDouble();

                people.add(new Trainer(id, name, spec, rate));
                System.out.println("Trainer added");

            } else if (choice == 3) {
                System.out.println("\n--- ALL PEOPLE ---");
                for (Person p : people) {
                    System.out.println(p);
                }

            } else if (choice == 4) {
                for (Person p : people) {
                    p.work();
                    if (p instanceof Member) {
                        Member m = (Member) p;
                        System.out.println("Active member: " + m.isActiveMember());
                    }
                    if (p instanceof Trainer) {
                        Trainer t = (Trainer) p;
                        System.out.println("Premium trainer: " + t.isPremiumTrainer());
                    }
                    System.out.println();
                }

            } else if (choice == 0) {
                running = false;
                System.out.println("alalal");

            } else {
                System.out.println("Wrong option");
            }
        }
    }
}
