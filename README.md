### 这是一个小的demo项目

前提：项目是个spring boot项目，MySQL作为存储，使用mybatis操作数据库

**要求：**
1. 项目目前有点点问题，希望你能够调试下，运行起来
	1)添加注解@SpringBootApplication
	2)在AccountController中引用的Service方法上添加注解@Qualifier("crashAccountService")和@Qualifier("pointAccountService")
	3)添加application.properties配置文件，并修改mybatis-generator.xml和pom文件(a修改了<groupId>com.mobvoi.demo</groupId>，b修改了src/main/resources/mybatis-generator.xml)
2. 希望把这个项目原版上传到GitHub
3. 项目中有几处TODO，希望你能够思考下，简单实现了
	
4. 如果做了哪些改变或优化之类的也可以总结写在这里
a)在测试selectByPrimaryKey方法时，mybatis报-因为 accessExternalDTD 属性设置的限制导致不允许 'http' 访问
		做了在我的%JAVA_HOME%\jre\lib\ 目录下，新建一个文件jaxp.properties，内容：
		javax.xml.accessExternalSchema=all
		javax.xml.accessExternalDTD=all
	b)添加了CommonResult方法，用于测试时候，打印数据
	c)添加了热部署devtools和lombok组件
	d)修改了sql文件，sql文件少了type属性
5. 在你修改完后，希望把项目变更同步到GitHub上，展示给我们


感谢同学的支持
