package kr.co.bit.service;

import kr.co.bit.dao.BlogDAO;
import kr.co.bit.dao.CategoryDAO;
import kr.co.bit.dao.UsersDAO;
import kr.co.bit.vo.UsersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServices {

    @Autowired
    private UsersDAO usersDAO;
    @Autowired
    private BlogDAO blogDAO;
    @Autowired
    private CategoryDAO categoryDAO;

    public int usersJoin(UsersVO usersVO){
        int userJoin = usersDAO.join(usersVO);
        blogDAO.makeBlog(usersVO);
        categoryDAO.makeCategory(usersVO);
        System.out.println("유저서비스 유저조인");
        return userJoin;
    }

    public boolean checkId(String id){
        boolean flag = false;

        String str = usersDAO.checkId(id);
        System.out.println(str);
        if(str == null){
            flag = true;
        }else{
            flag = false;
        }
        System.out.println(flag);
        return flag;
    }

    public UsersVO login(UsersVO usersVO){
        return usersDAO.login(usersVO);
    }

}
