import java.util.*;
class Task1{
	String name;
	int deadLine;
	int computeTime;
	boolean finished;
	int lateness;
	// Constructor
	public Task1(String name, int deadLine, int computeTime){
		this.name = name;
		this.deadLine = deadLine;
		this.computeTime = computeTime;
	}
	public String returnName(){
		return name;
	}
	@Override
	public String toString(){
		return name +  " Computation time: " + computeTime + " deadLine: " + deadLine;
	}
}
class Task2{
    String name;
    int deadLine;
    int computeTime;
    boolean finished;
    int lateness;
    // Constructor
    public Task2(String name, int deadLine, int computeTime){
        this.name = name;
        this.deadLine = deadLine;
        this.computeTime = computeTime;
    }
    public String returnName(){
        return name;
    }
    @Override
    public String toString(){
        return name +  " Computation time: " + computeTime + " deadLine: " + deadLine;
    }
}
class Task3{
    String name;
    int deadLine;
    int computeTime;
    boolean finished;
    int lateness;
    // Constructor
    public Task3(String name, int deadLine, int computeTime){
        this.name = name;
        this.deadLine = deadLine;
        this.computeTime = computeTime;
    }
    public String returnName(){
        return name;
    }
    @Override
    public String toString(){
        return name +  " Computation time: " + computeTime + " deadLine: " + deadLine;
    }
}
class latenessContainer{
    String scheduler;
    int lateness;
    public latenessContainer(String scheduler, int lateness){
        this.scheduler = scheduler;
        this.lateness = lateness;
    }
}
public class combined{
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of tasks:");
		int taskNumber = scanner.nextInt();
		List<Task1> tasks1 = new ArrayList<Task1>();
        List<Task2> tasks2 = new ArrayList<Task2>();
        List<Task3> tasks3 = new ArrayList<Task3>();
        List<latenessContainer> container = new ArrayList<latenessContainer>();
		int computeTime;
		int deadLine;
		for(int i = 0; i < taskNumber; i++){
			System.out.println("Enter Computation time for task " + (i+1));
			computeTime = scanner.nextInt();
			System.out.println("Enter dead line for task " +(i+1));
			deadLine = scanner.nextInt();
			tasks1.add(new Task1("Task" + (i+1),deadLine,computeTime));
            tasks2.add(new Task2("Task" + (i+1),deadLine,computeTime));
            tasks3.add(new Task3("Task" + (i+1),deadLine,computeTime));
		}


		for(Task1 temp : tasks1){
			System.out.println(temp);
		}

		System.out.println("Running simulation for FCFS");
		int FCFStotal = FCFSsimulate(tasks1, taskNumber);

        System.out.println("");

        System.out.println("Running simulation for SJF");

        //sorting by shortest job first
        for(int i = 0; i < taskNumber; i++){
            for(int j = 0; j < taskNumber; j++){
                if(tasks2.get(i).computeTime < tasks2.get(j).computeTime){
                    Collections.swap(tasks2,i,j);
                }
            }
        }
        int SJFtotal = SJFsimulate(tasks2, taskNumber);


        System.out.println("");

        System.out.println("Running simulation for EDD");
        //sorting deadlines
        for(int i = 0; i < taskNumber; i++){
            for(int j = 0; j < taskNumber; j++){
                if(tasks3.get(i).deadLine < tasks3.get(j).deadLine){
                    Collections.swap(tasks3,i,j);
                }
            }
        }
        int EDDtotal = EDDsimulate(tasks3, taskNumber);

        System.out.println("FCFS " + FCFStotal);
        System.out.println("SJF " + SJFtotal);
        System.out.println("EDD " + EDDtotal);
	}
	static int FCFSsimulate(List<Task1> tasks, int taskNumber){
        boolean active = false;
        int i = 0;
        int lateness = 0;
        for(int timeSim = 0; timeSim < 100; timeSim++){
            if(tasks.get(i).computeTime == 0){
                System.out.println(tasks.get(i).returnName() + " Finished at " + timeSim);
                System.out.println("With a lateness of " + (timeSim - tasks.get(i).deadLine));
                lateness += (timeSim - tasks.get(i).deadLine);

                if(i == taskNumber-1){
                    break;
                }
                else{
                    i++;
                    tasks.get(i).computeTime--;
                }
            }
            else{
                tasks.get(i).computeTime--;
            }
        }
        return lateness;
    }
    static int SJFsimulate(List<Task2> tasks, int taskNumber){
        boolean active = false;
        int i = 0;
        int lateness = 0;
        for(int timeSim = 0; timeSim < 100; timeSim++){
            if(tasks.get(i).computeTime == 0){
                System.out.println(tasks.get(i).returnName() + " Finished at " + timeSim);
                System.out.println("With a lateness of " + (timeSim - tasks.get(i).deadLine));
                lateness += (timeSim - tasks.get(i).deadLine);
                if(i == taskNumber-1){
                    break;
                }
                else{
                    i++;
                    tasks.get(i).computeTime--;
                }
            }
            else{
                tasks.get(i).computeTime--;
            }
        }
        return lateness;
    }
    static int EDDsimulate(List<Task3> tasks, int taskNumber){
        boolean active = false;
        int i = 0;
        int lateness = 0;
        System.out.println("IN EDD");
        for(int timeSim = 0; timeSim < 100; timeSim++){
            if(tasks.get(i).computeTime == 0){
                System.out.println(tasks.get(i).returnName() + " Finished at " + timeSim);
                System.out.println("With a lateness of " + (timeSim - tasks.get(i).deadLine));
                lateness += (timeSim - tasks.get(i).deadLine);
                if(i == taskNumber-1){
                    break;
                }
                else{
                    i++;
                    tasks.get(i).computeTime--;
                }
            }
            else{
                tasks.get(i).computeTime--;
            }
        }
        return lateness;
    }
}
