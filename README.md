# 在项目中实践设计模式相关源代码说明

## 项目一

### 需 求

很简洁：用户根据日期 分页查询 订单交易信息.

#### 应用场景举例

客户端发送https请求，查询 2019年8月的订单交易信息：http://ip:port/api/orderQty?periodId=201908 &pageNum=1&pageSize=250 

服务器返回：

```
{
	"status": 0,
	"msg": "success",
	"apiName": "orderQty",
	"data": {
		"result": [{
			"area": "EU",
			"orgId": "Eastern Europe",
			"periodId": "20190418",
			"billingQty": 0.0
		}, {
			"area": "Asia",
			"orgId": "Eastern Europe",
			"periodId": "20190418",
			"billingQty": 0.0
		}, {
			"area": "Asia",
			"orgId": "Europe",
			"periodId": "20190418",
			"billingQty": 0.0
		}],
		"hasNext": false,
		"totalSize": 7,
		"pageNum": 1
	}
} 

```
注：&pageNum=1&pageSize=250 两个参数可以不写,有默认值; 相关参数说明：

![请求参数](../src/main/image/params2.PNG)

![响应结果说明](https://github.com/pengyucheng/openapi/tree/master/src/main/image/params.PNG)


#### 项目架构摘要

简单，springboot + druid + jdbc + impala ; 由于 用的 jdbc ,不支持相关的分页插件，所以手写的原始分页 。 
 
#### 用到的设计模式

#### 1] [build 模式](https://blog.csdn.net/pengych_321/article/details/100175152) 

应用构造器模式封装响应结果。

#### 2] [简单工厂模式](https://blog.csdn.net/pengych_321/article/details/100175152)

应用简单工厂模式生成 ResponseBuilder 类。

