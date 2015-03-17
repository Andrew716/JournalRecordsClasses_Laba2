/**
 * Created by Andrii on 3/13/2015.
 */
import java.util.*;

public class MainClass {

    public static void main(String [] args){
        System.out.println("0 Do well!");
        GregorianCalendar calendar1 = new GregorianCalendar(2014,12,12,20,32,54);
        GregorianCalendar calendar2 = new GregorianCalendar(2000,10,11,10,54,21);
                Journal journalReferences1 = new Journal();
        Journal journalReferences2 = new Journal();
        System.out.println("1 Do well!");
        Record record0 =  new Record(2014, 9, 25, 20, 45, 35, Importance.biggestImportance, "zzz", "zzz");
        Record record1 = new Record(2011, 1, 5, 20, 45, 35, Importance.lowImportance, "xxx", "xxx");
        Record record2 = new Record(2009, 9, 25, 20, 45, 35, Importance.middleImportance, "ccc", "ccc");
        Record record3 =  new Record(2018, 9, 25, 20, 45, 35, Importance.veryImportance, "vvv", "vvv");
        Record record4 = new Record(2001, 7, 23, 20, 45, 35, Importance.biggestImportance, "bbb", "bbbb");
        Record record5 = new Record(1999, 12, 25, 20, 45, 35, Importance.biggestImportance, "nnn", "nnn");
        journalReferences1.getRecords().add(record0);
        journalReferences1.getRecords().add(record1);
        journalReferences1.getRecords().add(record2);
        journalReferences1.getRecords().add(record3);
        journalReferences1.getRecords().add(record4);
        journalReferences1.getRecords().add(record5);
        journalReferences2.getRecords().add(record3);
        journalReferences2.getRecords().add(record4);
        /*
        for (int i = 0; i< journalReferences1.getRecords().size(); i++){
            System.out.println(journalReferences1.getRecords().get(i));
        }
        System.out.println();
        journalReferences1.sortByDate();
        System.out.println("2 Do well!");
        for (int i = 0; i< journalReferences1.getRecords().size(); i++){
            System.out.println(journalReferences1.getRecords().get(i));
        }
        System.out.println("Do well!");
        journalReferences1.remove(0,3);
        for (int i = 0; i< journalReferences1.getRecords().size(); i++){
            System.out.println(journalReferences1.getRecords().get(i));
        }
        */

    }
}
