class Task {

    int taskId;
    String taskName;
    String status;
    Task next;

    Task(int taskId,String taskName,String status){
        this.taskId=taskId;
        this.taskName=taskName;
        this.status=status;
    }
}

public class Exe5TaskManagementSystem {

    static Task head=null;

    static void addTask(int id,String name,String status){

        Task newTask=new Task(id,name,status);

        if(head==null){
            head=newTask;
            return;
        }

        Task temp=head;
        while(temp.next!=null)
            temp=temp.next;

        temp.next=newTask;
    }

    static void display(){

        Task temp=head;

        while(temp!=null){
            System.out.println(temp.taskId+" "+temp.taskName);
            temp=temp.next;
        }
    }

    public static void main(String[] args){

        addTask(1,"Coding","Pending");
        addTask(2,"Testing","Done");

        display();
    }
}