package org.xiaoh.data.openapi.auth.domain;

import java.lang.reflect.Method;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.xiaoh.data.openapi.common.util.BeanCopierUtil;

/**
 * 
 * @Description: 权限DO类
 * @author pengyc
 * @date 2019年10月18日
 *
 */
public class PriorityDO
{
    private Logger logger = LoggerFactory.getLogger(PriorityDO.class);

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

    /**
     * 
     * @Description: clone
     * @param clazz 目标克隆对象
     * @return 克隆后的对象
     */
    public <T> T clone2(Class<T> clazz)
    {
        T  t = null;
        try
        {
           t = clazz.newInstance();
           
           Method method1 = clazz.getMethod("setId", Long.class);
           method1.invoke(t, this.getId());
           
           Method method2 = clazz.getMethod("setCode", Long.class);
           method2.invoke(t, this.getCode());
        } catch (InstantiationException e)
        {
           logger.error(e.toString(),e); 
        } catch (IllegalAccessException e)
        {
           logger.error(e.toString(),e); 
        } catch (Exception e)
        {
            logger.error(e.toString(),e); 
        }

        return null;
    }
    
    /**
     * 
     * @Description: clone
     * @param clazz 目标克隆对象
     * @return 克隆后的对象
     */
    public <T> T clone(Class<T> clazz)
    {
        T  t = null;
        try
        {
           t = clazz.newInstance();
           BeanCopierUtil.copyProperties(this, t);
          
        } catch (InstantiationException e)
        {
           logger.error(e.toString(),e); 
        } catch (IllegalAccessException e)
        {
           logger.error(e.toString(),e); 
        } 

        return t;
    }
}
