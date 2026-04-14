import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class TravelPlanner {
    
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public static long calculateTripDuration(LocalDate departureDate, LocalDate returnDate) {
        return ChronoUnit.DAYS.between(departureDate, returnDate);
    }
    
    public static boolean validateTravelDates(LocalDate departureDate, LocalDate returnDate) {
        LocalDate today = LocalDate.now();
        
        if (departureDate.isBefore(today)) {
            System.out.println("Error: Departure date cannot be in the past");
            return false;
        }
        
        if (returnDate.isBefore(departureDate) || returnDate.isEqual(departureDate)) {
            System.out.println("Error: Return date must be after departure date");
            return false;
        }
        
        long tripDuration = calculateTripDuration(departureDate, returnDate);
        if (tripDuration > 90) {
            System.out.println("Error: Trip cannot be longer than 90 days");
            return false;
        }
        
        return true;
    }
    
    public static String calculateHotelDates(LocalDate departureDate, LocalDate returnDate) {
        String checkInDate = departureDate.format(DATE_FORMATTER);
        String checkOutDate = returnDate.format(DATE_FORMATTER);
        
        return "Hotel Check-in: " + checkInDate + "\nHotel Check-out: " + checkOutDate;
    }
    
    public static boolean tripOverlapsHoliday(LocalDate departureDate, LocalDate returnDate, LocalDate holidayDate) {
        return (holidayDate.isEqual(departureDate) || holidayDate.isEqual(returnDate) ||
                (holidayDate.isAfter(departureDate) && holidayDate.isBefore(returnDate)));
    }
    
    private static LocalDate parseDate(String dateStr) throws DateTimeParseException {
        return LocalDate.parse(dateStr, DATE_FORMATTER);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        System.out.println("=== Travel Planner Application ===");
        System.out.println("All dates should be entered in format dd/MM/yyyy");
        
        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Calculate trip duration");
            System.out.println("2. Validate travel dates");
            System.out.println("3. Calculate hotel check-in and check-out");
            System.out.println("4. Check if trip overlaps with a holiday");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            
            String choice = scanner.nextLine();
            
            LocalDate departureDate = null;
            LocalDate returnDate = null;
            
            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter departure date (dd/MM/yyyy): ");
                        departureDate = parseDate(scanner.nextLine());
                        
                        System.out.print("Enter return date (dd/MM/yyyy): ");
                        returnDate = parseDate(scanner.nextLine());
                        
                        long duration = calculateTripDuration(departureDate, returnDate);
                        System.out.println("Trip duration: " + duration + " days");
                        break;
                        
                    case "2":
                        System.out.print("Enter departure date (dd/MM/yyyy): ");
                        departureDate = parseDate(scanner.nextLine());
                        
                        System.out.print("Enter return date (dd/MM/yyyy): ");
                        returnDate = parseDate(scanner.nextLine());
                        
                        boolean isValid = validateTravelDates(departureDate, returnDate);
                        if (isValid) {
                            System.out.println("Travel dates are valid!");
                        }
                        break;
                        
                    case "3":
                        System.out.print("Enter departure date (dd/MM/yyyy): ");
                        departureDate = parseDate(scanner.nextLine());
                        
                        System.out.print("Enter return date (dd/MM/yyyy): ");
                        returnDate = parseDate(scanner.nextLine());
                        
                        if (validateTravelDates(departureDate, returnDate)) {
                            String hotelDates = calculateHotelDates(departureDate, returnDate);
                            System.out.println(hotelDates);
                        }
                        break;
                        
                    case "4":
                        System.out.print("Enter departure date (dd/MM/yyyy): ");
                        departureDate = parseDate(scanner.nextLine());
                        
                        System.out.print("Enter return date (dd/MM/yyyy): ");
                        returnDate = parseDate(scanner.nextLine());
                        
                        System.out.print("Enter holiday date (dd/MM/yyyy): ");
                        LocalDate holidayDate = parseDate(scanner.nextLine());
                        
                        if (validateTravelDates(departureDate, returnDate)) {
                            boolean overlaps = tripOverlapsHoliday(departureDate, returnDate, holidayDate);
                            if (overlaps) {
                                System.out.println("Your trip overlaps with the holiday!");
                            } else {
                                System.out.println("Your trip does not overlap with the holiday.");
                            }
                        }
                        break;
                        
                    case "5":
                        running = false;
                        System.out.println("Thank you for using Travel Planner!");
                        break;
                        
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Error: Invalid date format. Please use dd/MM/yyyy format.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
        
        scanner.close();
    }
}