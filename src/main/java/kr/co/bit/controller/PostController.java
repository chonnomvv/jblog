package kr.co.bit.controller;


import kr.co.bit.service.BlogServices;
import kr.co.bit.service.CategoryService;
import kr.co.bit.service.PostServices;
import kr.co.bit.vo.BlogVO;
import kr.co.bit.vo.CategoryVO;
import kr.co.bit.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller

public class PostController {


    @Autowired
    BlogServices blogServices;
    @Autowired
    CategoryService categoryService;
    @Autowired
    PostServices postServices;

    @Autowired
    PostVO postVO;

    @RequestMapping(value = "/jblog/{id}/admin/write",method = RequestMethod.GET)
    public String write(@PathVariable String id,@RequestParam("auth")String authId,Model model){
        String auth = authId;

        BlogVO blogVO = blogServices.getList(id);
        List<CategoryVO> categoryList = categoryService.getList(id);

        model.addAttribute("blogVO",blogVO);
        model.addAttribute("auth",auth);
        model.addAttribute("cateList",categoryList);
        return "/blog/admin/blog-admin-write.jsp";
    }


    @RequestMapping(value = "/jblog/post/insert", method = RequestMethod.POST)
    public String insert(@RequestParam("auth") String auth,@RequestParam("blogId") String id,@RequestParam("cateNo") int cateNo, @RequestParam("postTitle")String postTitle,
                         @RequestParam("postContent") String postContent,Model model){
        PostVO postVO = new PostVO();
        BlogVO blogVO = blogServices.getList(id);
        List<CategoryVO> categoryList = categoryService.getList(id);
        postVO.setCateNo(cateNo);
        postVO.setPostTitle(postTitle);
        postVO.setPostContent(postContent);
        postServices.insertPost(postVO);
        model.addAttribute("blogVO",blogVO);
        model.addAttribute("auth",auth);
        model.addAttribute("cateList",categoryList);
        return "/blog/admin/blog-admin-write.jsp";
    }

    @RequestMapping(value = "/jblog/post/view",method = RequestMethod.GET)
    public String view(@RequestParam("postNo")int postNo,@RequestParam("id") String id, Model model){

        postVO = postServices.postView(postNo);
        model.addAttribute("postVO",postVO);
        BlogVO blogVO = blogServices.getList(id);
        int cateNo = postServices.getCateNo(postNo);
        model.addAttribute("blogVO",blogVO);
        model.addAttribute("postList",postServices.postList(cateNo,id));

        return "/blog/blog-main.jsp";
    }
}
