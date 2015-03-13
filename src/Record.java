/**
 * Created by Andrii on 3/13/2015.
 */
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.lang.String;

public class Record {


    private Date hiredate;
    private Importance importance;
    private String source;
    private String message;  // message about exception


    final static String regex = "^((\\d{4}-?\\d{2}-?\\d{2}\\s\\d{2}:?\\d{2}:?\\d{2})?\\s\\s\\s(.?!?!!!?!!!!!?)?\\s\\s(\\w{5})?\\s\\s(\\w{6})?)$";
    final static Pattern pattern = Pattern.compile(regex);




    public Date getHiredate() {

        return hiredate;
    }

    public Importance getImportance() {

        return importance;
    }

    public String getSource() {

        return source;
    }

    public String getMessage() {

        return message;
    }

    public void setHiredate(Date hiredate) {

        this.hiredate = hiredate;
    }

    public void setImportance(Importance importance) {

        this.importance = importance;
    }

    public void setSource(String source) {

        this.source = source;
    }

    public void setMessage(String message) {

        this.message = message;
    }

    public  Record(int year, int month, int day, int hours, int minutes, int seconds, Importance importance, String source, String message) {

        GregorianCalendar calendar = new GregorianCalendar(year,month-1,day,hours,minutes,seconds);

        this.hiredate = calendar.getTime();
        this.importance = importance;
        this.source = source;
        this.message = message;


    }

    public  Record(String information) {

        Matcher matcherForInformation = pattern.matcher(information);
        if (matcherForInformation.find()) {
            String informationForDate = matcherForInformation.group(0);
            SimpleDateFormat goodFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                this.hiredate = goodFormat.parse(informationForDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String s = matcherForInformation.group(1);
            if (s.equals(".")) {
                this.importance = Importance.lowImportance;

            } else if (s.equals("!")) {
                this.importance = Importance.middleImportance;

            } else if (s.equals("!!!")) {
                this.importance = Importance.veryImportance;

            } else if (s.equals("!!!!!")) {
                this.importance = Importance.biggestImportance;

            }


        }

        this.source = matcherForInformation.group(2);
        this.message = matcherForInformation.group(3);


    }







    @Override
    public String toString(){

        return  hiredate + "    " + importance+ "    " + source + "     " + message;
    }



}
