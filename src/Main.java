
import  java.util.Scanner;
class Payroll {
    private int [] employeeId = {5658845, 4520125, 7895122, 8777541,8451277,1302850, 7580489};
    private final int NUMBER_OF_EMPLOYEES = employeeId.length;
    private int [] hours;
    private double [] payRate;
    private double [] wages;

    public void calculateWages(){
        for (int employeeIndex = 0; employeeIndex < NUMBER_OF_EMPLOYEES; employeeIndex++){
            wages[employeeIndex] = hours[employeeIndex] * payRate[employeeIndex];

        }
    }
    public double getEmployeeWagesById(int employeeIdGiven){
        for (int employeeIndex = 0; employeeIndex < NUMBER_OF_EMPLOYEES; employeeIndex ++){
            if(employeeId[employeeIndex] == employeeIdGiven){
                return wages[employeeIndex];
            }
        }
        return -1;
    }

    public int[] getAllEmployeeIds() {
        return employeeId;
    }
    public int[] getAllEmployeeHours() {
        return hours;
    }
    public double[] getAllEmployeePayRates() {
        return payRate;
    }
    public double[] getAllEmployeeWages() {
        return wages;
    }

    public void setEmployeeHours (int employeeHoursGiven, int employeeIndexGiven){
        hours[employeeIndexGiven] = employeeHoursGiven;
    }
    public void setEmployeePayRate (double employeePayRateGiven, int employeeIndexGiven){
        payRate[employeeIndexGiven] = employeePayRateGiven;
    }

    public Payroll(){
        hours = new int[NUMBER_OF_EMPLOYEES];
        payRate = new double[NUMBER_OF_EMPLOYEES];
        wages = new double[NUMBER_OF_EMPLOYEES];
    }
}
public class Main {
    public static void assignEmployeeHoursAndPayrates(Payroll payrollObject){
        Scanner keyboard =new Scanner(System.in);
        int employeeHours;
        double employeePayRate;


        for (int employeeIndex = 0; employeeIndex < payrollObject.getAllEmployeeIds().length; employeeIndex++){
            System.out.println("Enter the hours for the employee " + payrollObject.getAllEmployeeIds()[employeeIndex]);
            employeeHours = keyboard.nextInt();
            while(employeeHours < 0){
                System.out.println("Enter the hours for the employee " +
                        payrollObject.getAllEmployeeIds()[employeeIndex] + "(It must be a positive number)");
                employeeHours = keyboard.nextInt();
            }
            payrollObject.setEmployeeHours(employeeHours, employeeIndex);
            System.out.println("Whats the pay rate for the employee " + payrollObject.getAllEmployeeIds()[employeeIndex]);
            employeePayRate = keyboard.nextDouble();
            while(employeePayRate < 6.00){
                System.out.println("Whats the pay rate for the employee " +
                        payrollObject.getAllEmployeeIds()[employeeIndex] + "(It must be greater than 6)");
                employeePayRate = keyboard.nextDouble();
            }
            payrollObject.setEmployeePayRate(employeePayRate, employeeIndex);

        }
    }
    public static void displayEmployeeWages(Payroll payrollObject){
        for(int employeeIndex = 0; employeeIndex < payrollObject.getAllEmployeeIds().length; employeeIndex++) {
            System.out.println("The employee " + payrollObject.getAllEmployeeIds()[employeeIndex]+
                    " worked for " + payrollObject.getAllEmployeeHours() [employeeIndex] +
                    " hours and earned" +
                    String.format("$%.2f",payrollObject.getAllEmployeeWages()[employeeIndex]));
        }
    }

    public static void main(String[] args) {
        Payroll employeeInfo = new Payroll();
        assignEmployeeHoursAndPayrates(employeeInfo);
        employeeInfo.calculateWages();
        displayEmployeeWages(employeeInfo);

        int singleEmployeeId = 5658845;

        if(employeeInfo.getEmployeeWagesById(singleEmployeeId) != -1) {
            System.out.println("The single employee with id " + singleEmployeeId + " earned " +
                    String.format("$%,.2f",employeeInfo.getEmployeeWagesById(singleEmployeeId)));
        } else{
            System.out.println(" The single employee with id " + singleEmployeeId + " wasn't found");
        }
    }
}
