public class membership {
    private int membershipId;
    private String memberName;
    private double price;
    private String status;

    public membership(int membershipId, String memberName, double price, String status) {
        this.membershipId = membershipId;
        this.memberName = memberName;
        this.price = price;
        this.status = status;
    }

    public membership() {
        this.membershipId = 0;
        this.memberName = "Unknown";
        this.price = 0.0;
        this.status = "Pending";
    }

    public int getMembershipId() {
        return membershipId;
    }

    public String getMemberName() {
        return memberName;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public void setMembershipId(int membershipId) {
        this.membershipId = membershipId;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void activateMembership() {
        status = "Active";
    }

    public boolean isActive() {
        return status.equals("Active");
    }

    public void addPayment(double amount) {
        price += amount;
    }


    @Override
    public String toString() {
        return "Membership{membershipId=" + membershipId +
                ", memberName='" + memberName + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';
    }
}
