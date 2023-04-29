package datastructures.model;
import java.time.LocalTime;

public class Passenger {
    String name;
    int id;
    int age;
    int row;
    String colum;
    Boolean firstClass;
    int miles;
    private LocalTime time;


    public Passenger(String name, int id, int age, int row, String colum, Boolean firstClass, int miles, LocalTime time) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.row = row;
        this.colum = colum;
        this.firstClass = firstClass;
        this.miles = miles;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public int getRow() {
        return row;
    }

    public String getColum() {
        return colum;
    }

    public Boolean getFirstClass() {
        return firstClass;
    }

    public int getMiles() {
        return miles;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColum(String colum) {
        this.colum = colum;
    }

    public void setFirstClass(Boolean firstClass) {
        this.firstClass = firstClass;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
    @Override
    public String toString(){
        return "Passenger is: "+name +".";
    }
}
