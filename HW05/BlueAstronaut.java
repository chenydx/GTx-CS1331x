import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate{
    
    //Variable
    //numTasks - the number of tasks that needs to be completed as an integer number
    private int numTask;

    //taskSpeed - the speed at which the astronaut is completing each task as a positive, nonzero integer number
    private int taskSpeed;
    
    public static final int DEFAULT_SUSLEVEL = 15;
    public static final int DEFAULT_NUMTASK = 6;
    public static final int DEFAULT_TASKSPEED = 10;
    //Constructors
    //A constructor that takes in the name, susLevel, numTasks, and taskSpeed and sets all fields accordingly. It must accept the variables in the specified order.
    //A constructor that takes in just a name and assigns the following default values:
    //susLevel: 15
    //numTasks: 6
    //taskSpeed: 10
    
    public BlueAstronaut(String name, int susLevel, int numTask, int taskSpeed) {
        super(name,susLevel);
        this.numTask = numTask;
        this.taskSpeed = taskSpeed;
    }

    public BlueAstronaut(String name) {
        this(name,DEFAULT_SUSLEVEL,DEFAULT_NUMTASK,DEFAULT_TASKSPEED);
    }
    
    //Methods
    public void emergencyMeeting() {
        if (super.isFrozen())
            return;
        Player[] players = Player.getPlayers();
        Arrays.sort(players);
        int sus1st_idx = players.length-1;
        Player sus1st = players[sus1st_idx];
        while (sus1st.isFrozen()) {
            sus1st_idx--;
            sus1st = players[sus1st_idx];
        }
        int sus2st_idx = sus1st_idx-1;
        Player sus2st = players[sus2st_idx];
        while (sus2st.isFrozen()) {
            sus2st_idx--;
            sus2st = players[sus2st_idx];
        }
            
        if (sus1st.getSusLevel() == sus2st.getSusLevel())
            return;
        else
            sus1st.setFrozen(true);
        super.isGameOver();
    }

    public void completeTask() {
        //A BlueAstronaut that is frozen cannot complete tasks.
        if (super.isFrozen())
            return;
        //If taskSpeed is greater than 20, subtract 2 from numTasks. Otherwise, subtract 1 from numTasks.
            if (this.taskSpeed>20)
            this.numTask -= 2;
        else
            this.numTask -= 1;
        //If numTasks falls below 0, set it to 0
        numTask = numTask<0? 0:numTask;
        //After BlueAstronaut is done with their tasks, meaning numTasks is equal to 0 (only for the first time),
        // - Print out “I have completed all my tasks”
        // - Then reduce BlueAstronaut’s susLevel by 50% (round down)
        if (this.numTask==0) {
            System.out.println("I have completed all my tasks");
            super.setSusLevel((int) (super.getSusLevel()*0.5));
        }
    }
    
    //equals(Object o)
    public boolean equals(Object o) {
        //Two BlueAstronauts are equal if they both have the same name, frozen, susLevel, numTasks, and taskSpeed
        if (o instanceof BlueAstronaut) {
            BlueAstronaut pB = (BlueAstronaut) o;
            boolean playerVarsEqual  = super.equals(o);
            boolean taskEq = this.numTask == pB.numTask;
            boolean speedEq = this.taskSpeed == pB.taskSpeed;
            return (playerVarsEqual && taskEq && speedEq);
        }
        else
            return false;
    }

    public String toString() {
        String s = super.toString() + " I have "+ this.numTask+" left over.";
        s = super.getSusLevel()>15? s.toUpperCase():s;
        return s;

    }

    public int getNumTask() {
        return numTask;
    }

    public void setNumTask(int numTask) {
        this.numTask = numTask;
    }

    public int getTaskSpeed() {
        return taskSpeed;
    }

    public void setTaskSpeed(int taskSpeed) {
        this.taskSpeed = taskSpeed;
    }
    
}
