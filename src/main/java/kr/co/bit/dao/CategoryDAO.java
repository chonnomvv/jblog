package kr.co.bit.dao;

import kr.co.bit.vo.CategoryVO;
import kr.co.bit.vo.UsersVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class CategoryDAO {

    @Autowired
    private SqlSession sqlSession;

    public int makeCategory(UsersVO usersVO){
        return sqlSession.insert("category.makeCategory",usersVO);
    }

    public List<CategoryVO> getList(String id){

        return sqlSession.selectList("category.getList",id);
    }

    public int addCate(CategoryVO categoryVO){
        System.out.println("카테고리다오. 쿼리 직전" + categoryVO.toString());
        sqlSession.insert("category.addCate",categoryVO);
        System.out.println("addcate 다오 받아온 거"+categoryVO.getCateNo());

        return categoryVO.getCateNo();
    }

    public CategoryVO selectCategory(int no){
        return sqlSession.selectOne("category.selectCategory",no);
    }

    public boolean deleteCate(int cateNo){
        boolean flag = false;
        if(sqlSession.delete("category.deleteCate", cateNo)!=0){
            flag= true;
        }
        return flag;
    }

    public int getDefaultCate(String id){
       return sqlSession.selectOne("category.getDefaultCate");
    }
}
