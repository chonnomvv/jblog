package kr.co.bit.controller;


import kr.co.bit.dao.BlogDAO;
import kr.co.bit.service.BlogServices;
import kr.co.bit.service.CategoryService;
import kr.co.bit.service.PostServices;
import kr.co.bit.vo.BlogVO;
import kr.co.bit.vo.CategoryVO;
import kr.co.bit.vo.UsersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BlogController {

    @Autowired
    private BlogServices blogServices;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PostServices postServices;


    @RequestMapping(value = "/jblog/{id}",method = RequestMethod.GET)
    public String main(@PathVariable String id,Model model,@RequestParam(value="cateNo",required = false,defaultValue = "-1" )int cateNo){
        BlogVO blogVO = blogServices.getList(id);
        System.out.println("/jblog/{id}에 넘어온 cateNo = "+cateNo);
        model.addAttribute("blogVO",blogVO);
        model.addAttribute("defaultCateNo",cateNo);
        model.addAttribute("postList",postServices.postList(cateNo,id));
            return "/blog/blog-main.jsp";

    }
    @RequestMapping(value = "/jblog/blog/{id}/manage")
    public String manage(@PathVariable String id,Model model){
        BlogVO blogVO = blogServices.getList(id);
        model.addAttribute("blogVO",blogVO);

        return "/blog/admin/blog-admin-basic.jsp";
    }

    @RequestMapping(value = "/jblog/blog/{id}/modify")
    public String modify(@RequestParam("file") MultipartFile file, @RequestParam("blogTitle")String blogTitle,@PathVariable String id,Model model){
        BlogVO blogVO = blogServices.getList(id);
        model.addAttribute("blogVO",blogVO);
        blogServices.modify(file, blogTitle,id);
        return "redirect:/jblog/"+id;
    }
    @RequestMapping(value = "/jblog/blog/{id}/manage_cate")
    public String manage_cate(@PathVariable String id, Model model){

        BlogVO blogVO = blogServices.getList(id);
        List<CategoryVO> categoryVO = categoryService.getList(id);
        model.addAttribute("blogVO",blogVO);
        model.addAttribute("categoryVO",categoryVO);
        return "/blog/admin/blog-admin-cate.jsp";
    }

    @RequestMapping(value = "/jblog/blog/{cateNo}/getPost")
    public String getPost(@PathVariable int cateNo,Model model){
        String id = blogServices.getId(cateNo);
        model.addAttribute("postList",postServices.postList(cateNo,id));
        BlogVO blogVO = blogServices.getList(id);
        model.addAttribute("blogVO",blogVO);
        System.out.println("겟포스트에서 뱉어내는 블로그아이디"+id);
        return "/blog/blog-main.jsp";


    }
}
