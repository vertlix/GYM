public class Main {
    public static void main(String[] args) {

        System.out.println("=== Gym Management System ===\n");

        members member1 = new members(1, "Aruzhan Ab", "+77081135105", 0);
        members member2 = new members();

        Trainer trainer1 = new Trainer(101, "Alikhan Sh", "Strength Training", 9000);
        Trainer trainer2 = new Trainer();

        membership membership1 = new membership(5001, "Aruzhan Ab", 90000, "Pending");
        membership membership2 = new membership();

        System.out.println("--- MEMBERS ---");
        System.out.println(member1);
        System.out.println(member2);

        System.out.println("\n--- TRAINERS ---");
        System.out.println(trainer1);
        System.out.println(trainer2);

        System.out.println("\n--- MEMBERSHIP ---");
        System.out.println(membership1);
        System.out.println(membership2);

        System.out.println("\n--- GETTERS ---");
        System.out.println("Member name: " + member1.getName());
        System.out.println("Trainer specialization: " + trainer1.getSpecialization());
        System.out.println("Membership status: " + membership1.getStatus());

        System.out.println("\n--- SETTERS ---");
        member2.setName("Dimash KUKU");
        member2.setVisitCount(12);
        System.out.println(member2);

        System.out.println("--- ADDITIONAL METHODS ---");
        System.out.println(member1.getName() + " active member: " + member1.isActiveMember());
        System.out.println("Adding a visit to " + member1.getName());
        member1.addVisit();
        System.out.println(member1.getName() + " active member: " + member1.isActiveMember());

        System.out.println(trainer1.getName() + " is premium trainer: " + trainer1.isPremiumTrainer());
        System.out.println("Calculating session cost for 2 hours");
        System.out.println("Cost: " + trainer1.calculateSessionCost(2) + " KZT");
        System.out.println();

        System.out.println("--- MEMBERSHIP METHODS ---");
        System.out.println("Membership " + membership1.getMembershipId() + " active: " + membership1.isActive());
        System.out.println("Activating membership for " + membership1.getMemberName());
        membership1.activateMembership();
        membership1.addPayment(5000);
        System.out.println("Membership " + membership1.getMembershipId() + " status: " + membership1.getStatus());
        System.out.println("Membership total price: " + membership1.getPrice() + " KZT");
        System.out.println();

        System.out.println("--- MEMBER METHODS ---");
        System.out.println(member1.getName() + " active: " + member1.isActiveMember());
        System.out.println(member2.getName() + " active: " + member2.isActiveMember());
        System.out.println();
        member1.addVisit();
        member1.addVisit();
        System.out.println(member1.getName() + " visits: " + member1.getVisitCount());
        System.out.println(member1.getName() + " active: " + member1.isActiveMember());
        System.out.println();

        System.out.println("=== Program Complete ===");
    }
}