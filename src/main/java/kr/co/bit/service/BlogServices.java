package kr.co.bit.service;

import kr.co.bit.dao.BlogDAO;
import kr.co.bit.vo.BlogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class BlogServices {

    @Autowired
    private BlogDAO blogDAO;


    public BlogVO getList(String id){

        return blogDAO.getList(id);
    }

    public void modify(MultipartFile file, String blogTitle, String id){

        String saveDir = "/Users/JS-K/upload";

        if(file.isEmpty()){
            String logoFile = blogDAO.getList(id).getLogoFile();

            BlogVO blogVO = new BlogVO(id, blogTitle, logoFile);

            blogVO.setId(id);
            blogVO.setBlogTitle(blogTitle);
            blogVO.setLogoFile(logoFile);

            blogDAO.modify(blogVO);
        } else if(blogTitle.equals("")){

            String blogTitle2 = blogDAO.getList(id).getBlogTitle();

            String originalName = file.getOriginalFilename();

            String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

            String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;

            String filePath = saveDir + "/" + saveName;
            String logoFile = saveName;



            BlogVO blogVO = new BlogVO(id, blogTitle, logoFile);

            blogVO.setId(id);
            blogVO.setBlogTitle(blogTitle2);
            blogVO.setLogoFile(logoFile);
        }
        else {

            String originalName = file.getOriginalFilename();

            String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

            String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;

            String filePath = saveDir + "/" + saveName;
            String logoFile = saveName;
            BlogVO blogVO = new BlogVO(id, blogTitle, logoFile);

            blogVO.setId(id);
            blogVO.setBlogTitle(blogTitle);
            blogVO.setLogoFile(logoFile);

            try {
                byte[] fileData = file.getBytes();
                OutputStream os = new FileOutputStream(saveDir + "/" + saveName);  //()=>어디에 쓸 것인지(filePath)
                BufferedOutputStream bos = new BufferedOutputStream(os);
                bos.write(fileData);
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            blogDAO.modify(blogVO);
        }

    }

    public String getId(int cateNo){
        return blogDAO.getId(cateNo);
    }
}
