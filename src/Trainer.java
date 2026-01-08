public class Trainer extends Person {
    private String specialization;
    private double hourlyRate;

    public Trainer(int trainerId, String name, String specialization, double hourlyRate) {
        super(trainerId, name, "N/A");
        setSpecialization(specialization);
        setHourlyRate(hourlyRate);
    }

    public Trainer() {
        super();
        this.specialization = "General";
        this.hourlyRate = 0.0;
    }

    public String getSpecialization() { return specialization; }
    public double getHourlyRate() { return hourlyRate; }

    public void setSpecialization(String specialization) {
        if (specialization != null && !specialization.isEmpty()) this.specialization = specialization;
    }

    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate >= 0) this.hourlyRate = hourlyRate;
    }

    public boolean isPremiumTrainer() { return hourlyRate > 8000; }

    public double calculateSessionCost(int hours) { return hourlyRate * hours; }

    @Override
    public void work() {
        System.out.println(name + " is training clients.");
    }

    @Override
    public String toString() {
        return "Trainer{trainerId=" + id + ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' + ", hourlyRate=" + hourlyRate + '}';
    }
}
