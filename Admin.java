public class Admin {

    private String startDate;
    private String endDate;
    private String time;
    private String compulsory;
    private String venue;
    private String courseName;
    private String lecturer;
    
    private int duration;
    private int repeatFrequency;
    private int maxCapacity;
    private int sesID;
    
    
    private String getCourseName(){
    	return courseName;
    }

    public String getTime(){
    	return time;
    }
    
    public String getStartDate(){
        return startDate;
    }
    
    public String getEndDate(){
    	return endDate;
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
    public void setSesID(int sessionID){
         this.sesID = sesID;
    }
    private void setCourseName(String courseName){
    	this.courseName = courseName;
    }
    public void setStartDate(String startDate){
        this.startDate = StartDate;
    } 
    public void setEndDate(String endDate){
    	this.endDate = endDate;
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
