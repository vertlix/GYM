package model;
public class member extends person {
    private int Visitcount;
    public member(int ID, String name, int Visitcount){
        super(ID, name);
        setVisitcount(Visitcount);
    }
    public int getVisitcount(){
        return Visitcount;
    }
    public void setVisitcount(int Visitcount){
        if(Visitcount<0){
            throw new IllegalArgumentException("VISITCOUNT CANNOT BE NEGATIVE");
        }
        this.Visitcount=Visitcount;
    }
    public boolean IsActiveMember(){
        return Visitcount>=20;
    }
    @Override
    public void work() {
        System.out.println("member"+name+" is working out at the gym.");
    }
    @Override
    public String getRole(){
        return "member";
    }
    @Override
    public String toString(){
        return super.toString()+"Visits:"+Visitcount;
    }
}
