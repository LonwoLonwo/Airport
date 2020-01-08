import com.skillbox.airport.Airport;
import com.skillbox.airport.Terminal;
import com.skillbox.airport.Flight;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Loader {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        Terminal terminal = airport.getTerminals().get(0);
        List<Flight> flights = terminal.getFlights();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, +2);
        Date plus2hours = calendar.getTime();

        flights.stream()
                .filter(d -> d.getType().compareTo(Flight.Type.DEPARTURE) > -1)
                .map(Flight::getDate)
                .filter(s -> s.before(plus2hours) && s.after(new Date()))
                .forEach(System.out::println);
    }
}
