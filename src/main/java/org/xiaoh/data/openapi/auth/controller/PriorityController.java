package org.xiaoh.data.openapi.auth.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.xiaoh.data.openapi.auth.domain.PriorityDTO;
import org.xiaoh.data.openapi.auth.domain.PriorityVO;
import org.xiaoh.data.openapi.auth.service.PriorityService;
import org.xiaoh.data.openapi.common.util.DateProvider;

/**
 * @Description: 权限管理类Controller组件
 * @author pengyc
 * @date 2019年10月21日 
 *
 */
@RestController
@RequestMapping("/auth/priority")
public class PriorityController
{
    Logger logger = LoggerFactory.getLogger(PriorityController.class);
    
    @Autowired
    private PriorityService priorityService;
    
    @Autowired
    private DateProvider dateProvider;
    
    /**
     * 
     * @Description: List Root Priorities
     * @return 根权限集合
     */
    @GetMapping("/root")
    public List<PriorityVO> listRootPriorities()
    {
        List<PriorityVO> priorityVOs = null;
        try
        {
            List<PriorityDTO> priorityDTOs = priorityService.listRootPriorities();
            if (null != priorityDTOs && priorityDTOs.size() > 0)
            {
                priorityVOs = new ArrayList<>(priorityDTOs.size());
                for (PriorityDTO priorityDTO : priorityDTOs)
                {
                    priorityVOs.add(priorityDTO.clone(PriorityVO.class));
                }
            }
        }
        catch(Exception e)
        {
            logger.error(e.toString(), e);
        }
        return priorityVOs;
    }
    
    /**
     * 
     * @Description: 根据权限ID删除权限
     * @param id 
     * @return true 删除成功
     */
    @DeleteMapping("/delete/{id}")
    public Boolean removePriorityById(@PathVariable("id") Long id)
    {
        try
        {
           return priorityService.removePriority(id); 
        }
        catch(Exception e)
        {
            logger.error(e.toString(), e); 
        }
        return false;
    }
    
    /**
     * 
     * @Description: 新增权限
     * @param priorityVO
     * @return true 新增成功
     */
    @PostMapping("/save")
    public Boolean savePriority(@RequestBody PriorityVO priorityVO)
    {
        try
        {
            priorityService.savePriority(convertPriorityVO2DTO(priorityVO));
        } catch (Exception e)
        {
            logger.error(e.toString(), e); 
            return false;
        }
        return true;
    }
    
    /**
     * 
     * @Description: 更新权限
     * @param priorityVO
     * @return true 更新成功
     */
    @PutMapping("/update/{id}")
    public Boolean updatePriority(@RequestBody PriorityVO priorityVO)
    {
        try
        {
            priorityService.updatePriority(convertPriorityVO2DTO(priorityVO));
        } catch (Exception e)
        {
            logger.error(e.toString(), e); 
            return false;
        }
        return true; 
    }
    
    /**
     * 
     * @Description: 将PriorityVO转换成 PriorityDTO
     * @param priorityVO
     * @return PriorityDTO
     * @throws Exception
     */
    private PriorityDTO convertPriorityVO2DTO(PriorityVO priorityVO) throws Exception
    {
        PriorityDTO priorityDTO = priorityVO.clone(PriorityDTO.class);
        if(null != priorityVO.getGmtCreate())
        {
            priorityDTO.setGmtCreate(dateProvider.parseDatetime(priorityVO.getGmtCreate()));
        }
        if(null != priorityVO.getGmtModified())
        {
            priorityDTO.setGmtModified(dateProvider.parseDatetime(priorityVO.getGmtModified()));
        }
        return priorityDTO;
    }
    
}
