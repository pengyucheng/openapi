package org.xiaoh.data.openapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.xiaoh.data.openapi.controller.OrderQuantityController;
import org.xiaoh.data.openapi.controller.Response;
import org.xiaoh.data.openapi.domain.OrderQtyDTO;
import org.xiaoh.data.openapi.domain.OrderQuantityDTO;
import org.xiaoh.data.openapi.domain.OrderQuantityQuery;
import org.xiaoh.data.openapi.domain.OrderQuantityVO;

import com.alibaba.fastjson.JSON;

import net.sf.cglib.beans.BeanCopier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest
{
    @Autowired
    private OrderQuantityController controller;
    
    @Test
    public void testOrderController()
    {
        OrderQuantityQuery orderQuantityQuery = new OrderQuantityQuery();
        
        orderQuantityQuery.setPageNum("1");
        orderQuantityQuery.setPageSize("300");
        orderQuantityQuery.setPeriodId("201904");
        Response<OrderQuantityVO> response = controller.listByPage(orderQuantityQuery);
        
        System.out.println(JSON.toJSONString(response));
    }
    
    public static void testBeanCopier()
    {
        OrderQtyDTO orderQuantityDTO = new OrderQtyDTO();
        orderQuantityDTO.setArea("Asia");
        orderQuantityDTO.setBillingQty(200.00);
        orderQuantityDTO.setOrgId("Japan");
        orderQuantityDTO.setPeriodId("201908");
        
        OrderQuantityVO orderQuantityVO = new OrderQuantityVO();
        BeanCopier copier = BeanCopier.create(OrderQtyDTO.class, OrderQuantityVO.class, false);
        copier.copy(orderQuantityDTO, orderQuantityVO, null);
        
        System.out.println(orderQuantityVO);
    }
    
    public static void main(String[] args)
    {
        testBeanCopier();
    }
}
