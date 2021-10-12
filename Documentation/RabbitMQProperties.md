# Application Properties
## RabbitMQ

### RabbitMQ Binder Properties

#### spring.cloud.stream.rabbit.binder.adminAddresses ####
默认值: 空     
一个用逗号分隔的list，包含RabbitMQ管理插件的全部URL。 
当且仅当nodes包含不止一个入口的时候，且列表中每个入口都在spring.rabbitmq.addresses中有一个对应入口。
仅当你使用RabbitMQ聚簇并且希望从承载队列的节点消费的时候才会用到。(翻译: 一般用不上)

#### spring.cloud.stream.rabbit.binder.nodes ####
默认值: 空    
一个用逗号分隔的list，包含RabbitMQ所有节点名。
当有多个入口的时候，用来定位服务器地址，且列表中每个入口都在spring.rabbitmq.addresses中有一个对应入口。
仅当你使用RabbitMQ聚簇并且希望从承载队列的节点消费的时候才会用到。(翻译: 一般用不上)

#### spring.cloud.stream.rabbit.binder.compressionLevel ####
默认值: 1(最好的)     
压缩级别

#### spring.cloud.stream.binder.connection-name-prefix ####
默认值： none (Spring AMQP的默认值)    
用于命名由此绑定器创建的连接的连接名前缀。 名称是这个前缀后跟[#n]，其中n在每次打开新连接时递增。  

### RabbitMQ Consumer Properties
配置消费者的时候可以用到，配置的时候前缀均为**spring.cloud.stream.rabbit.bindings.<channelName>.consumer.**格式