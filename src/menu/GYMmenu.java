package menu;
import model.*;
import exception.InvalidInputException;
import java.util.ArrayList;
import java.util.Scanner;
public class GYMmenu implements Menu {
    private ArrayList<person> people;
    private ArrayList<trainingprogram> programs;
    private Scanner scanner;
    public GYMmenu(){
        people=new ArrayList<>();
        programs=new ArrayList<>();
        scanner=new Scanner(System.in);
        people.add(new member(1001, "Aruzhan", 30));
        people.add(new member(110, "Alikhan", 12));
        programs.add(new trainingprogram("Weight gain", 100, "Advanced"));
        programs.add(new trainingprogram("Woman's yoga", 90, "Beginner"));

    }
@Override
    public void displayMenu(){
        System.out.println("\n=====GYM=====");
        System.out.println("1.Add member");
        System.out.println("2.Add trainer");
        System.out.println("3.View all people");
        System.out.println("4.Polymorphism demo");
        System.out.println("5.View training programsd");
        System.out.println("6.Start training programs");
        System.out.println("0.Leave");
}
@Override
    public void run(){
        boolean running=true;
        while(running){
            displayMenu();
            System.out.print("Choose option");
            try{
                int choice=scanner.nextInt();
                scanner.nextLine();
                switch(choice){
                    case 1-> addMember();
                    case 2-> addTrainer();
                    case 3-> viewAll();
                    case 4-> demonstratePolymorphism();
                    case 5-> viewPrograms();
                    case 6-> startPrograms();
                    case 0-> running=false;
                    default-> System.out.println("choose smth");
                }
            } catch(Exception e){
                System.out.println("Error: "+e.getMessage());
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private void addTrainer() {
        System.out.print("ID: ");
        int id = scanner.nextInt(); scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Specialization: ");
        String spec = scanner.nextLine();
        System.out.print("Rate: ");
        double rate = scanner.nextDouble();

        people.add(new trainer(id, name, spec, rate));
        System.out.println("Trainer added");
    }

    private void addMember(){
        System.out.println("ID:");
        int ID=scanner.nextInt();
        scanner.nextLine();
        System.out.println("name:");
        String name=scanner.nextLine();
        System.out.print("Visits: ");
        int visits = scanner.nextInt();
        people.add(new member(ID, name, visits));
        System.out.println("Member added");

    }
    private void viewAll(){
        for(person p:people){
            System.out.println(p);
        }
    }
    private void demonstratePolymorphism(){
        for(person p:people){
            p.work();
            if(p instanceof member m){
                System.out.println("Active members: "+m.isActiveMember());
            }
            else if(p instanceof trainer t){
                System.out.println("Premium trrainerrr: "+t.isPremiumTrainer());
            }
            System.out.println();
        }
    }
    private void viewPrograms(){
        for(int i=0; i<programs.size(); i++){
            System.out.println((i+1)+". "+programs.get(i));
        }
    }
    private void startPrograms() throws InvalidInputException{
        viewPrograms();
        System.out.print("Choose programs: ");
        int choice = scanner.nextInt();
        if(choice<1||choice>programs.size()){
            throw new InvalidInputException("invalid");
        }
        trainingprogram p = programs.get(choice-1);
        p.startTraining();
        System.out.println(p.getTrainingPlan());
    }
}
