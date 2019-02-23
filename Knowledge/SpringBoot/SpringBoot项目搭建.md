# **Spring Boot项目搭建**

## 一、创建一个Maven工程

## 二、导入Spring Boot相关依赖

```xml
<parent>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-parent</artifactId>
	<version>2.1.3.RELEASE</version>
</parent>

<dependencies>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web</artifactId>
	</dependency>
</dependencies>
```



## 三、编写一个主程序

```java
/**
 * @SpringBootApplication来标注一个主程序类，说明这是一个Spring Boot应用
 */
@SpringBootApplication
public class HelloWorldMainApp {

    public static void main(String[] args) {
        //启动Spring应用
        SpringApplication.run(HelloWorldMainApp.class,args);
    }
}
```

## 四、编写相关的Controller、Service

```java
@Controller
public class HelloController {
    
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "HelloWorld!!!";
    }
    
}
```



## 五、运行主程序测试

## 六、简化部署

```xml
<!--这个插件可以将应用打包成一个可执行的jar包-->
<build>
	<plugins>
		<plugin>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-maven-plugin</artifactId>
		</plugin>
	</plugins>
</build>
```



# **项目探究**

## 1、pom文件

- 父项目

```xml
<parent>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-parent</artifactId>
	<version>2.1.3.RELEASE</version>
</parent>
<!--他的父项目是-->
<parent>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-dependencies</artifactId>
	<version>2.1.3.RELEASE</version>
	<relativePath>../../spring-boot-dependencies</relativePath>
</parent>
<!--他来真正管理Spring Boot应用里面的所有依赖版本-->
```

Spring Boot的版本仲裁中心；

以后我们导入依赖默认不需要写版本（没有在dependencies里面管理的依赖需要声明版本号）

- 启动器

  ```xml
  <dependencies>
  	<dependency>
  		<groupId>org.springframework.boot</groupId>
  		<artifactId>spring-boot-starter-web</artifactId>
  	</dependency>
  </dependencies>
  ```

  **spring-boot-starter**-web：

  ​	spring-boot-starter : spring-boot场景启动器，帮助我们导入了web模块正常运行

  所依赖的组件。

  > ​	Spring Boot将所有的功能场景都抽取出来，做成一个个的starters（启动器），只需要在项目里面引入这些starter相关场景的所有依赖都会导入进来，要用什么功能就导入什么场景的启动器。

## 2、主程序类（主入口类）

```java
/**

- @SpringBootApplication来标注一个主程序类，说明这是一个Spring Boot应用
  */
  @SpringBootApplication
  public class HelloWorldMainApp {

  public static void main(String[] args) {
      //启动Spring应用
      SpringApplication.run(HelloWorldMainApp.class,args);
  }
      
  }
```



@**SpringBootApplication**： Spring Boot应用标注在某个类上，说明这个类是Spring Boot的主配置类，Spring Boot就应该运行这个类的main方法来启动Spring Boot应用；

```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(
    excludeFilters = {
        @Filter(type = FilterType.CUSTOM,classes ={TypeExcludeFilter.class}), 
        @Filter(type = FilterType.CUSTOM,classes{AutoConfigurationExcludeFilter.class})})
public @interface SpringBootApplication {
```

@**SpringBootConfiguration** ： Spring Boot的配置类

​	标注在某个类上，表示这个类是Spring Boot的配置类

​	@**Configuration** ：配置类上来标注这个注解

​		配置类--------配置文件：配置类也是容器中的一个组件（@Component）

@**EnableAutoConfiguration** ： 开启自动配置功能

​	以前我们需要配置的东西，Spring Boot帮我们自动配置；@EnableAutoConfiguration告诉Spring Boot开启自动配置功能，这样自动配置才能生效。

```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@AutoConfigurationPackage
@Import({AutoConfigurationImportSelector.class})
public @interface EnableAutoConfiguration {
```

​	@**AutoConfigurationPackage** ： 

​		==自动配置包，将主配置类（@SpringBootApplication标注的类）所在的包及下面所有子包里面的所有组件扫描到Spring容器==

​		@**Import({Registrar.class})**

​		Spring的底层注解@Import，给容器中导入一个组件，导入的组件由Registrar.class

​	@**Import({AutoConfigurationImportSelector.class})** 

​		AutoConfigurationImportSelector : 导入哪些组件选择器

​		将所有需要导入的组件以全类名的方式返回，这些组件就会被添加到容器中

​		会给容器中导入非常多的自动配置类（xxxAutoConfiguration），就是给容器中导入这个	场景所需要的所有组件，并配置好这些组件	

​	有了自动配置类，免去了我们手动编写配置注入功能组件等工作。

# 快速创建Spring Boot工程

IDEA支持使用Spring的项目创建向导快速创建一个SpringBoot项目

选择我们需要的模块，想到会联网创建SpringBoot项目

默认生成的SpringBoot项目：

-   主程序已经生成好，我们只需写我们自己的逻辑

-   Resources文件夹中的目录结构

    -   static：保存所有的静态资源（js，css，images）
    -   templates：保存所有的模板页面（SpringBoot默认jar包使用嵌入式的Tomcat，默认不支持JSP页面），可以使用模板引擎（freemarker，thymeleaf）
    -   application.properties：SpringBoot应用的配置文件

    



​		

​	

