package model;
public abstract class person {
    protected int ID;
    protected String name;
    public person(int ID, String name){
        setID(ID);
        setName(name);
    }
    public int getID(){
        return ID;
    }
    public String getName(){
        return name;
    }
    public void setID(int ID){
        if(ID<=0){
            throw new IllegalArgumentException("ID must be more than 0");
        }
        this.ID=ID;
    }
    public void setName(String name){
        if(name==null||name.trim().isEmpty()){
            throw new IllegalArgumentException(("Name cannot be empty"));
        }
        if(name.length()<2){
            throw new IllegalArgumentException(("Name must be at least 2 characters"));
        }
        this.name=name;
    }
    public abstract void work();
    public abstract String getRole();
    @Override
    public String toString(){
        return "["+getRole()+"]"+name+"(ID:"+ID+")";
    }
}
