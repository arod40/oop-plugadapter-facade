package pluggable_adapter.builder;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;

public class IDDefinedEntityCollection {
    public interface Builder{
        void addRecord(CSVRecord record);
    }

    public static void construct(String csvPath, Builder builder) throws IOException {
        FileReader in = new FileReader(csvPath);
        String[] HEADERS = { "ID", "Type", "Name", "ParentContestID", "Attendees"};
        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
            .setHeader(HEADERS)
            .setSkipHeaderRecord(true)
            .build();

        for(CSVRecord record: csvFormat.parse(in)){
            builder.addRecord(record);
        }
    }
}
