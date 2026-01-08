public class Member extends Person {

    private int visitCount;

    public Member(int memberId, String name, String phoneNumber, int visitCount) {
        super(memberId, name, phoneNumber);
        setVisitCount(visitCount);
    }

    public Member() {
        super();
        this.visitCount = 0;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        if (visitCount >= 0) {
            this.visitCount = visitCount;
        }
    }


    public void addVisit() {
        visitCount++;
    }

    public boolean isActiveMember() {
        return visitCount >= 10;
    }


    @Override
    public void work() {
        System.out.println(name);
    }

    @Override
    public String toString() {
        return "Member{memberId=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phoneNumber + '\'' +
                ", visitCount=" + visitCount + '}';
    }
}
