package org.xiaoh.data.openapi.comment.domain;

import org.xiaoh.data.openapi.common.util.AbstractObject;

/**
 * 
 * @Description: 评论信息VO
 * @author pengyc
 * @date 2019年10月30日 
 * @ClassName: CommentInfoVO
 *
 */
public class CommentInfoVO extends AbstractObject
{
    /**
     * 评论信息id
     */
    private Long id;
    
    /**
     * 用户账号id
     */
    private Long userAccountId;
    
    /**
     * 订单信息id
     */
    private Long orderInfoId;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getUserAccountId()
    {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId)
    {
        this.userAccountId = userAccountId;
    }

    public Long getOrderInfoId()
    {
        return orderInfoId;
    }

    public void setOrderInfoId(Long orderInfoId)
    {
        this.orderInfoId = orderInfoId;
    }

    
}
