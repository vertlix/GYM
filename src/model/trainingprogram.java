package model;
public class trainingprogram implements trainable {
    private String name;
    private int duration;
    private String lvl;

    public trainingprogram(String name, int duration, String lvl) {
        setName(name);
        setDuration(duration);
        setLvl(lvl);
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        if(name==null|| name.trim().isEmpty()){
            throw new IllegalArgumentException("program name cannot be this value");
        }
        this.name= name;
    }
    public void setDuration(int duration) {
        if (duration <= 0) {
            throw new IllegalArgumentException("duration cannot be negative");
        }
        this.duration = duration;
    }
    public void setLvl(String lvl){
        if(lvl==null|| lvl.trim().isEmpty()){
            throw new IllegalArgumentException("level cannot be empty");
        }
        this.lvl= lvl;
    }
    @Override
    public void startTraining(){
        System.out.println("training program \"" +name+"\" has started!");
    }
    @Override
    public String getTrainingPlan() {
        return "Program: " + name + " | Level: "+lvl+
                " | Duration: "+duration+" weeks";
    }
    @Override
    public String toString(){
        return name +" ("+lvl+
                "duration weeks: "+duration+" weeks";
    }
}