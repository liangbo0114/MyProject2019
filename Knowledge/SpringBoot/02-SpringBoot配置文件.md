## 1、配置文件

SpringBoot使用一个全局配置文件，配置文件名是固定的

-   application.properties
-   application.yml



配置文件的作用：修改SpringBoot自动配置的默认值，SpringBoot在底层都给我们自动配置好



YAML（YAML Ain't Markup Language）

-   YAML  A Markup Language: 是一个标记语言
-   YAML  isn't Markup Language: 不是一个标记语言

标记语言：

-   以前的配置文件，大多使用的是xxxx.xml文件

-   YAML以数据为中心，比json、xml等更适合做配置文件

    **配置实例**

    YAML：

    ```yaml
    server:
      port: 8081
    ```

    XML：

    ```xml
    <server>
    	<port>8081</port>
    </server>
    ```

## 2、YAML语法

### 1）基本语法

key: value表示一对键值对（空格必须有）

以空格的缩进来控制层级关系，只要是左对齐的一列数据都是同一层级的

```yaml
server:
    port: 8081
    path: /hello
```

属性和值大小写敏感

### 2）值的写法

**字面量：普通的值（数字、字符串、布尔）**

-   key: value   字面量直接来写

-   字符串默认不用加单引号或双引号

    -   "" : 双引号，不会转义字符串里的特殊字符
        -   name: "zhangsan \n lisi"   输出  zhangsan 换行 lisi

    -   '' : 单引号，会转义特殊字符，特殊字符最终只是一个普通字符串数据
        -   name: "zhangsan \n lisi"   输出 zhangsan \n lisi

**对象、Map（属性和值）（键值对）**

-   key: value  在下一行写对象的属性和值的关系，注意缩进

    -   对象也是k: v的方式

    ``` yaml
    friends:
    	lastName: zhangsan
    	age: 20
    ```

-   行内写法：

    ```yaml
    friends: {lastName: zhangsan,age: 20}
    ```

    

**数组（List、Set）**

-   用- 值表示数组中的元素

    ```yaml
    pets:
      - cat
      - dog
      - pig
    ```

-   行内写法

    ```yaml
    pets: [cat,dag,pig]
    ```

### 3) 获取配置文件注入

#### a) 注入方式

application.yml

```yaml
person:
  last-name: zhangsan
  age: 19
  isBoss: true
  birth: 2017/01/01
  maps: {m1: m1,m2: m2}
  lists:
    - lisi
    - wangwu
  dog:
    name: erha
    age: 2
  
```

application.properties

```properties
#配置person的值
person.last-name=张三
person.age=20
person.birth=2017/1/1
person.boss=true
person.maps.m1=m1
person.maps.m2=m2
person.lists=a,b,c
person.dog.name=dog
person.dog.age=4

```

Person.java

```java
/**
 * 将配置文件中配置的每一个属性的值，映射到这个组件
 * @ConfigurationProperties : 告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定
 *          prefix = "person" ： 配置文件中哪个下面的所有属性进行映射
 *  只有这个组件是容器中的组件，才能提供 @ConfigurationProperties 功能
 */
@Component
@ConfigurationProperties(prefix = "person")
public class Person {

    private String lastName;
    private int age;
    private Boolean isBoos;
    private Date birth;
    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;
```

我们可以导入配置文件处理器，以后编写配置就会有提示

```xml
<!--导入配置文件处理器-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
    <optional>true</optional>
</dependency>
```

#### b) @Value获取值

和@ConfigurationProperties获取值比较

|                | @ConfigurationProperties |   @Value   |
| :------------: | :----------------------: | :--------: |
|      功能      | 批量注入配置文件中的属性 | 一个个指定 |
|  松散语法绑定  |           支持           |   不支持   |
|      SpEL      |          不支持          |    支持    |
| JSR303数据校验 |           支持           |   不支持   |

#### c) @PropertySource和@ImportResource

@**PropertySource**：加载指定的配置文件

```java
@PropertySource(value = "classpath:person.properties")
@Component
@ConfigurationProperties(prefix = "person")
public class Person {

    private String lastName;
    private int age;
    private Boolean isBoss;
    private Date birth;
    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;
```

**@ImportResource**：导入Spring的配置文件，让配置文件里的内容生效