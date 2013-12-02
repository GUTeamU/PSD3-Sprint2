package teamu.sprint2;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class Session {

    private static final DateFormat DATE = DateFormat.getDateInstance(DateFormat.SHORT, Locale.UK);

    private String time;
    private String name;
    private String lecturer;
    private String compulsory;
    private String venue;
    private Date startDate;
    private Date endDate;

    private int duration;
    private int repeated; //Again or boolean?
    private int maxCapacity;


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        try {
            this.startDate = DATE.parse(startDate);
        } catch (ParseException e) {
        }
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getCompulsory() {
        return compulsory;
    }

    public void setCompulsory(String compulsory) {
        this.compulsory = compulsory;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getRepeated() {
        return repeated;
    }

    public void setRepeated(int repeated) {
        this.repeated = repeated;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEndDate(String endDate) {
        try {
            this.endDate = DATE.parse(endDate);
        } catch (ParseException e) {
        }
    }

    public Date getEndDate() {
        return endDate;
    }

}
