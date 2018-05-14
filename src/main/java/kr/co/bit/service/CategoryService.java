package kr.co.bit.service;


import kr.co.bit.dao.CategoryDAO;
import kr.co.bit.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    public List<CategoryVO> getList(String id){
        List<CategoryVO> list = categoryDAO.getList(id);

        System.out.println("리스트사이즈즈즈즈"+list.size());
        return list;
    }

    public CategoryVO addCate(CategoryVO categoryVO){

        int no  = categoryDAO.addCate(categoryVO);

         return categoryDAO.selectCategory(no);
    }

    public boolean deleteCate(int cateNo){
        boolean flag = false;
        if(categoryDAO.deleteCate(cateNo)==true){
            flag = true;
        }
        return flag;
    }
    public int getDefaultCate(String id){
        return categoryDAO.getDefaultCate(id);
    }
}
