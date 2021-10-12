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
配置消费者的时候可以用到，配置的时候前缀均为[spring.cloud.stream.rabbit.bindings.<channelName>.consumer.]格式    
当想把多个值绑定到全部channel的时候，为了避免重复，可以使用[spring.cloud.stream.rabbit.bindings.<channelName>.consumer.]来设置

#### acknowledgeMode ####
默认值: AUTO     
告知模式(acknowledge mode)     

#### anonymousGroupPrefix ####
默认值: anonymous       
当绑定没有任何[group]属性，会有一个匿名自动删除的队列被绑定到目标exchange。默认会将队列命名为[anonymous.<base64 representation of a UUID>]     
设置这个修改默认名     

#### autoBindDlq ####
默认值: false    
是否自动声明DLQ(死信队列)并将其绑定至DLX    

#### bindingRoutingKey ####
默认值: #    
用于将queue绑定到exchange的routing key(路由密钥)（如果 bindQueue 为 true）    
可以是多个key,详见[bindingRoutingKeyDelimiter]。    
对于分区目标，[-<instanceIndex>] 附加到每个键。    

#### bindingRoutingKeyDelimiter ####
默认值: null    
当不为空，bindingRoutingKey为一个被该值分隔的list，这个值通常为逗号

#### bindQueue ####
默认值: true    
是否声明queue并将其绑定到目标exchange。如果已经设置了自己的基础设施并且之前已经创建并绑定了queue，则将其设置为 false。

#### consumerTagPrefix ####
默认值：none - 代理将生成随机消费者标签    
用于创建消费者标签；并后面添加[#n]，其中n为消费者数量递增     

#### containerType ####
默认值: simple    
选择要使用的侦听器容器的类型,详见:https://docs.spring.io/spring-amqp/reference/html/_reference.html#choose-container(这个网页是假的)    

#### deadLetterQueueName ####
默认值: prefix+destination.dlq    
死信队列名称    

#### deadLetterExchange ####
默认值: 'prefix+DLX'     
分配给queue的DLX。仅当[autoBindDlq]为[true]时才相关。