package cwk4;

public class Main {
    public static void main(String[] args) {
        SpaceWars spaceWars = new SpaceWars("Rick");

        /**System.out.println(spaceWars.getAllBattles()); //Works
        //System.out.println(spaceWars.getBattle(3)); //Works
        //System.out.println(spaceWars.getASFleet()); //Works
        //System.out.println(spaceWars.getAllForces()); //Works
        //System.out.println(spaceWars.getForcesInDock()); //Works
        //System.out.println(spaceWars.getForceDetails("SS7")); //Works
        //System.out.println(spaceWars.getDestroyedForces()); //Works
        //System.out.println(spaceWars.getWarchest()); **/
        spaceWars.activateForce("WB3");
        spaceWars.activateForce("WB5");
        spaceWars.activateForce("WB9");
        spaceWars.activateForce("IW1");
        spaceWars.activateForce("IW4");
        spaceWars.activateForce("IW10");
        spaceWars.activateForce("SS2");
        spaceWars.activateForce("SS6");
        spaceWars.activateForce("SS7");
        System.out.println(spaceWars.getForcesInDock());
        System.out.println(spaceWars.getASFleet());
        System.out.println(spaceWars.doBattle(3));
    }
}


