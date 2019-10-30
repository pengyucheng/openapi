package org.xiaoh.data.openapi.comment.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.xiaoh.data.openapi.comment.domain.CommentPictureDO;

/**
 * 
 * @Description: 图片上传mapper组件
 * @author pengyc
 * @date 2019年10月30日 
 * @ClassName: CommentPictureMapper
 *
 */
@Mapper
public interface CommentPictureMapper
{
    /**
     * 
     * @Description: 新增评论图片
     * @param commentPictureDO
     */
    @Insert("insert into "
            + "comment_picture "
            + "("
                + "comment_info_id,"
                + "comment_picture_path,"
                + "gmt_create,"
                + "gmt_modified"
            + ") "
            + "values("
                + "#{commentInfoId},"
                + "#{commentPicturePath},"
                + "#{gmtCreate},"
                + "#{gmtModified})")
    @Options(keyColumn = "id",keyProperty = "id", useGeneratedKeys = true)
    void saveCommonPicture(CommentPictureDO commentPictureDO);
}
