public class empLoanCheck {
    public static String loanCheck(Employee emp){
        if((emp.getYearsWorked()>5)){
            if(emp.getSal()>=1500000){
                return (emp.getEmpName()+" is Eligible for a loan of 7 lakhs");
            }
            else if(emp.getSal()>=1000000){
                return (emp.getEmpName()+" is Eligible for a loan of 5 lakhs");
            }
            else if(emp.getSal()>=600000){
               return (emp.getEmpName()+" is Eligible for a loan of 2 lakhs");
            }
        }  
        return (emp.getEmpName()+" is Not Eligible for a loan");
        
    }
    public static void main(String[] args) {
        Employee emp1=new Employee(1, "Balaji", 2000000, 8);
        Employee emp2=new Employee(2, "Abinesh", 1000000, 6);
        Employee emp3=new Employee(3, "Ashwin", 1500000, 2);
        Employee emp4=new Employee(4, "Sai", 400000, 0.5);

        System.out.println(loanCheck(emp1));
        System.out.println(loanCheck(emp2));
        System.out.println(loanCheck(emp3));
        System.out.println(loanCheck(emp4));



    }
}
