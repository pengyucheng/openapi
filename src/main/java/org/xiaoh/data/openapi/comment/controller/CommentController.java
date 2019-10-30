package org.xiaoh.data.openapi.comment.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.xiaoh.data.openapi.comment.domain.CommentInfoDTO;
import org.xiaoh.data.openapi.comment.domain.CommentInfoVO;
import org.xiaoh.data.openapi.comment.service.CommentPictureService;
import org.xiaoh.data.openapi.membership.service.MembershipService;
import org.xiaoh.data.openapi.order.service.OrderService;

/**
 * 
 * @Description: 评论模块controller组件
 * @author pengyc
 * @date 2019年10月30日 
 * @ClassName: CommentController
 *
 */
@RestController
@RequestMapping("/comment")
public class CommentController
{
    private Logger log = LoggerFactory.getLogger(CommentController.class);
    
    @Autowired
    private MembershipService membershipService;
    
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private CommentPictureService commonPictureService;
    
    /**
     * 
     * @Description: 新增评论
     * @param commentInfoVO
     * @param file 评论晒图
     * @param servlet
     * @return
     */
    @PostMapping("/save")
    public Boolean publishComment(HttpServletRequest request, CommentInfoVO commentInfoVO, MultipartFile[] files)
    {
        try
        {
            CommentInfoDTO commentInfoDTO = commentInfoVO.clone(CommentInfoDTO.class);
            
            // 上传评论晒图
            String appBasePath = request.getSession().getServletContext().getRealPath("/");
            commonPictureService.saveCommonPicture(appBasePath, commentInfoDTO.getId(), files);
            
            // 通知订单中心订单已经发表了评论
            orderService.informPublishCommentEvent(commentInfoDTO.getOrderInfoId());
            
            // 通知会员中心用户已经发表了评论
            membershipService.informPublishCommentEvent(commentInfoDTO.getUserAccountId(), true);
        }
        catch(Exception e)
        {
           log.error(e.toString(), e); 
           return false;
        }
        return true;
    }
}
