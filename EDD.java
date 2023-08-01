import java.util.*;

class Task{
	String name;
	int deadLine;
	int computeTime;
	// Constructor
	public Task(String name, int deadLine, int computeTime){
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

public class EDD{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of tasks:");
		int taskNumber = scanner.nextInt();
		List<Task> tasks = new ArrayList<Task>();
		int computeTime;
		int deadLine;
		// adding a new task object for ech task
		for(int i = 0; i < taskNumber; i++){
			System.out.println("Enter Computation time for task " + (i+1));
			computeTime = scanner.nextInt();
			System.out.println("Enter dead line for task " +(i+1));
			deadLine = scanner.nextInt();
			tasks.add(new Task("Task"+ (i+1),deadLine,computeTime));
		}



		//sorting by deadlines using collections.swap
		for(int i = 0; i < taskNumber; i++){
			for(int j = 0; j < taskNumber; j++){
				if(tasks.get(i).deadLine < tasks.get(j).deadLine){
					Collections.swap(tasks,i,j);
				}
			}
		}
		// Just printing out what the user inputted
		for(Task temp : tasks){
			System.out.println(temp);
		}
		System.out.println("Running simulation...");
		EDDsimulate(tasks,taskNumber);
	}
	// This method time steps from 0 to 100, everystep subtracts one from the computation time of the task currently being 'run'
	static void EDDsimulate(List<Task> tasks, int taskNumber){
		boolean active = false;
		int i = 0;
		for(int timeSim = 0; timeSim < 100; timeSim++){
			System.out.println("Time: " + timeSim);
			if(tasks.get(i).computeTime == 0){
				System.out.println(tasks.get(i).returnName() + " Finished at " + timeSim);
				System.out.println("With a lateness of " + (timeSim - tasks.get(i).deadLine));
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
	}
}

