package menu;

import model.member;
import model.trainer;
import model.trainingprogram;
import exception.InvalidInputException;
import database.MemberDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GYMmenu implements Menu {
    private Scanner scanner;
    private MemberDAO memberDAO;
    private List<trainingprogram> programs;

    public GYMmenu() {
        scanner = new Scanner(System.in);
        memberDAO = new MemberDAO();
        programs = new ArrayList<>();

        // Программы пока храним в памяти (можно тоже сделать DAO позже)
        programs.add(new trainingprogram("Weight gain", 100, "Advanced"));
        programs.add(new trainingprogram("Woman's yoga", 90, "Beginner"));
    }

    @Override
    public void displayMenu() {
        System.out.println("\n=====GYM=====");
        System.out.println("1. Add member");
        System.out.println("2. Add trainer");
        System.out.println("3. View all members");
        System.out.println("4. Search member by name");
        System.out.println("5. Search member by visits");
        System.out.println("6. Update member");
        System.out.println("7. Delete member");
        System.out.println("8. View training programs");
        System.out.println("9. Start training programs");
        System.out.println("0. Exit");
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Choose option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1 -> addMember();
                    case 2 -> addTrainer();
                    case 3 -> viewAllMembers();
                    case 4 -> searchMemberByName();
                    case 5 -> searchMemberByVisits();
                    case 6 -> updateMember();
                    case 7 -> deleteMember();
                    case 8 -> viewPrograms();
                    case 9 -> startPrograms();
                    case 0 -> running = false;
                    default -> System.out.println("Invalid option");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }

        scanner.close();
    }


    private void addMember() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Visit count: ");
        int visits = scanner.nextInt();
        scanner.nextLine();
        member m = new member(id, name, visits);
        memberDAO.insert(m);

        System.out.println("Member added to database");
    }

    private void viewAllMembers() {
        List<member> members = memberDAO.getAll();
        System.out.println("\n--- ALL MEMBERS ---");
        for (member m : members) {
            System.out.println(m);
        }
    }
    private void searchMemberByName() {
        System.out.print("Enter name to search ");
        String name = scanner.nextLine();

        List<member> result = memberDAO.searchByName(name);
        System.out.println("\nSEARCH RESULTS");
        for (member m : result) {
            System.out.println(m);
        }
    }
    private void searchMemberByVisits() {
        System.out.print("Minimum visits: ");
        int visits = scanner.nextInt();
        scanner.nextLine();

        List<member> result = memberDAO.searchByVisits(visits);
        System.out.println("\nSEARCH RESULTS");
        for (member m : result) {
            System.out.println(m);
        }
    }

    private void updateMember() {
        System.out.print("Enter member ID to update ");
        int id = scanner.nextInt();
        scanner.nextLine();

        member m = memberDAO.getById(id);
        if (m == null) {
            System.out.println("Member not found");
            return;
        }

        System.out.print("New name (" + m.getName() + "): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) m.setName(name);

        System.out.print("New visits (" + m.getVisitcount() + "): ");
        String visitsStr = scanner.nextLine();
        if (!visitsStr.isEmpty()) m.setVisitcount(Integer.parseInt(visitsStr));

        memberDAO.update(m);
        System.out.println("Member updated");
    }

    private void deleteMember() {
        System.out.print("Enter member ID to delete ");
        int id = scanner.nextInt();
        scanner.nextLine();

        member m = memberDAO.getById(id);
        if (m == null) {
            System.out.println("no memmver");
            return;
        }

        memberDAO.delete(id);
        System.out.println("Member deleted");

    }


    private void addTrainer() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Specialization: ");
        String spec = scanner.nextLine();
        System.out.print("Rate: ");
        double rate = scanner.nextDouble();
        scanner.nextLine();

        trainer t = new trainer(id, name, spec, rate);
        System.out.println("Trainer added");
    }

    private void viewPrograms() {
        for (int i = 0; i < programs.size(); i++) {
            System.out.println((i + 1) + ". " + programs.get(i));
        }
    }

    private void startPrograms() throws InvalidInputException {
        viewPrograms();
        System.out.print("Choose program: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > programs.size()) {
            throw new InvalidInputException("Invalid program selection!");
        }

        trainingprogram p = programs.get(choice - 1);
        p.startTraining();
        System.out.println(p.getTrainingPlan());
    }
}
