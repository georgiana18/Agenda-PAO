package services.Writer;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Audit {
    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    //CSV file header
    private static final String FILE_HEADER = "Action , Timestamp";

    private String timestamp;
    static String filePath = "src/main/resources/Audit.csv";
    private static boolean hasHeader = false;

    public Audit(String action)
    {
        timestamp = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(Calendar.getInstance().getTime());
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath,true);

            //Write the CSV file header
            if(!this.hasHeader)
            {
                fileWriter.append(FILE_HEADER.toString());
                this.hasHeader = true;

                //Add a new line separator after the header
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

            fileWriter.append(String.valueOf(action));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(timestamp));
            fileWriter.append(NEW_LINE_SEPARATOR);


        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }
    }
}

