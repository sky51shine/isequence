
# 一、功能说明 #

1. 这个小工程用来生成一个全局的序列（sequence），线程安全

2. 数据库中sequence表大概是这样的

      |id|    gmt_modified    | name   | value |

      |1 | 2015-11-14 15:29:41| uuid   | 104   | 

      |2 | 2015-11-14 15:33:38| self_id|  96   |


# 二、使用方法 #

1. 下载本工程 

    <font size=2> **你可以直接复用，也可以自行本地打包使用** </font>

2. 修改数据库参数

     `sqlmap-config.properties`

3. 建立数据库基本表 
     
     `sequene.sql`

4. 初始化基本数据

     `insert into sequence(gmt_modified, name, value) values (now(), "uuid", 1)`

5. 使用方法参见

     `com.uulookingfor.isequence.example.SequenceExample#main`

# 三、声明 #

      自由转载-保持署名

