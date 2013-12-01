package teamu.sprint2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.ArrayList;

@Controller
public class SessionController {
    
    private List<Session> sessions;
    private List<User> users;
        
    public SessionController() {
        sessions = new ArrayList<Session>();
        for (String name : new String[]{"PSD3", "AP3", "PL3", "TP3", "IS3"}) {
            Session s = new Session();
            s.setName(name);
            sessions.add(s);
        }
    }

    @RequestMapping("/admin/sessions")
    public String sessionList(Model model) {
        model.addAttribute("sessions", this.sessions);
        return "sessions";
    }

    @RequestMapping(value="/admin/sessions/create", method=RequestMethod.POST)
    public String postCreateSession(@ModelAttribute("session") Session session) {
        this.sessions.add(session);
        return "redirect:create";
    }
    
    @RequestMapping(value="/admin/sessions/create", method=RequestMethod.GET)
    public String getCreateSession(Model model) {
        return "createSession";
    }

    @RequestMapping("/user/sessions")
    public String sessionList(@RequestParam(value="username") String username, Model model) {
        return "userSessions";
    }


}
