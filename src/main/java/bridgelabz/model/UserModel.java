package bridgelabz.model;

import com.opencsv.bean.CsvBindByName;

public class UserModel {
    @CsvBindByName
    private String state;
    @CsvBindByName
    private String population;


    public UserModel()
    {

    }

    public UserModel(String state,String population)
    {
        this.state =state;
        this.population =population;


    }

    @Override
    public String toString() {
        return "UserModel{" +
                "name='" + state + '\'' +
                ", city='" + population + '\'' +
                '}';
    }
}
