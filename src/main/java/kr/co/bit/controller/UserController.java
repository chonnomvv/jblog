package kr.co.bit.controller;


import kr.co.bit.service.UsersServices;
import kr.co.bit.vo.UsersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/jblog/user")
public class UserController {

    @Autowired
    private UsersServices usersServices;

    @Autowired
    private BlogController blogController;

    @RequestMapping(value = "/joinform",method = RequestMethod.GET)
    public String joinform(){
        return "/user/joinForm.jsp";
    }

    @RequestMapping(value = "/join",method = RequestMethod.POST)
    public String join(@ModelAttribute UsersVO usersVO){
        usersServices.usersJoin(usersVO);
        return "/user/joinSuccess.jsp";
    }

    @ResponseBody
    @RequestMapping(value = "/idCheck",method = RequestMethod.POST)
    public boolean idCheck(@RequestParam("id") String id){
        return usersServices.checkId(id);
    }

    @RequestMapping(value = "/loginform",method = RequestMethod.GET)
    public String loginForm(){
        return "/user/loginForm.jsp";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@ModelAttribute UsersVO usersVO, HttpSession session){
        UsersVO authUser = usersServices.login(usersVO);
        if(authUser!=null){
//            blogController.main_by_login(authUser);
            session.setAttribute("authUser",authUser);
            return "redirect:/jblog";
        } else{
            return "redirect:/user/loginform";
        }


    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/jblog";
    }
}
