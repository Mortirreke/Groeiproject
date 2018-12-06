package be.kdg.logging;

import java.text.MessageFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * @author: Quinten Mortier
 **/
public class SmallLogFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        return Instant.ofEpochMilli(record.getMillis()).atZone(ZoneId.systemDefault()).toLocalDateTime() +  " | Level : " + record.getLevel() + " | Melding: \"" + MessageFormat.format(record.getMessage(), record.getParameters()) + "\"\n";
    }
}
