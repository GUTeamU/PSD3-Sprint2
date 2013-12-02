package teamu.sprint2;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Date;
import java.util.ArrayList;
import java.util.Locale;

public class User {

    private List<Session> sessions = new ArrayList<Session>();
    private String name;

    public User(List<Session> sessions, String name){
        this.name = name;
        for (Session session: sessions){
            if (session.getCompulsory().equals("1"))
                this.sessions.add(session);
        }
    }

    public User(SessionList sessions, String name){
        this.name = name;
        for (Session session: sessions.getAll()){
            if (session.getCompulsory().equals("1"))
                this.sessions.add(session);
        }
    }

    public String getName(){
        return name;
    }

    public List<Session> filter(String filter){
        if (filter == null) {
            filter = "";
        }
        switch(filter.toLowerCase()) {
            case "week":
                return week();
            case "today":
                return daily();
            default:
                return all();
        }
    }

    private List<Session> all(){
        return sessions;
    }

    private	List<Session> week(){
        // get today and clear time of day
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0); // ! clear would not reset the hour of day !
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);

        // get start of this week in milliseconds
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());

        Date weekStart = cal.getTime();

        // start of the next week
        cal.add(Calendar.WEEK_OF_YEAR, 1);
        Date weekEnd = cal.getTime();

        List<Session> list = new ArrayList<Session>();
        for(Session s: sessions){
            Date compare = s.getStartDate();
            if (compare.getYear() >= weekStart.getYear()
                && compare.getYear() <= weekEnd.getYear()
                && compare.getMonth() >= weekStart.getMonth()
                && compare.getMonth() <= weekEnd.getMonth()
                && compare.getDate() >= weekStart.getDate()
                && compare.getDate() <= weekEnd.getDate()) {
                    list.add(s);
                }
        }
        return list;
    }

    @Override
    public String toString() {
        return this.name;
    }

    private	List<Session> daily(){
        Date current = new Date();

        List<Session> list = new ArrayList<Session>();
        for(Session s: sessions){
            Date compare = s.getStartDate();
            if (current.getYear() == compare.getYear()
                && current.getMonth() == compare.getMonth()
                && current.getDay() == compare.getDay()) {
                    list.add(s);
                }
        }
        return list;
    }
}
