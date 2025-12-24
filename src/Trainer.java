public class Trainer {
    private int trainerId;
    private String name;
    private String specialization;
    private double hourlyRate;

    public Trainer(int trainerId, String name, String specialization, double hourlyRate) {
        this.trainerId = trainerId;
        this.name = name;
        this.specialization = specialization;
        this.hourlyRate = hourlyRate;
    }


    public Trainer() {
        this.trainerId = 0;
        this.name = "Unknown Trainer";
        this.specialization = "General";
        this.hourlyRate = 0.0;
    }


    public int getTrainerId() {
        return trainerId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public boolean isPremiumTrainer() {
        return hourlyRate > 8000;
    }

    public double calculateSessionCost(int hours) {
        return hourlyRate * hours;
    }


    @Override
    public String toString() {
        return "Trainer{trainerId=" + trainerId +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", hourlyRate=" + hourlyRate + '}';
    }
}
