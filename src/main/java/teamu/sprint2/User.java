package teamu.sprint2;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Date;
import java.util.ArrayList;

public class User {
	
	private List<Session> sessions = new ArrayList<Session>();
	private String name;
	
	public User(List<Session> sessions, String name){
		this.name = name;
		for (Session session: sessions){
			if (session.getCompulsory() == "1")
				this.sessions.add(session);
		}
	}
	
	public User(SessionList sessions, String name){
		this.name = name;
		for (Session session: sessions.getAll()){
			if (session.getCompulsory() == "1")
				this.sessions.add(session);
		}
	}
	
	public List<Session> filter(String filter){
		if(filter=="All")
			return all();
		if(filter=="Week")
			return week();
		if(filter=="Today")
			return daily();
		return null;
	}
	
	private List<Session> all(){
		return sessions;
	}
	
	private	List<Session> week(){
		Date current = new Date();
		Calendar cal = new GregorianCalendar();
		Calendar cal_7 = new GregorianCalendar();
		cal.setTime(current);
		cal_7.setTime(current);
		int day = cal.getFirstDayOfWeek();
		cal_7.setFirstDayOfWeek(cal.getFirstDayOfWeek() + 7);
		
		List<Session> list = new ArrayList<Session>();
		for(Session s: sessions){
			Calendar temp = new GregorianCalendar();
			temp.setTime( new Date(s.getStartDate()) );
			if (current.after(new Date(s.getStartDate()) ) && 
			    current.before(new Date(s.getEndDate())) &&
			    s.getRepeated()>0 ){
				list.add(s);
			}else if(temp.compareTo(cal)>0 &&
			         temp.compareTo(cal_7)<0){
				list.add(s);
			}
		}
		return list;
	}
	
	private	List<Session> daily(){
		Date current = new Date();
		
		List<Session> list = new ArrayList<Session>();
		for(Session s: sessions){
			if(current.compareTo(new Date(s.getStartDate())) == 0)
				list.add(s);
		}
		return list;
	}
}
