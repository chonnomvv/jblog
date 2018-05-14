package kr.co.bit.dao;

import kr.co.bit.vo.UsersVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsersDAO {

    @Autowired
    private SqlSession sqlSession;

    public int join(UsersVO usersVO){
        int result = sqlSession.insert("users.join",usersVO);


        return result;
    }

    public String checkId(String id){
        return sqlSession.selectOne("users.checkId",id);
    }

    public UsersVO login(UsersVO usersVO){
        System.out.println("로그인 다오 들어옴");
        UsersVO vo = sqlSession.selectOne("users.login",usersVO);
        System.out.println(vo.toString());
        return vo;
    }


}
