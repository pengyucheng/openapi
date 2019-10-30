package org.xiaoh.data.openapi.comment.service.impl;

import java.io.File;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.xiaoh.data.openapi.comment.dao.CommentPictureDAO;
import org.xiaoh.data.openapi.comment.domain.CommentPictureDO;
import org.xiaoh.data.openapi.comment.service.CommentPictureService;

/**
 * 
 * @Description: 评论图片上传模块 service 组件接口实现类
 * @author pengyc
 * @date 2019年10月30日 
 * @ClassName: CommentPictureDAOImpl
 */
@Service
public class CommentPictureServiceImpl implements CommentPictureService
{
    @Autowired
    private CommentPictureDAO commentPictureDAO;
    
    @Value("${comment.picture.upload.dir}")
    private String uploadFilePath;
    
    /**
     * 
     * @Description: 上传图片,图片本身保存到服务器本地，数据库中保留图片路径
     * @param appBasePath 当前应用根路径
     * @param commentInfoId 评论信息id
     * @param files 评论晒图
     * @throws Exception
     */
    @Override
    public void saveCommonPicture(String appBasePath, Long commentInfoId, MultipartFile[] files) throws Exception
    {
        // 获取上传目录
        String uploadPath = appBasePath + uploadFilePath;
        File uploadDir = new File(uploadPath);
        if(!uploadDir.exists())
        {
            uploadDir.mkdir();
        }
        // 保存图片至本地
        for (MultipartFile image : files)
        {
            if(null == image)
            {
                continue;
            }
            String fileSeperator = System.getProperties().getProperty("file.separator");
            String targetFilePath = uploadDir + fileSeperator + image.getOriginalFilename();
            File targetFile = new File(targetFilePath);
            if(targetFile.exists())
            {
                targetFile.delete();
            }
            // 将客户端上传来的图片保存到指定文件中
            image.transferTo(targetFile);
            
            CommentPictureDO commentPictureDO = new CommentPictureDO();
            commentPictureDO.setCommentInfoId(commentInfoId);
            commentPictureDO.setCommentPicturePath(targetFilePath);
            commentPictureDO.setGmtCreate(new Date());
            commentPictureDO.setGmtModified(new Date());
            commentPictureDAO.saveCommonPicture(commentPictureDO);
        }
    }
    
}
