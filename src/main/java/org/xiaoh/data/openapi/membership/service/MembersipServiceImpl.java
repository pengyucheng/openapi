package org.xiaoh.data.openapi.membership.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * @Description: 会员中心对外接口实现类
 * @author pengyc
 * @date 2019年10月30日 
 * @ClassName: MembersipServiceImpl
 *
 */
@Service
public class MembersipServiceImpl implements MembershipService
{
    private Logger log = LoggerFactory.getLogger(MembersipServiceImpl.class);

    @Override
    public Boolean informPublishCommentEvent(Long userAccountId, Boolean showPicture)
    {
        try 
        {
            
        }
        catch(Exception e)
        {
            log.error(e.toString(), e); 
            return false;
        }
        return true;
    }

}
