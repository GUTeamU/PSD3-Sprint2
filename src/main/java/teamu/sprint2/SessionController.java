package teamu.sprint2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.ArrayList;

@Controller
public class SessionController {

    private static final String SESSION_DATA = "Sessions.csv";
    
    private SessionList sessions;
    private List<User> users;
        
    public SessionController() {
        this.sessions = new SessionList(SESSION_DATA);
        users = new ArrayList<User>();
        this.users.add(new User(sessions, "Al"));
    }

    @RequestMapping("/admin/sessions")
    public String sessionList(Model model) {
        model.addAttribute("sessions", this.sessions.getAll());
        return "sessions";
    }

    @RequestMapping(value="/admin/sessions/create", method=RequestMethod.POST)
    public String postCreateSession(@ModelAttribute("session") Session session, BindingResult result) {
        this.sessions.add(session);
        return "redirect:create";
    }
    
    @RequestMapping(value="/admin/sessions/create", method=RequestMethod.GET)
    public String getCreateSession(Model model) {
        return "createSession";
    }

    @RequestMapping("/users/sessions")
    public String sessionList(@RequestParam(value="username", required=false) String username, 
                              @RequestParam(value="filter", required=false) String filter, 
                              Model model) {
        for(User u: users){
            if(u.getName().equalsIgnoreCase(username)){
                model.addAttribute("sessions", u.filter(filter));
                model.addAttribute("username", u);
            }
        }
        model.addAttribute("filter", filter == null ? "all" : filter.toLowerCase());
        return "userSessions";
    }


}
