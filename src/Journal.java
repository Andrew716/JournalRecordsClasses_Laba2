/**
 * Created by Andrii on 3/13/2015.
 */
import java.util.*;

public class Journal  {
    public   List<Record>  records = new ArrayList<Record>();
    public List<Record> getRecords() {
        return records;
    }
    // додавання запису
    public   void add(Record r){
        records.add(r);
    }

    // додавання всіх записів з іншого журналу
    public void add(Journal j){
        records.addAll(j.getRecords());
    }

    //видалення запису
    public void remove(Record r){
        records.remove(r);
    }

    //видалення запису за порядковим номером
    public void remove(int index){
        records.remove(index);
    }

    //видалення запису за порядковим номером
    public void remove(int fromIndex, int toIndex){
        for (int i = 0; i < records.size(); i++){
            if( i > fromIndex && i < toIndex){
                records.remove(i);
            }
        }
    }

    // видалення всіх записів
    public void removeAll(){
        records.removeAll(getRecords());
    }

    // фільтрації (повертає об'єкт Journal, в якому зберігаються посилання тільки на ті записи, текстове призначення яких (toString()) містить заданий рядок
    public Journal filter(String s){
        for (int i = 0; i<records.size(); i++){
            if (records.get(i).toString().equals(s) || records.get(i).toString().equals(s)){
            }
        }
        return null;
    }

    // фільтрація(повертає об'єкт Journal, в якому збеігаються посилання тільки на записи о подіях, які відбулися у вказаний інтервал часу)
    public Journal filter(Date fromDate, Date toDate){
        for (int i = 0; i<records.size(); i++){
            if (records.get(i).getHiredate().before(fromDate) && records.get(i).getHiredate().after(toDate)){
            }
        }
        return null;
    }

    // сортування за датою подій
    public  void sortByDate(){
        Collections.sort(records,new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                return o1.getHiredate().compareTo(o2.getHiredate());
            }
        });
    }
    // сортування за (важливість, дата)
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

    // сортування за (важливітсь, джерело, дата)
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

    // сортування за (джерело, дата)
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

