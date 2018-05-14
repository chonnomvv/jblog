package kr.co.bit.controller;

import kr.co.bit.service.CategoryService;
import kr.co.bit.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ResponseBody
    @RequestMapping(value = "/jblog/category/getList",method = RequestMethod.POST)
    public List<CategoryVO> getList(@RequestParam("id") String id,Model model){
        System.out.println("getList로 넘어온 id="+id);
        List<CategoryVO> list =  categoryService.getList(id);
        model.addAttribute("list",list);
        model.addAttribute("id",id);
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "/jblog/category/addCate",method = RequestMethod.POST)
    public CategoryVO addCate(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("description") String description){

        CategoryVO categoryVO = new CategoryVO();
        categoryVO.setId(id);
        categoryVO.setCateName(name);
        categoryVO.setDescription(description);

        System.out.println("ajax 애드하고 들어온 vo 투스트링"+categoryVO.toString());
        return categoryService.addCate(categoryVO);
    }

    @ResponseBody
    @RequestMapping(value = "/jblog/category/deleteCate",method = RequestMethod.POST)
    public boolean deleteCate(@RequestParam("cateNo") int cateNo){
        System.out.println("삭제 컨트롤러 들어옴");
        return categoryService.deleteCate(cateNo);

    }

    @RequestMapping(value = "/jblog/category/getDefaultCate",method = RequestMethod.POST)
    public int getDefaultCate(@RequestParam("id")String id){
        return categoryService.getDefaultCate(id);
    }
}
