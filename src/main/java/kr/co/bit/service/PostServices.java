package kr.co.bit.service;


import kr.co.bit.dao.PostDAO;
import kr.co.bit.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServices {

    @Autowired
    PostDAO postDAO;

    public int insertPost(PostVO postVO){

        return postDAO.insertPost(postVO);
    }

    public PostVO postView(int postNo){
        return postDAO.postView(postNo);
    }

    public List<PostVO> postList(int cateNo,String id){

        if(cateNo==-1){
            List<PostVO> postList = postDAO.defaultPostList(cateNo,id);
            return postList;
        }

        else {
            List<PostVO> postList = postDAO.postList(cateNo);
            System.out.println("포스트리스트 서비스에서 리스트 사이즈=" + postList.size());
            return postList;
        }
    }

    public int getCateNo(int postNo){
        return postDAO.getCateNo(postNo);
    }
}
