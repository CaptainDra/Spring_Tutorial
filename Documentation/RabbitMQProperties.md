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
选择要使用的侦听器容器的类型,详见:https://docs.spring.io/spring-amqp/reference/html/_reference.html#choose-container   (这个网页是假的)    

#### deadLetterQueueName ####
默认值: prefix+destination.dlq    
死信队列名称    

#### deadLetterExchange ####
默认值: 'prefix+DLX'     
分配给queue的DLX。仅当[autoBindDlq]为[true]时才用    

#### deadLetterExchangeType ####
默认值: 'direct'    
要分配给queue的DLX的类型。仅当[autoBindDlq]为[true]时才用    

#### deadLetterRoutingKey ####
默认值: destination     
给死信队列的路由键，仅当[autoBindDlq]为[true]时采用

#### declareDlx ####
默认值: true     
是否为目标声明死信交换，仅当[autoBindDlq]为[true]时才相关     
如果有预配置的 DLX，请设置为 false

#### declareExchange ####
默认值: true     
是否为目标声明exchange     

#### delayedExchange ####
默认值: false
是否将交换声明为[Delay Message Exchange]，需要代理上的延迟消息交换插件    
x-delayed-type 参数设置为 exchangeType     

#### dlqBindingArguments ####
默认值: empty    
将dlq绑定到死信交换时应用的参数；与header deadLetterExchangeType 一起使用以指定要匹配的header     
例如… dlqBindingArguments.x-match=any, … dlqBindingArguments.someHeader=someValue    

#### dlqDeadLetterExchange ####
默认值: none    
如果死信队列声明了，将一个DLX分配到那个queue    

#### dlqDeadLetterRoutingKey ####
默认值: none
如果死信队列声明了，将一个死信路由键分配到那个queue     

#### dlqExpires ####
默认值: no expiration     
死信队列里没用的多久删除(单位为ms)    

#### dlpLazy ####
默认值: false    
使用 x-queue-mode=lazy 参数声明死信队列。请参阅“https://www.rabbitmq.com/lazy-queues.html”     
建议考虑使用策略而不是此设置，因为使用策略即可允许在不删除队列的情况下更改设置

#### dlqMaxLength ####
默认值: no limit    
死信队列容量（消息数）     

#### dlqMaxLengthBytes ####
默认值: no limit    
死信队列容量(总字节数)    

#### dlqMaxPriority ####
默认值: none    
死信队列中信息最大优先值(0~255)    

#### dlqOverflowBehavior ####
默认值: none    
当上两个容量超过了后采取什么策略，当前可以采用[drop-head]或[reject-publish]，但是可能之后会变，请参考RabbitMQ文档   

#### dlqQuorum.deliveryLimit ####
默认值: none -代理器默认
当 [quorum.enabled=true] 时，设置传递限制，在此之后信息将被丢弃或死信。

#### dlqQuorum.enabled ####
默认值: false     
是否创建Quorum死信队列     

#### dlqQuorum.initialQuorumSize ####
默认值: none -代理器默认     
上一个设为true后，设置初始容量     

#### dlqSingleActiveConsumer ####
默认值: false     
设为true来设置[x-single-active-consumer]队列优先为true

#### dlqTtl ####
默认值: no limit    
应用与死信队列的默认生存时间(ms)

#### durableSubscription ####
默认值: true    
订阅是是持久的，仅当设置了group时才有效

#### exchangeAutoDelete ####
默认值: true     
如果 [declareExchange] 为 [true]，则exchange是否应自动删除（当exchange中最后一个队列删除后删除）

#### exchangeDurable ####
默认值: true    
如果 [declareExchange] 为 [true]，则exchange是否应该是持久的（exchange在代理重启后是否仍然存在）

#### exchangeType ####
默认值: topic    
exchange类型: [direct], [fanout], [headers] or [topic] for non-partitioned destinations and [direct], [headers] or [topic] for partitioned destinations.


#### exclusive ####
默认值: false     
是否创建独占消费者

#### expires ####
默认值: no expiration
未使用队列多久删(ms)


#### failedDeclarationRetryInterval ####
默认值: 5000    
如果队列丢失，尝试从队列中消费之间的间隔（ms）(怎么翻译都不是人话)


#### frameMaxHeadroom ####
默认值: 20000    
将堆栈跟踪添加到 DLQ 消息头时为其他头保留的字节数

#### headerPatterns ####
默认值: ['*'] (全部header)    
入站消息映射的标头模式


#### lazy ####
默认值: false       
使用 [x-queue-mode=lazy] 参数声明队列     
参考:https://www.rabbitmq.com/lazy-queues.html    

#### maxConcurrency ####
默认值: 1    
最多消费者数.当[containerType]为[direct]不支持


#### maxLength ####
默认值: no limit     
队列中最多有多少消息

#### maxLengthBytes ####
默认值: no limit    
队列中最多有多少字节(总)

#### maxPriority ####
默认值: none    
队列中信息最大优先值(0~255)

#### missingQueuesFatal ####
默认值: false
当找不到队列时，是否将条件视为错误并停止监听容器    
默认为 false 以便容器不断尝试从队列中消费     

#### overflowBehavior ####
默认值: none    
超过 maxLength 或 maxLengthBytes 时采取的行动；[drop-head]或[reject-publish]

#### prefetch ####
Default: 1    
Prefetch的数目    

#### prefix ####
默认值: ""    
要添加到destination和queue名称的前缀

#### queueBindingArguments ####
默认值: empty    
将队列绑定到交换时应用的参数；与 [headers],[exchangeType] 一起使用以指定要匹配的header

#### queueDeclarationRetries ####
默认值: 3    
如果队列丢失，重试消费的次数。仅当 [missingQueuesFatal]为[true]时才相关   
否则，容器会无限期地重试     
当[containerType]为[direct]时不支持

#### queueNameGroupOnly ####
默认值: false     
当为[true]时，从名称等于group的队列中消费,否则队列名称是[destination.group]

#### quorum.deliveryLimit ####
默认值: none - 代理默认     
当quorum.enabled=true时，设置传递限制，在此之后邮件将被丢弃或死信    

#### quorum.enabled ####
默认值: false     
为 true 时，创建仲裁队列而不是经典队列     

#### quorum.initialQuorumSize ####
默认值: none - 代理默认
当 quorum.enabled=true 时，设置初始大小     

#### recoveryInterval ####
默认值: 5000    
恢复连接尝试间隔(ms)

#### requeueRejected ####
默认值: false    
当禁用重试或 [republishToDlq] 为 [false] 时，传输失败时是否应重新排队。

#### republishDeliveryMode ####
默认值: DeliveryMode.PERSISTENT      
当 [republishToDlq] 为 [true] 时，指定重新发布消息的传递方式

#### republishToDlq ####
默认值: false    
默认情况下，重试用完后失败的消息将被拒绝。如果配置了死信队列（DLQ），RabbitMQ 会将失败的消息（未更改）路由到 DLQ     
如果设置为 true，则绑定器将带有附加标头的失败消息重新发布到 DLQ，包括来自最终失败原因的异常消息和堆栈跟踪    


#### singleActiveConsumer ####
默认值: false    
设置为 true 以将 x-single-active-consumer 队列属性设置为 true


#### transacted ####
默认值: false.    
是否使用transacted channel

#### ttl ####
默认值: no limit    
声明时应用于队列的默认生存时间(ms)    
#### txSize ####
默认值: 1.    
ack 之间的交付次数。当 containerType 为[direct]时不支持