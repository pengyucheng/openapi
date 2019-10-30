package org.xiaoh.data.openapi.comment.dao;

import org.xiaoh.data.openapi.comment.domain.CommentPictureDO;

/**
 * 
 * @Description: 评论图片上传模块DAO组件接口
 * @author pengyc
 * @date 2019年10月30日 
 * @ClassName: CommentPictureDAO
 *
 */
public interface CommentPictureDAO
{
    /**
     * @Description: 上传图片
     * @param commentPictureDO
     * @throws Exception
     */
    void saveCommonPicture(CommentPictureDO commentPictureDO) throws Exception;
}
