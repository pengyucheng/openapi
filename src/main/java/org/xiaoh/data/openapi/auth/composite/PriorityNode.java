package org.xiaoh.data.openapi.auth.composite;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.xiaoh.data.openapi.auth.visitor.PriorityNodeVisitor;

/**
 * 
 * @Description: 权限树
 * @author pengyc
 * @date 2019年10月21日
 *
 */
public class PriorityNode
{
    /**
     * id
     */
    private Long id;
    /**
     * 权限编号
     */
    private String code;
    /**
     * 权限URL
     */
    private String url;
    /**
     * 权限备注
     */
    private String priorityComment;
    /**
     * 权限类型
     */
    private Integer priorityType;
    /**
     * 父权限id
     */
    private Long parentId;
    /**
     * 权限的创建时间
     */
    private Date gmtCreate;
    /**
     * 权限的修改时间
     */
    private Date gmtModified;
    /**
     * 子权限集合
     */
    private List<PriorityNode> childern = new ArrayList<>(16);
    
    /**
     * 
     * @Description: 权限树操作接收器
     * @param visitor
     * @throws Exception 
     */
    public void accept(PriorityNodeVisitor visitor) throws Exception
    {
        visitor.visit(this);
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getPriorityComment()
    {
        return priorityComment;
    }

    public void setPriorityComment(String priorityComment)
    {
        this.priorityComment = priorityComment;
    }

    public Integer getPriorityType()
    {
        return priorityType;
    }

    public void setPriorityType(Integer priorityType)
    {
        this.priorityType = priorityType;
    }

    public Long getParentId()
    {
        return parentId;
    }

    public void setParentId(Long parentId)
    {
        this.parentId = parentId;
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

    public List<PriorityNode> getChildern()
    {
        return childern;
    }

    public void setChildern(List<PriorityNode> childern)
    {
        this.childern = childern;
    }
}
