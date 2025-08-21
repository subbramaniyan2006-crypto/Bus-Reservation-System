import java.util.Scanner;

class Bus {
    int busNo;
    String driver;
    String arrival;
    String departure;
    String from;
    String to;
    int seats = 20;
    boolean[] bookedSeats = new boolean[seats];

    public Bus(int busNo, String driver, String arrival, String departure, String from, String to) {
        this.busNo = busNo;
        this.driver = driver;
        this.arrival = arrival;
        this.departure = departure;
        this.from = from;
        this.to = to;
    }

    public void displayBusInfo() {
        System.out.println("Bus No: " + busNo + " | Driver: " + driver + " | Arrival: " + arrival + " | Departure: " + departure + " | From: " + from + " | To: " + to);
    }

    public boolean bookSeat(int seat) {
        if (seat > 0 && seat <= seats && !bookedSeats[seat-1]) {
            bookedSeats[seat-1] = true;
            return true;
        }
        return false;
    }

    public void displaySeats() {
        System.out.print("Available seats: ");
        for(int i=0; i<seats; i++) {
            if(!bookedSeats[i]) System.out.print((i+1) + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Bus[] buses = {
            new Bus(1, "John", "10:00", "5:00", "CityA", "CityB"),
            new Bus(2, "Mike", "12:00", "6:00", "CityA", "CityC")
        };

        while(true) {
            System.out.println("\n=== Bus Reservation System ===");
            System.out.println("1. View Buses");
            System.out.println("2. Book Ticket");
            System.out.println("3. Exit");
            System.out.print("Enter your option: ");
            int opt = scanner.nextInt();

            if(opt == 1) {
                for(Bus bus : buses) {
                    bus.displayBusInfo();
                }
            } else if(opt == 2) {
                System.out.print("Enter Bus No: ");
                int busNo = scanner.nextInt();
                Bus selectedBus = null;
                for(Bus bus : buses) {
                    if(bus.busNo == busNo) selectedBus = bus;
                }
                if(selectedBus != null) {
                    selectedBus.displaySeats();
                    System.out.print("Enter seat number to book: ");
                    int seat = scanner.nextInt();
                    if(selectedBus.bookSeat(seat)) {
                        System.out.println("Seat booked successfully!");
                    } else {
                        System.out.println("Seat already booked or invalid seat.");
                    }
                } else {
                    System.out.println("Bus Not Found!");
                }
            } else if(opt == 3) {
                System.out.println("Thank you for using the Bus Reservation System.");
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }
}