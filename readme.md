# 基于微服务的个人博客

## Nacos 的启动方式
```cmd
startup.cmd -m standalone
```
- 访问地址是[本机访问地址](http://localhost:8848/nacos/#/login)
- 登录账号密码都是nacos

```java
String jsonObject = JSON.toJSONString(result.getData());
        UserAuth userAuth = JSON.parseObject(jsonObject, UserAuth.class);
```