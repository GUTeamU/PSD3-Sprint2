public class Admin {

    private String date;
    private String time;
    private int duration;
    private int repeatFrequency;
    private String lecturer;
    private int maxAttendance;
    private String compulsory;
    private String venue;
    private int sessionID;
    
    public String getTime(){
    	return time;
    }
    
    public String getDate(){
        return date;
    }
    
    public int getSesID(){
     	return sesID;
    }
    
    public int getDuration(){
        return duration;
    }
    public int getRepeated(){
        return repeated;
    }
    public String getLecturer(){
        return lecturer;
    }
    public int getMaxCapacity(){
        return maxCapacity;
    }
    public String getCompulsory(){ //Or boolean?
        return compulsory;
    }
    public String getVenue(){
        return venue;
    }
    
    
    public void setSessionID(int sessionID){
            this.sessionID = sessionID;
    }
    public void setDate(String date){
        this.date = date;
    } 
    public void setTime(String time){
        this.time = time;
    }
    public void setDuration(int duration){
        this.duration = duration;
    }
    public void setRepeated(int repeated){
        this.repeated = repeated;
    }
    public void setLecturer(String lecturer){
        this.lecturer = lecturer;
    }
    public void setMaxCapacity(int maxCapacity){
        this.maxCapacity = maxCapacity;
    }
    public void setCompulsory(String compulsory){
        this.compulsory = compulsory;
    }
    public void setVenue(String venue){
        this.venue = venue;
    }
}
