package kr.co.bit.dao;


import kr.co.bit.vo.PostVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class PostDAO {

    @Autowired
    SqlSession sqlSession;

    public int insertPost(PostVO postVO){

        System.out.println("포스트다오에 넘어온 VO = " +postVO.toString());
        return sqlSession.insert("post.insertPost",postVO);
    }

    public List<PostVO> postList(int cateNo){
        List<PostVO> list = sqlSession.selectList("post.postList",cateNo);
        System.out.println("포스트리스트 다오에서 뱉어내는 리스트 사이즈"+list.size());
        return sqlSession.selectList("post.postList",cateNo);
    }

    public List<PostVO> defaultPostList(int cateNo,String id){
        HashMap<String, Object> map = new HashMap<>();
        map.put("cateNo", cateNo);
        map.put("id",id);

        int defaultCateNo = sqlSession.selectOne("category.getDefaultCate",map);
        List<PostVO> list = sqlSession.selectList("post.postList",defaultCateNo);
        System.out.println("디폴트 포스트 리스트 다오에서 뱉어내는 리스트 사이즈 및 카테남바 = "+list.size() +"//"+cateNo);
        return list;
    }

    public PostVO postView(int postNo){
        PostVO postVO = sqlSession.selectOne("post.postView",postNo);
        return postVO;
    }

    public int getCateNo(int postNo){
        return sqlSession.selectOne("post.getCateNo",postNo);
    }
}
