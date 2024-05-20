import java.util.Scanner;
class Main
{
    class FlightReservation
{
    private String name;
    private int age;
    private String nationality;
    private String email;
    private String phoneNumber;
    public FlightReservation(String name, int age, String nationality, String email, String phoneNumber)
    {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public String getNationality()
    {
        return nationality;
    }
    public void setNationality(String nationality)
    {
        this.nationality = nationality;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    public void displayPassengerInfo()
    {
        System.out.println("Passenger Information:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Nationality: " + nationality);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
    }
}
class FlightReservationSystem
{
    private static final int TOTAL_SEATS = 32;
    private boolean[] seatAvailability;
    public FlightReservationSystem()
    {
        seatAvailability = new boolean[TOTAL_SEATS];
        for(int i = 0; i < TOTAL_SEATS; i++)
        seatAvailability[i] = true;
    }
    public void reserveSeat(int seatNumber)
    {
        if(seatNumber < 1 || seatNumber > TOTAL_SEATS)
        {
            System.out.println("Invalid seat number.");
            return;
        }
        if(seatAvailability[seatNumber - 1])
        {
            seatAvailability[seatNumber - 1] = false; 
            System.out.println("Seat " + seatNumber + " reserved successfully.");
        }
        else
        System.out.println("Seat " + seatNumber + " is already taken.");
    }
    public void displayAvailableSeats()
    {
        System.out.println("Available Seats:");
        for(int i = 0; i < TOTAL_SEATS; i++)
        {
            if(seatAvailability[i])
            System.out.print((i + 1) + " ");
        }
        System.out.println();
    }
}
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Passenger Information:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nationality: ");
        String nationality = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        Main sample = new Main();
        FlightReservation passenger = sample.new FlightReservation(name, age, nationality, email, phoneNumber);
        passenger.displayPassengerInfo();
        FlightReservationSystem flightReservationSystem = sample.new FlightReservationSystem();
        flightReservationSystem.displayAvailableSeats();
        System.out.print("Enter preferred seat number: ");
        int preferredSeat = scanner.nextInt();
        flightReservationSystem.reserveSeat(preferredSeat);
        flightReservationSystem.displayAvailableSeats();
        scanner.close();
    }
}