import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int id;
    private String designation;
    public Employee(String name,int id,String designation){
        this.name=name;
        this.id=id;
        this.designation=designation;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public String getDesignation(){
        return designation;
    }
    public abstract double calculateSalary();
    public abstract double bonus();
    @Override
    public String toString(){
        return "Employee [name="+name+",id="+id+", designation="+designation+", Salary="+calculateSalary()+"bonus is="+bonus()+"]";
    }
}
class FullTimeEmployee extends Employee{
    private double monthlySalary;

    public FullTimeEmployee(String name,int id,String designation,double monthlySalary){
        super(name,id,designation);
        this.monthlySalary=monthlySalary;

    }
    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
    @Override
    public double bonus(){
        return monthlySalary*0.3;
    }


}
class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;
    public PartTimeEmployee(String name,int id,String designation,int hoursWorked,int hourlyRate){
        super(name,id,designation);
        this.hoursWorked=hoursWorked;
        this.hourlyRate=hourlyRate;
    }
    @Override
    public double calculateSalary(){
        return hoursWorked*hourlyRate;
    }
    @Override
    public double bonus(){
        return hourlyRate*0.3*hoursWorked;
    }
}
class TemporaryEmployee extends Employee{

    private int monthSalary;
    public TemporaryEmployee(String name,int id,String designation,int monthSalary){
        super(name,id,designation);
        this.monthSalary=monthSalary;


    }
    @Override
    public double calculateSalary(){
        return monthSalary;
    }
    @Override
    public double bonus(){
        return monthSalary*0.1;
    }
}
class PayrollSystem{
    private ArrayList<Employee> employeeList;
    public PayrollSystem(){
        employeeList=new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for(Employee emp: employeeList){
            if(emp.getId() == id){
                employeeToRemove = emp;
                break;
            }
        }
        if(employeeToRemove != null){
            employeeList.remove(employeeToRemove);
        }
    }
    public void displayEmployees(){
        for(Employee emp:employeeList){
            System.out.println(emp);
            System.out.println("Bonus: " + emp.bonus());
            System.out.println("---------------------------");
        }
    }
}


public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem=new PayrollSystem();
        FullTimeEmployee emp1=new FullTimeEmployee("simra", 1,"Java developer",50000);


        PartTimeEmployee emp2=new PartTimeEmployee("raju",2,"data analyst",40,200);
        TemporaryEmployee emp3=new TemporaryEmployee("sidra",3,"web developer",40000);
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        payrollSystem.addEmployee(emp3);
        System.out.println("Initial Employee details");
        payrollSystem.displayEmployees();
        System.out.println("Remove Employee details");
        payrollSystem.removeEmployee(2);
        System.out.println("Remaining Employee details");
        payrollSystem.displayEmployees();
    }
}