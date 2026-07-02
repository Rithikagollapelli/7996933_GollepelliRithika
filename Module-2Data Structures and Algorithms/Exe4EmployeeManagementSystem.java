class Employee {

    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int id,String name,String position,double salary){
        this.employeeId=id;
        this.name=name;
        this.position=position;
        this.salary=salary;
    }
}

public class Exe4EmployeeManagementSystem {

    static Employee employees[] = new Employee[100];
    static int count=0;

    static void add(Employee e){
        employees[count++] = e;
    }

    static void search(int id){
        for(int i=0;i<count;i++){
            if(employees[i].employeeId==id){
                System.out.println(employees[i].name);
                return;
            }
        }
        System.out.println("Not Found");
    }

    static void traverse(){
        for(int i=0;i<count;i++){
            System.out.println(employees[i].name);
        }
    }

    public static void main(String[] args){

        add(new Employee(1,"Ravi","Manager",50000));
        add(new Employee(2,"John","Developer",40000));

        search(2);
        traverse();
    }
}