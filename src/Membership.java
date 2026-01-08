public class Membership {
    private int membershipId;
    private Member member; // теперь хранится объект Member
    private double price;
    private String status;

    public Membership(int membershipId, Member member, double price, String status) {
        this.membershipId = membershipId;
        this.member = member;
        this.price = price;
        this.status = status;
    }

    public Membership() {
        this.membershipId = 0;
        this.member = new Member();
        this.price = 0.0;
        this.status = "Pending";
    }

    public int getMembershipId() { return membershipId; }
    public Member getMember() { return member; }
    public double getPrice() { return price; }
    public String getStatus() { return status; }

    public void activateMembership() { status = "Active"; }
    public boolean isActive() { return status.equals("Active"); }

    public void addPayment(double amount) { if (amount > 0) price += amount; }

    @Override
    public String toString() {
        return "Membership{membershipId=" + membershipId +
                ", memberName='" + member.getName() + '\'' +
                ", price=" + price + ", status='" + status + '\'' + '}';
    }
}
