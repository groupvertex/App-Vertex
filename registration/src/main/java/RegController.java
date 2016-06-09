import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by user on 08.06.2016.
 */



    @Controller
    @RequestMapping(value = "/register")
    public class RegController {

        @RequestMapping(method = RequestMethod.GET)
        public String viewRegistration(Map<String, Object> model) {
            User userForm = new User();
            model.put("userForm", userForm);
            return "Registration";
        }

        @RequestMapping(method = RequestMethod.POST)
        public String processRegistration(@ModelAttribute("userForm") User user,
                                          Map<String, Object> model) {


            return "RegistrationSuccess";
        }
    }


