package model;
public class trainer extends person {
    private String special;
    private double hourRate;
    public trainer(int ID, String name, String special, double hourRate){
        super(ID, name);
        setSpecial(special);
        setHourRate(hourRate);
    }
    public String getSpecial(){
        return special;
    }
    public double hourRate(){
        return hourRate;
    }
    public void setSpecial(String special){
        if(special==null||special.trim().isEmpty()){
            throw new IllegalArgumentException(("specialization cannot be empty"));
        }
        this.special=special;
    }
    public void setHourRate(double hourRate){
        if(hourRate<=0){
            throw new IllegalArgumentException("hourly rate cannot be this value");
        }
        this.hourRate=hourRate;
    }
    public boolean isPremiumTrainer(){
        return hourRate>=1000;
    }

    @Override
    public void work() {

    }

    @Override
    public String getRole(){
        return "TRAINER";
    }
    @Override
    public String toString(){
        return super.toString()+
                "Specialization: "+special+
                "Rate: "+hourRate;
    }
}
