public class Passenger {
    private int passengerId;
    private String passengerName;
    private int age;
    private String mailId;
    private String contactNumber;
    private String gender;

    public Passenger(int passengerId, String passengerName, int age, String mailId, String contactNumber, String gender) {
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.age = age;
        this.mailId = mailId;
        this.contactNumber = contactNumber;
        this.gender = gender;
    }

    public int getPssengerId() {
        return passengerId;
    }
}
