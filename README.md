# BaiduTongjiClient
百度统计客户端
java客户端源码，根据官网提供的文档和php客户端demo源码移植而来。

## 百度api文档说明
http://dev2.baidu.com/docs.do?product=4#page=DataApi_Overview

## 百度统计接口文档pdf和php客户端demo源码
链接：http://pan.baidu.com/s/1kTxrdNh 密码：yw0x

## 百度统计DataApi简介（摘自百度官网）
### Profile

通过profile服务，您可以查询用户名下管理的站点、子目录信息。使用查询到的站点、子目录的siteid，可以通过report服务，下载相应站点下的报告数据。

### Report

通过report服务，您可以获取站点的详细报告数据（目前仅开通受访页面报告）。由于产生报告需要一定的时间，我们采用异步的方式对报告进行处理。您首先需要通过query()方法获得一个报告生成结果的result_id，然后可以调用getstatus()方法查询报告生成状态，若报告生成状态为已生成，则同时会在结果中返回下载报告生成结果文件的Url地址。根据该地址即可下载您所查询的报告数据。

请注意，result_id的有效时间为1小时，如果超时则需重新查询。由于调用getstatus()和query()方法都会扣减一定的配额，报告生成的时间为10分钟以内，请在调用query()方法后合适的时间后调用getstatus()方法查询报告生成状态，不要在调用完query()方法后立即频繁地调用getstatus()方法，造成不必要的配额扣减。
