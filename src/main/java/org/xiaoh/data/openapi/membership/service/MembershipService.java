package org.xiaoh.data.openapi.membership.service;

/**
 * @Description: 会员中心对外提供的接口
 * @author pengyc
 * @date 2019年10月30日 
 * @ClassName: MembershipService
 *
 */
public interface MembershipService
{
    
    /**
     * 
     * @Description: 通知会员中心，“发表评论”事件发生了
     * @param userAccountId 用户账号id
     * @param showPicture 是否晒图
     * @return
     */
    Boolean informPublishCommentEvent(Long userAccountId, Boolean showPicture);
}
