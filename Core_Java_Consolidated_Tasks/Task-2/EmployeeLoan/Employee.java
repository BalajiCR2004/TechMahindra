public class Employee{
    private int empId;
    private String empName;
    private double sal;
    private double yearsWorked;
    
    public Employee(int empId, String empName, double sal,double yearsWorked) {
        this.empId = empId;
        this.empName = empName;
        this.sal = sal;
        this.yearsWorked=yearsWorked;
    }
    //only used getters because we will be not updating the employee details

    
    public int getEmpId() {
        return empId;
    }
    public String getEmpName() {
        return empName;
    }
    public double getSal() {
        return sal;
    }

    public double getYearsWorked() {
        return yearsWorked;
    }
    
    
}
