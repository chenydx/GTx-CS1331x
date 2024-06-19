public abstract class Player implements Comparable<Player>{
    
    //Variables
    private String name;
    private int susLevel;
    private boolean frozen;
    private static Player[] players;

    //Constructor
    public Player(String name, int susLevel) {
        this.name = name;
        this.susLevel = susLevel>0? susLevel:0;
        if (players == null) {
            players = new Player[1];
            players[0] = this;
        } else {
            int len = players.length;
            Player[] temp = players;
            players = new Player[len+1];
            for (int i=0; i<len;i++) 
                players[i] = temp[i];
            players[len] = this;
        }
    }

    //Methods
    public abstract void emergencyMeeting();

    public boolean isGameOver() {
        int num_Imposter = 0;
        int num_crewmate = 0;
        for (Player p:players) {
            if (p instanceof Impostor & !p.frozen) 
                num_Imposter++;
            else if (p instanceof Crewmate & !p.frozen)
                num_crewmate++;
        }
        if (num_Imposter ==0)
            System.out.println("Crewmates Win!");
        else if (num_Imposter>=num_crewmate)
            System.out.println("Impostors Win!");
        else
            return false;
        return true;
    }


    @Override
    public int compareTo(Player p) {
        return this.susLevel - p.susLevel;
    }

    public boolean equals(Object o) {
        if (o instanceof Player) {
            Player player = (Player) o;
            return (this.name.equals(player.name) && this.susLevel == player.susLevel && this.frozen == player.frozen);
        }
        return false;   
    }

    public String toString() {
        String frozStr = isFrozen()? "frozen":"not frozen";
        return "My name is "+this.name+"and I have a suslevel of "+this.susLevel+". I am currently "+frozStr+".";
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getSusLevel() {
        return susLevel;
    }


    public void setSusLevel(int susLevel) {
        this.susLevel = susLevel>0? susLevel:0;
    }


    public boolean isFrozen() {
        return frozen;
    }


    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    public static Player[] getPlayers() {
        return players;
    }
}
