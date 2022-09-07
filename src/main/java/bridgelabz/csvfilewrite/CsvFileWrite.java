package bridgelabz.csvfilewrite;

import bridgelabz.model.UserModel;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvFileWrite {

    public static final String NEW_FILE="censuswrite.csv";

    public static void main(String[] args) {

        try (Writer writer= Files.newBufferedWriter(Paths.get(NEW_FILE))){

            StatefulBeanToCsv<UserModel> beanToCsv=new StatefulBeanToCsvBuilder<UserModel>(writer).build();

            List<UserModel> list=new ArrayList<>();

            UserModel userModel1=new UserModel("Uttar Pradesh","19,98,12,341");
            UserModel userModel2=new UserModel("Maharashtra","11,23,74,333");
            UserModel userModel3=new UserModel("Bihar","10,40,99,452");
            list.add(userModel1);
            list.add(userModel2);
            list.add(userModel3);
            beanToCsv.write(list);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvRequiredFieldEmptyException e) {
            throw new RuntimeException(e);
        } catch (CsvDataTypeMismatchException e) {
            throw new RuntimeException(e);
        }
    }
}
