/**
 * Created by Andrii on 3/13/2015.
 */
import java.util.*;

public class Journal  {
    public   List<Record>  records = new ArrayList<Record>();



    public  List<Record> getRecords() {
        return records;
    }

    // add a record
    public   void add(Record r){
        records.add(r);
    }

    // add all records from another journal
    public void add(Journal j){
        records.addAll(j.getRecords());
    }

    //remove a record
    public void remove(Record r){
        records.remove(r);
    }

    //remove a record by serial number
    public void remove(int index){
        records.remove(index);
    }

    //remove a record by serial number
    public void remove(int fromIndex, int toIndex){
        for (int i = 0; i <= toIndex - fromIndex; i++){
            records.remove(fromIndex);
        }
    }

    //remove all records
    public void removeAll(){
        records.removeAll(getRecords());
    }

    //filtration(returns object Journal which safe reference only those records, text appointment toString equals this string)
    public Journal filter(String s){
        for (int i = 0; i<records.size(); i++){
            if (records.get(i).toString().equals(s)){
                return Journal.this;
            }else return null;
        }
        return null;
    }

    //filtration(returns object Journal which safe reference only those records, which happened from fromDate to toDate)
    public Journal filter(Date fromDate, Date toDate){
        for (int i = 0; i<records.size(); i++){
            if (records.get(i).getHiredate().before(fromDate) && records.get(i).getHiredate().after(toDate)){
                return Journal.this;
            }else return null;
        }
        return null;
    }

    //sort objects by date events
    public  void sortByDate(){
        Collections.sort(records,new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                return o1.getHiredate().compareTo(o2.getHiredate());
            }
        });
    }
    //sort objects by (importance,date)
    public void sortByImportanceDate(){
        Collections.sort(records, new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                Importance tempForImportance1 = ((Record) o1).getImportance();
                Importance tempForImportance2 = ((Record) o2).getImportance();
                int sCompare = tempForImportance1.compareTo(tempForImportance2);
                if (sCompare != 0){
                    return sCompare;
                }else {
                    Date tempForDate1 = ((Record) o1).getHiredate();
                    Date tempForDate2 = ((Record) o2).getHiredate();
                    return tempForDate1.compareTo(tempForDate2);
                }
            }
        });
    }

    //sort objects by (importance,source,date)
    public void sortByImportanceSourceDate(){
        Collections.sort(records, new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                Importance tempForImportance1 = ((Record) o1).getImportance();
                Importance tempForImportance2 = ((Record) o2).getImportance();
                int sCompare1 = tempForImportance1.compareTo(tempForImportance2);
                if (sCompare1 != 0 ){
                    return sCompare1;
                } else {
                    String tempForSource1 = ((Record) o1).getSource();
                    String tempForSource2 = ((Record) o2).getSource();
                    int sCompare2 = tempForSource1.compareTo(tempForSource2);
                    if (sCompare2 != 0 ){
                        return sCompare2;
                    } else {
                        Date tempForDate1 = ((Record) o1).getHiredate();
                        Date tempForDate2 = ((Record) o2).getHiredate();
                        return tempForDate1.compareTo(tempForDate2);
                    }
                }
            }
        });
    }

    //sort objects by (source,date)
    public void sortBySourceDate(){
        Collections.sort(records, new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                String tempForSource1 = ((Record) o1).getSource();
                String tempForSource2 = ((Record) o2).getSource();
                int sCompare = tempForSource1.compareTo(tempForSource2);
                if (sCompare != 0){
                    return sCompare;
                } else {
                    Date tempForDate1 = ((Record) o1).getHiredate();
                    Date tempForDate2 = ((Record) o2).getHiredate();
                    return tempForDate1.compareTo(tempForDate2);
                }
            }
        });
    }
}

