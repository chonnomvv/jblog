package kr.co.bit.dao;

import kr.co.bit.vo.BlogVO;
import kr.co.bit.vo.UsersVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class BlogDAO {

    @Autowired
    private SqlSession sqlSession;

    public int makeBlog(UsersVO usersVO){
        return sqlSession.insert("blog.blogMake",usersVO);
    }

    public BlogVO getList(String id){
        return sqlSession.selectOne("blog.getList",id);
    }

    public void modify(BlogVO blogVO){
        sqlSession.update("blog.modify",blogVO);
    }

    public String getId(int cateNo){
        return sqlSession.selectOne("blog.getId",cateNo);
    }
}
