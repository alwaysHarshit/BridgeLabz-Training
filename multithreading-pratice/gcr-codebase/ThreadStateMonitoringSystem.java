
import java.lang.Thread.State;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreadStateMonitoringSystem {
    
    public static void main(String[] args) {
        List<TaskRunner> tasks = new ArrayList<>();
        tasks.add(new TaskRunner("Task-1"));
        tasks.add(new TaskRunner("Task-2"));

        StateMonitor monitor = new StateMonitor(tasks);
        monitor.start();
    }
}

class TaskRunner extends Thread{

    String taskName;

    public TaskRunner(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } 
        catch (InterruptedException e){
            System.out.println("Error while execution. Error: "+e.getMessage());
        }
        for(int i=0; i<=Integer.MAX_VALUE; i++){
            Math.sqrt(i);
        }
    }
    
}

class StateMonitor extends Thread{

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("hh:mm:ss");
    private final List<TaskRunner> tasks;
    private final Map<TaskRunner , Set<State>> tasksStates;

    public StateMonitor(List<TaskRunner> tasks) {
        this.tasks = tasks;
        this.tasksStates = new LinkedHashMap<>();

        for(TaskRunner task: tasks){
            tasksStates.put(task, new LinkedHashSet<>());
        }
    }

    @Override
    public void run(){

        for (TaskRunner task : tasks) {
            State state = task.getState();
            System.out.println("[Monitor] " + task.taskName + " is in " + state + " state at " + LocalTime.now().format(FORMATTER));
            tasksStates.get(task).add(state);
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Error: "+e.getMessage());
        }

        for (TaskRunner task : tasks) {
            task.start();
        }

        int count = 0;

        while(count!= tasks.size()){
            for(TaskRunner task: tasks ){
                State currentState =task.getState();
                System.out.println("[Monitor] "+task.taskName+" is in "+currentState+" state at " + LocalTime.now().format(FORMATTER));
                if(currentState.equals(State.TERMINATED) && !tasksStates.get(task).contains(State.TERMINATED)){
                    count++;
                }
                tasksStates.get(task).add(currentState);
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Error: "+e.getMessage());
            }
        }

        for(TaskRunner task: tasks){
            try {
                task.join();
                System.out.println("Summary: "+task.taskName+" went through "+tasksStates.get(task).size()+" states");
            } catch (InterruptedException e) {
                System.out.println(task.taskName+": Error: "+e.getMessage());
            }
        }
        
        
    }
}