package kw.test.controller.user;

import com.jfinal.core.paragetter.Para;
import io.jboot.web.controller.JbootController;
import io.jboot.web.controller.annotation.RequestMapping;
import kw.test.model.User;

/**
 * auther   kangwang
 */
@RequestMapping("/user")
public class LoginController extends JbootController {
    public void login(@Para("")User user){

        user.save();
        renderText("sssssssssssssssss");




    }
}
