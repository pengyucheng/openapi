
### 在项目中实践设计模式相关源代码说明
 
---


### [ 项目 一 ]

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
注 : pageNum=1&pageSize=250 两个参数可以不填;相关参数说明：

- 请求参数： 

| key | 是否必要 | 类型 | 说明 |
| ------ | ------ | ------ | ------ |
| periodId | 必要 | string | 统计日期，格式如： 201908 |
| pageSize | 可选 | int | 页大小，默认 250 |
| pageNum | 可选 | int | 页码 (默认从1开始) |

- 响应参数：

| key | 是否必要 | 类型 | 说明 |
| ------ | ------ | ------ | ------ |
| status | 必要 | int | 0：success    -1: 请求参数异常 -2：数据响应异常，请稍后重试 |
| msg | 必要 | String | 响应消息 |
| data | 必要 | Object | 返回数据 |
| apiName | 必要 | String | 请求接口名称 |

- data 具体格式：

| key | 是否必要 | 类型 | 说明 |
| ------ | ------ | ------ | ------ |
| result | 必要 | List<Object> | 实际数据列表 |
| hasNext | 必要 | boolean | 是否有下一页(true: 是， false: 否) |
| totalSize | 必要 | int | 总记录数 |
| pageNum | 必要 | int | 当前页码 |

- result 中 Object 字段:

| key | 是否必要 | 类型 | 说明 |
| ------ | ------ | ------ | ------ |
| area | 必要 | String | 区域 |
| orgName | 必要 | String | 国家 |
| periodId | 必要 | String | 开票时间 |
| billingQty | 必要 | String | 开票数量 |
	

#### 项目架构摘要

简单，springboot + druid + jdbc + impala ; 由于 用的 jdbc ,不支持相关的分页插件，所以手写的原始分页 。 
 
#### 用到的设计模式

#### 1] [build 模式](https://blog.csdn.net/pengych_321/article/details/100175152) 

应用构造器模式封装响应结果。

#### 2] [简单工厂模式](https://blog.csdn.net/pengych_321/article/details/100175152)

应用简单工厂模式生成 ResponseBuilder 类。

