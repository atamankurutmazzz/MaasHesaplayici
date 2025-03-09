package Entity;

import Interface.Bonus;
import Interface.CalculateSalary;
import Interface.RaiseSalary;
import Interface.Tax;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee implements Tax, Bonus, RaiseSalary, CalculateSalary {

    private String name;

    private float salary;

    private byte workHours;

    private short hireYear;

    public static final int CURRENT_YEAR = 2021;

    public Employee(String name,byte workHours,short hireYear,float salary){
        this.name = name;
        this.workHours = workHours;
        this.hireYear = hireYear;
        this.salary = salary;
    }

    @Override
    public float calculateTax(float salary) {
        return salary > 1000 ? salary * 0.03f : 0;
    }

    @Override
    public float calculateBonus(byte workingHours) {
        return workingHours > 40 ? (workingHours - 40) * 30 : 0;
    }

    @Override
    public float calculateRaiseSalary(float salary, int hireYear, int currentYear) {
        int workingYear = currentYear - hireYear;
        return workingYear < 9 ? salary * 0.1f : workingYear < 10 ? salary * 0.05f : workingYear > 19 ? salary * 0.15f : 0;
    }

    @Override
    public float calculate(float salary, byte workingHours, short hireYear) {
        return salary + calculateBonus(this.workHours) + calculateRaiseSalary(salary,hireYear,Employee.CURRENT_YEAR) - calculateTax(salary);
    }

    @Override
    public String toString() {
        return "Adı: " + this.name + "\n" +
                "Maaşı: " + this.salary + "\n" +
                "Çalışma saati: " + this.workHours + "\n" +
                "Başlangıç Yılı: " + this.hireYear + "\n" +
                "Vergi: " + calculateTax(this.salary) + "\n" +
                "Bonus: " + calculateBonus(this.workHours) + "\n" +
                "Maaş Artışı: " + calculateRaiseSalary(this.salary,this.hireYear,Employee.CURRENT_YEAR) + "\n" +
                "Toplam Maaş :" + calculate(this.salary,this.workHours,this.hireYear);

    }
}
