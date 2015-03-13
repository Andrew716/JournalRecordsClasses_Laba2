/**
 * Created by Andrii on 3/13/2015.
 */
public enum Importance {

    lowImportance(1,"  .  "),
    middleImportance(2,"  !  "),
    veryImportance(3," !!! "),
    biggestImportance(4,"!!!!!");

    private int numberOfImportance;
    private String signOfImportance;

    Importance( int numberOfImportance , String signOfImportance ){
        this.numberOfImportance = numberOfImportance;
        this.signOfImportance = signOfImportance;

    }

    public int getNumberOfImportance(){

        return  numberOfImportance;
    }

    public String getSignOfImportance(){

        return signOfImportance;
    }
}

