ch01-hello-mybatis:第一个入门例子

1.新建student表
2.加maven的mybatis坐标，mySQL驱动的坐标
3.创建实体类Student---用来保存表中一行数据的
4.创建持久层的dao接口，定义操作数据库的方法
5.创建一个mybatis使用的配置文件--sql映射文件--写sql语句，一般一个表一个映射文件
  这个文件是一个xml文件
6.创建mybatis的主配置文件：
  一个项目就一个主配置文件
  主配置文件提供了数据库的连接信息和sql映射文件的位置信息
7.创建使用mybatis的类：通过mybatis访问数据库