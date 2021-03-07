package Duke;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private LocalDate eventTime;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");

        public Event(String description, String eventTime) {
            super(description);
            this.eventTime = LocalDate.parse(eventTime.trim(), formatter);
        }
    @Override
    public String encode() {
        return "E|" + super.encode() + " | " + this.eventTime.format(DateTimeFormatter.ofPattern("yyyy-M-dd"));
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + this.eventTime.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }
}


