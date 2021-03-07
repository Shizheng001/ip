package Duke;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    private final LocalDate deadLine;

    public Deadline(String description, String deadLine) {
        super(description);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
        this.deadLine = LocalDate.parse(deadLine.trim(), formatter);
    }

    @Override
    public String encode() {
        return "D|" + super.encode() + " | " + this.deadLine.format(DateTimeFormatter.ofPattern("yyyy-M-dd"));
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " | " + " (by: " + this.deadLine.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }

}
