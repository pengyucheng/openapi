package org.xiaoh.data.openapi.comment.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xiaoh.data.openapi.comment.domain.CommentPictureDO;
import org.xiaoh.data.openapi.comment.mapper.CommentPictureMapper;

/**
 * 
 * @Description: 评论图片上传模块DAO组件接口实现类
 * @author pengyc
 * @date 2019年10月30日 
 * @ClassName: CommentPictureDAOImpl
 *
 */
@Component
public class CommentPictureDAOImpl implements CommentPictureDAO
{
    @Autowired
    private CommentPictureMapper commentPictureMapper;
    
    @Override
    public void saveCommonPicture(CommentPictureDO commentPictureDO) throws Exception
    {
        commentPictureMapper.saveCommonPicture(commentPictureDO);
    }

}
