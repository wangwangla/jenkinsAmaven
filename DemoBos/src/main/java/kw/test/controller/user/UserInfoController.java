package kw.test.controller.user;

import io.jboot.web.controller.JbootController;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.limitation.LimitRenderType;
import io.jboot.web.limitation.annotation.EnableConcurrencyLimit;
import io.jboot.web.limitation.annotation.EnablePerIpLimit;
import io.jboot.web.limitation.annotation.EnablePerUserLimit;
import io.jboot.web.limitation.annotation.EnableRequestLimit;
import kw.test.model.User;
import kw.test.service.UserService;

import javax.inject.Inject;
import java.util.List;

/**
 * auther   kangwang
 */
@RequestMapping("/userInfo")
public class UserInfoController extends JbootController {

    @Inject
    private UserService userService;

    public void findUserInfo(){
        List<User> list = userService.findAll();
        setAttr("user",list);
        renderText("这是访问成功页面");
    }
    /**
     * 所有的请求，每1秒钟只能访问一次
     */
    @EnableRequestLimit(rate = 1)
    public void request() {
        System.out.println("===========================");
        renderText("每秒访问一次页面！");
    }

    /**
     * 所有的请求，并发量为1个
     */
    @EnableConcurrencyLimit(rate = 1)
    public void con() {
        try {
            System.out.println("===========================");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        renderText("并发量为1");
    }

    /**
     * 所有的请求，每1秒钟只能访问一次
     * 被限制的请求，自动跳转到 /limitation/request2
     */
    @EnableRequestLimit(rate = 1, renderType = LimitRenderType.REDIRECT, renderContent = "/userInfo/request2")
    public void request1() {
        System.out.println("===========================");
        renderText("request1() render ok");
    }

    public void request2() {
        System.out.println("===========================");
        renderText("request2() render ok");
    }



    /**
     * 每个用户，每5秒钟只能访问一次
     */
    @EnablePerUserLimit(rate = 0.2)
    public void user() {
        System.out.println("===========================");
        renderText("每个用户，每5秒钟只能访问一次");
    }

    /**
     * 每个用户，每5秒钟只能访问一次
     * 被限制的请求，渲染文本内容 "被限制啦"
     */
    @EnablePerUserLimit(rate = 0.2, renderType = LimitRenderType.TEXT, renderContent = "被限制啦")
    public void user1() {
        System.out.println("===========================");
        renderText("user1() render ok");
    }


    /**
     * 每个IP地址，每5秒钟只能访问一次
     */
    @EnablePerIpLimit(rate = 0.2)
    public void ip() {
        System.out.println("===========================");
        renderText(" 每个IP地址，每5秒钟只能访问一次");
    }
}
