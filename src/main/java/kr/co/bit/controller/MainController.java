package kr.co.bit.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class MainController {

    @RequestMapping(value = "/jblog",method = RequestMethod.GET)
    public String main(){
        return "/main/index.jsp";
    }
    @RequestMapping(value = "/myblog",method = RequestMethod.GET)
    public String myBlog(){
        return "/blog/blog-main.jsp";
    }
}
