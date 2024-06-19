public class Gameplay {
    public static void main(String[] args) {
        //Create a BlueAstronaut with the following fields:
        //name = “Bob”, susLevel = 20, numTasks = 6, taskSpeed = 30
        BlueAstronaut bobBlueAstro = new BlueAstronaut("Bob",20,6,30);
        //Create a BlueAstronaut with the following fields:
        //name = “Heath”, susLevel = 30, numTasks = 3, taskSpeed = 21
        BlueAstronaut heathBlueAstro = new BlueAstronaut("Heath",30,3,21);
        //Create a BlueAstronaut with the following fields:
        //name = “Albert”, susLevel = 44, numTasks = 2, taskSpeed = 0
        BlueAstronaut albertBlueAstro = new BlueAstronaut("Albert",44,2,0);
        //Create a BlueAstronaut with the following fields:
        //name = “Angel”, susLevel = 0, numTasks = 1, taskSpeed = 0
        BlueAstronaut angelBlueAstro = new BlueAstronaut("Angel",0,1,0);
        //Create a RedAstronaut with the following fields:
        //name = “Liam”, susLevel = 19, skill = "experienced"
        RedAstronaut liamRedAstro = new RedAstronaut("Liam",19,"experienced");
        //Create a RedAstronaut with the following fields:
        //name = “Suspicious Person”, susLevel = 100, skill = "expert"
        RedAstronaut susRedAstro = new RedAstronaut("Suspicious Person",100,"expert");


        //Have RedAstronaut Liam sabotage BlueAstronaut Bob. After the sabotage:
        //Bob should have: susLevel = 30, frozen = false
        liamRedAstro.sabotage(bobBlueAstro);
        System.out.println(bobBlueAstro);
        
        //Have RedAstronaut Liam freeze RedAstronaut Suspicious Person:
        //Nothing should happen
        liamRedAstro.freeze(susRedAstro);
        System.out.println(susRedAstro);

        //Have RedAstronaut Liam freeze BlueAstronaut Albert. After the freeze:
        //Liam should have: susLevel = 19
        //Albert is now frozen
        liamRedAstro.freeze(albertBlueAstro);
        System.out.println(liamRedAstro);
        System.out.println(albertBlueAstro);

        //Have BlueAstronaut Albert call an emergency meeting:
        //Nothing should happen since he is frozen
        albertBlueAstro.emergencyMeeting();

        //Have RedAstronaut Suspicious Person call an emergency meeting:
        //This will result in a tie between Bob and Heath, so nothing should happen
        susRedAstro.emergencyMeeting();
        System.out.println(bobBlueAstro);
        System.out.println(heathBlueAstro);

        //Have BlueAstronaut Bob call an emergency meeting:
        //Suspicious Person should have: frozen = true
        bobBlueAstro.emergencyMeeting();
        System.out.println(susRedAstro);

        //Have BlueAstronaut Heath complete tasks:
        //Heath should have: numTasks = 1
        heathBlueAstro.completeTask();
        System.out.println(heathBlueAstro);

        //Have BlueAstronaut Heath complete tasks:
        //“I have completed all my tasks” should be printed to console
        //Heath should have: numTasks = 0, susLevel = 15
        heathBlueAstro.completeTask();
        System.out.println(heathBlueAstro);

        //Have BlueAstronaut Heath complete tasks:
        //Nothing should happen
        heathBlueAstro.completeTask();

        //Have RedAstronaut Liam freeze Angel:
        //Angel should have: frozen = false
        //Liam should have: susLevel = 38
        liamRedAstro.freeze(angelBlueAstro);
        System.out.println(angelBlueAstro);
        System.out.println(liamRedAstro);

        //Have RedAstronaut Liam sabotage Bob twice:
        //Bob should have: susLevel = 46 (30 -> 37 -> 46)
        liamRedAstro.sabotage(bobBlueAstro);
        liamRedAstro.sabotage(bobBlueAstro);
        System.out.println(bobBlueAstro);

        //Have RedAstronaut Liam freeze Bob:
        //Bob should have: frozen = true
        liamRedAstro.freeze(bobBlueAstro);
        System.out.println(bobBlueAstro);

        //Have BlueAstronaut Angel call emergency meeting:
        //Liam should have: frozen = true
        //“Crewmates win!” should be printed to console
        angelBlueAstro.emergencyMeeting();
        System.out.println(liamRedAstro);


    }
}
