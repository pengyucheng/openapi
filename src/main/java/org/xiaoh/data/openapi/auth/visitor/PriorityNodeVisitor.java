package org.xiaoh.data.openapi.auth.visitor;

import org.xiaoh.data.openapi.auth.composite.PriorityNode;

/**
 * 
 * @Description: 权限树 visitor
 * @author pengyc
 * @date 2019年10月21日 
 *
 */
public interface PriorityNodeVisitor
{
	
	/**
	 * 访问权限树节点
	 * @param node 权限树节点
	 * @throws Exception 
	 */
	void visit(PriorityNode node) throws Exception;

}
