package teamu.sprint2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class SessionController {

    @RequestMapping("/admin/sessions")
    public String sessionList(Model model) {
        ArrayList<Session> sessions = new ArrayList<Session>();
        for (String name : new String[]{"PSD3", "AP3"}) {
            Session s = new Session();
            s.setName(name);
            sessions.add(s);
        }

        model.addAttribute("sessions", sessions);
        return "sessions";
    }

    @RequestMapping("/admin/sessions/create")
    public String createSession(Model model) {
        // TODO implement
        return "createSession";
    }

    @RequestMapping("/user/sessions")
    public String sessionList(@RequestParam(value="username") String username, Model model) {
        return "userSessions";
    }


}
