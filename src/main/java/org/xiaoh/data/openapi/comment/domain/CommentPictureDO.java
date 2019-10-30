package org.xiaoh.data.openapi.comment.domain;

import java.util.Date;
import org.xiaoh.data.openapi.common.util.AbstractObject;

/**
 * 
 * @Description: 评论图片DO
 * @author pengyc
 * @date 2019年10月30日 
 * @ClassName: CommentPictureDO
 *
 */
public class CommentPictureDO extends AbstractObject
{
    /**
     * 评论图片id
     */
    private Long id;
    
    /**
     * 评论信息id
     */
    private Long commentInfoId;
    
    /**
     * 评论图片路径
     */
    private String commentPicturePath;
    
    /**
     * 图片上传时间
     */
    private Date gmtCreate;
    
    /**
     * 图片修改时间
     */
    private Date gmtModified;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getCommentInfoId()
    {
        return commentInfoId;
    }

    public void setCommentInfoId(Long commentInfoId)
    {
        this.commentInfoId = commentInfoId;
    }

    public String getCommentPicturePath()
    {
        return commentPicturePath;
    }

    public void setCommentPicturePath(String commentPicturePath)
    {
        this.commentPicturePath = commentPicturePath;
    }

    public Date getGmtCreate()
    {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate)
    {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified()
    {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified)
    {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString()
    {
        return "CommentPictureDO [id=" + id + ", commentInfoId=" + commentInfoId + ", commentPicturePath="
                + commentPicturePath + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
    }
    
}
