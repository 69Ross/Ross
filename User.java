package cwk4;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class User {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Force> getDestroyedArray() {
        return destroyedArray;
    }

    public void setDestroyedArray(ArrayList<Force> destroyedArray) {
        this.destroyedArray = destroyedArray;
    }

    public ArrayList<Force> getActiveArray() {
        return activeArray;
    }

    public void setActiveArray(ArrayList<Force> activeArray) {
        this.activeArray = activeArray;
    }

    public ArrayList<Force> getDockedArray() {
        return dockedArray;
    }

    public void setDockedArray(ArrayList<Force> dockedArray) {
        this.dockedArray = dockedArray;
    }

    public void loseBattle(Force force, int loss){
        activeArray.remove(force);
        destroyedArray.add(force);
        warchest = warchest - loss;
    }
    public void deductWarchest(int loss){
        warchest = warchest - loss;
    }
    public void addWarchest(int gain){
        warchest = warchest + gain;
    }
    public int getWarchest() {
        return warchest;
    }

    public void setWarchest(int warchest) {
        this.warchest = warchest;
    }

    public boolean isInDock(String ref) {
        for (int i = 0; i < this.dockedArray.size(); i++) {
            if (dockedArray.get(i).getReference() == ref) {
                return true;
            }
        }
        return false;
    }

    public void addToDockedArray(Force force) {
        dockedArray.add(force);
    }

    public Battle getCurrentBattle() {
        return currentBattle;
    }

    public String getAllForces() {
        String s = "";
        s += "\n" + "\n ********************************* Docked Ships ********************************* \n";
        for (int i = 0; i < dockedArray.size(); i++) {
            s += "\n" + dockedArray.get(i).toString();
        }
        s += "\n" + "\n ********************************* Active Ships ********************************* \n";
        for (int i = 0; i < activeArray.size(); i++) {
            s += "\n" + activeArray.get(i).toString();
        }
        s += "\n" + "\n ******************************** Destroyed Ships ******************************** \n";
        for (int i = 0; i < destroyedArray.size(); i++) {
            s += "\n" + destroyedArray.get(i).toString();
        }
        return s;
    }

    private Force findForce(String ref) {
        for (Force force : this.dockedArray) {
            if (force.getReference() == ref) {
                return force;
            }
        }
        for (Force force : this.activeArray) {
            if (force.getReference() == ref) {
                return force;
            }
        }
        for (Force force : this.destroyedArray) {
            if (force.getReference() == ref) {
                return force;
            }
        }
        return null;
    }

    public String getForceDetails(String ref) {
        String s = "\n ***************************** Requested Force ****************************** \n ";
        for (Force force : this.dockedArray) {
            if (force.getReference() == ref) {
                s += "\n" + force.toString() + "\n This Force Is Docked \n";
            }
        }
        for (Force force : this.activeArray) {
            if (force.getReference() == ref) {
                s += "\n" + force.toString() + "\n This Force Is Active \n";
            }
        }
        for (Force force : this.destroyedArray) {
            if (force.getReference() == ref) {
                s += "\n" + force.toString() + "\n This Force Is Destroyed \n";
            }
        }
        return s;
    }

    public int activateForce(String ref) {
        int result = 0;
        if (this.findForce(ref) != null) {
            for (Force force : this.activeArray) {
                if (Objects.equals(force.getReference(), ref)) {
                    break;
                }}
            for (Force force : this.dockedArray) {
                if (force.getReference() == ref) {
                    if (this.warchest >= force.getType().getFees()) {
                        this.activeArray.add(force);
                        this.dockedArray.remove(force);
                        this.warchest -= force.getType().getFees();
                            result = 0;}
                        else {
                            result = 2;} break;
                    }
                    else {
                        result = 1;}
                }
            }
        return result;
        }



    public Force findSuitableForce(String type) {
        ArrayList<Force> suitableArray = new ArrayList<>();

        if (type.equals("Fight")){
            for (Force force : activeArray) {
                if (force.getType() instanceof Starship) {
                    suitableArray.add(force);}
                if (force.getType() instanceof WarBird) {
                    suitableArray.add(force);}}}

        else if (type.equals("Ambush")){
            for (Force force : activeArray) {
                if (force.getType() instanceof Wing) {
                    suitableArray.add(force);}
                if (force.getType() instanceof WarBird) {
                    if (force.hasCloaking()) {
                        suitableArray.add(force);}}}}

        else if (type.equals("Skirmish")){
                for (Force force : activeArray) {
                    if (force.getType() instanceof Starship) {
                        suitableArray.add(force);}
                    if (force.getType() instanceof Wing) {
                        suitableArray.add(force);}}}

        if(suitableArray.size() < 1){return null;}
        else {int i = new Random().nextInt(suitableArray.size());
        Force Chosen = suitableArray.get(i);
        return Chosen;}}

    public void setCurrentBattle(Battle currentBattle) {
        this.currentBattle = currentBattle;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isDefeated(){
        if(warchest <= 0){
            if (activeArray.size() == 0){
                return true;
            }else{return false;}
        }return false;
    }

    private String name;
    private ArrayList<Force> destroyedArray;
    private ArrayList<Force> activeArray;
    private ArrayList<Force> dockedArray;
    private int warchest;
    private Battle currentBattle;
    private String role;


    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", destroyedArray=" + destroyedArray +
                ", activeArray=" + activeArray +
                ", dockedArray=" + dockedArray +
                ", warchest=" + warchest +
                ", currentBattle=" + currentBattle +
                ", role='" + role + '\'' +
                '}';
    }

    public User(String name) {
        this.destroyedArray = new ArrayList<>();
        this.activeArray = new ArrayList<>();
        this.dockedArray = new ArrayList<>();
        this.warchest = 100000;
        this.currentBattle = null;
        this.role = "admiral";
        this.name = name;
    }
}

