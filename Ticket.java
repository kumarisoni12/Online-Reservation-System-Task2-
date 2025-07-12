
public class Ticket {
    static int counter = 1000;
    int pnr;
    String name, trainNo, trainName, from, to, date, travelClass;

    public Ticket(String name, String trainNo, String trainName, String from, String to, String date, String travelClass) {
        this.pnr = counter++;
        this.name = name;
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.from = from;
        this.to = to;
        this.date = date;
        this.travelClass = travelClass;
    }

    public void display() {
        System.out.println("PNR: " + pnr);
        System.out.println("Name: " + name);
        System.out.println("Train Number: " + trainNo);
        System.out.println("Train Name: " + trainName);
        System.out.println("From: " + from + " To: " + to);
        System.out.println("Date: " + date);
        System.out.println("Class: " + travelClass);
    }
}
