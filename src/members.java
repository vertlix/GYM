public class members {
    private int memberId;
    private String name;
    private String phoneNumber;
    private int visitCount;


    public members(int memberId, String name, String phoneNumber, int visitCount) {
        this.memberId = memberId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.visitCount = visitCount;
    }


    public members() {
        this.memberId = 0;
        this.name = "Unknown Member";
        this.phoneNumber = "N/A";
        this.visitCount = 0;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getVisitCount() {
        return visitCount;
    }


    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public void addVisit() {
        visitCount++;
    }

    public boolean isActiveMember() {
        return visitCount >= 10;
    }


    @Override
    public String toString() {
        return "Member{memberId=" + memberId +
                ", name='" + name + '\'' +
                ", phone='" + phoneNumber + '\'' +
                ", visitCount=" + visitCount + '}';
    }
}
