package org.xiaoh.data.openapi.comment.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @Description: 评论图片上传模块service组件接口
 * @author pengyc
 * @date 2019年10月30日 
 * @ClassName: CommentPictureService
 *
 */
public interface CommentPictureService
{
    /**
     * 
     * @Description: 上传图片
     * @param appBasePath 当前应用根路径
     * @param commentInfoId 评论信息id
     * @param files 评论晒图
     * @throws Exception
     */
    void saveCommonPicture(String appBasePath, Long commentInfoId, MultipartFile[] files) throws Exception;
}
