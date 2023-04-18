import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.Scanner;

public class TimeZoneConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // List all available time zones
        System.out.println("Available time zones:");
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        for (String zoneId : zoneIds) {
            System.out.println(zoneId);
        }

        // Prompt user for input
        System.out.print("Enter local time zone: ");
        String localTimeZone = scanner.nextLine();
        System.out.print("Enter country code: ");
        String countryCode = scanner.nextLine();

        // Convert local time to country time
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId localZone = ZoneId.of(localTimeZone);
        ZonedDateTime localZonedDateTime = ZonedDateTime.of(localDateTime, localZone);

        ZoneId countryZone = ZoneId.of(countryCode);
        ZonedDateTime countryZonedDateTime = localZonedDateTime.withZoneSameInstant(countryZone);

        // Print results
        System.out.println("Local date and time: " + localZonedDateTime);
        System.out.println("Country date and time: " + countryZonedDateTime);
    }
}
