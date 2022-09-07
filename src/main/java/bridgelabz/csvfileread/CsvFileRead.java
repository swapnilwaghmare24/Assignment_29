package bridgelabz.csvfileread;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvFileRead {

    public static final String MY_FILE="census.csv";

    public static void main(String[] args) 
    {
        try {
            Reader reader= Files.newBufferedReader(Paths.get(MY_FILE));
            CSVReader csvReader=new CSVReader(reader);

            List<String[]> data=csvReader.readAll();

            for (String[] csvdata:data)
            {
                System.out.print(csvdata[0]);
                System.out.println("\t"+csvdata[1]);

            }

            csvReader.close();
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }

    }
}
