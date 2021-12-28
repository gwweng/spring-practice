# spring-practice
Spring框架训练 - 致力于精通Spring系列


## Demo练习
- demo1 - 使用ImportBeanDefinitionRegistrar手动注册Bean
- demo2 - 自己开发一个@Mapper注解注册Bean（同理Spring的@Component）
- demo3 - 实现解析配置文件的功能（使用PropertySourceLoader接口）
> SpringBoot没有提供解析json配置文件的功能，实现自定义解析Json配置

- demo4 - 实现ApplicationContextAware接口方便获取容器ApplicationContext
- demo5 - 使用FactoryBean自定义注册对象
- demo6 - 使用BeanPostProcessor实现动态ID生成器
- demo7 - 使用BeanDefinitionRegistryPostProcessor注入Bean




### 理论知识
#### 注入Bean的五种方式

- @Configuration + @Bean
- @Component + @ComponentScan
- @Import注解导入
  - @Import 直接导入类
  - @Import + ImportSelector
  - @Import + ImportBeanDefinitionRegistrar
  - @Import + DeferredImportSelector(区别第2种好处是延迟导入)
- 使用FactoryBean接口
- 使用BeanDefinitionRegistryPostProcessor
> Spring 容器启动时会执行BeanDefinitionRegistryPostProcessor#postProcessBeanDefinitionRegistry方法，等Bd对象加载完毕之后，对bd对象进行后置处理