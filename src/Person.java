public abstract class Person {
    protected int id;
    protected String name;
    protected String phoneNumber;

    public Person(int id, String name, String phoneNumber) {
        this.id = id;
        setName(name);
        setPhoneNumber(phoneNumber);
    }

    public Person() {
        this.id = 0;
        this.name = "Unknown";
        this.phoneNumber = "N/A";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && phoneNumber.length() >= 5) {
            this.phoneNumber = phoneNumber;
        }
    }
    public abstract void work();
}
