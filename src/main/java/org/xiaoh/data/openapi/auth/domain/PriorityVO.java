package org.xiaoh.data.openapi.auth.domain;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.xiaoh.data.openapi.common.util.BeanCopierUtil;

import net.sf.cglib.beans.BeanCopier;

/**
 * 权限VO类
 * 
 * @author PENGYC
 *
 */
public class PriorityVO
{
    private static final Logger logger = LoggerFactory.getLogger(PriorityVO.class);

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
    private String gmtCreate;
    /**
     * 权限的修改时间
     */
    private String gmtModified;

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

    public String getGmtCreate()
    {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate)
    {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtModified()
    {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified)
    {
        this.gmtModified = gmtModified;
    }

    /**
     * 版本 1 : 大量重复代码
     * 
     * @param clazz
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    public <T> T clone1(Class<T> clazz) throws InstantiationException, IllegalAccessException, NoSuchMethodException,
            SecurityException, IllegalArgumentException, InvocationTargetException
    {
        T instance = clazz.newInstance();
        Method setMethod = clazz.getMethod("setCode", Long.class);
        setMethod.invoke(instance, this.getCode());
        Method setMethod2 = clazz.getMethod("setUrl", String.class);
        setMethod2.invoke(instance, this.getUrl());
        Method setMethod3 = clazz.getMethod("setGmtModified", Date.class);
        setMethod3.invoke(instance, this.getGmtModified());

        return instance;
    }

    /**
     * 版本 二 : 每次有复制对象属性的需求：都需要都创建一个 BeanCopier 对象
     * 
     * @param clazz
     * @return
     */
    public <T> T clone2(Class<T> clazz)
    {
        T instance = null;
        try
        {
            instance = clazz.newInstance();
        } catch (InstantiationException e)
        {
            logger.error("new Instance error", e);
        } catch (IllegalAccessException e)
        {
            logger.error("new Instance error", e);
        }

        BeanCopier beanCopier = BeanCopier.create(PriorityVO.class, clazz, false);
        beanCopier.copy(this, instance, null);

        return instance;
    }

    /**
     * 终极版 : nice
     * 
     * @param clazz 目标Class对象
     * @return 克隆后的对象
     */
    public <T> T clone(Class<T> clazz)
    {
        T target = null;
        try
        {
            target = clazz.newInstance();
        } catch (Exception e)
        {
            logger.error("newInstance error", e);
        }
        BeanCopierUtil.copyProperties(this, target);

        return target;
    }

}
