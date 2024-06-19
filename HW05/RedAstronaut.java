import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {
    
    //Variables
    private String skill;

    public static final int DEFAULT_SUSLEVEL = 15;
    public static final String DEFAULT_SKILL = "experienced";

    //Constructors
    public RedAstronaut(String name) {
        this(name, DEFAULT_SUSLEVEL, DEFAULT_SKILL);
    }

    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        this.skill = skill.toLowerCase();
    }

    //Methods
    public void emergencyMeeting() {
        if (super.isFrozen())
            return;
        Player[] players = Player.getPlayers();
        Arrays.sort(players);
        int sus1st_idx = players.length-1;
        Player sus1st = players[sus1st_idx];
        while (sus1st.isFrozen() || super.equals(sus1st)) {
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

    @Override
    public void freeze(Player p) {
        if (super.isFrozen() || p instanceof Impostor || p.isFrozen())
            return;
        if (super.getSusLevel() < p.getSusLevel())
            p.setFrozen(true);
        else
            super.setSusLevel(2*super.getSusLevel());
        super.isGameOver();
    }

    @Override
    public void sabotage(Player p) {
        if (super.isFrozen() || p instanceof Impostor || p.isFrozen())
            return;
        if (super.getSusLevel()<20)
            p.setSusLevel((int) (p.getSusLevel()*1.5));
        else
            p.setSusLevel((int) (p.getSusLevel()*1.25));
    }

    public boolean equals(Object o) {
        //Two Red are equal if they both have the same name, frozen, susLevel, and skill
        if (o instanceof RedAstronaut) {
            RedAstronaut pR = (RedAstronaut) o;
            boolean playerVarsEqual  = super.equals(o);
            boolean skillEq = this.skill.equals(pR.skill);
            return (playerVarsEqual && skillEq);
        }
        else
            return false;
    }

    public String toString() {
        String s = super.toString() + " I am an "+ this.skill +" player!";
        s = super.getSusLevel()>15? s.toUpperCase():s;
        return s;
    }

    public String getSkill() {
        return skill;
    }
        
    public void setSkill(String skill) {
         this.skill = skill;
    }

}
