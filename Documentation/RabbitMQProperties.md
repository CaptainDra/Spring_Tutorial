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
当想把多个值绑定到全部channel的时候，为了避免重复，可以使用[spring.cloud.stream.rabbit.default.<property>=<value>]来设置     
然后具体的设置会覆盖这个

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
对于分区目标，-<instanceIndex> 附加到每个键。    

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
默认值: 1    
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

### Rabbit Producer Properties ###
配置生产者的时候可以用到，配置的时候前缀均为[spring.cloud.stream.rabbit.bindings.<channelName>.producer.]格式    
当想把多个值绑定到全部channel的时候，为了避免重复，可以使用[spring.cloud.stream.rabbit.default.<property>=<value>]来设置    
具体的设置会覆盖这个默认设置

#### autoBindDlq ####
默认值: false    
是否自动声明死信队列    

#### batchingEnabled ####
默认值: false    
是否启用生产者消息批处理，设为[true]后需要调整这三个参数:[batchSize], [batchBufferLimit], [batchTimeout]

#### batchSize ####
默认值: 100    
当允许批处理时，送到buffer的消息数量    

#### batchBufferLimit
默认值: 10000    
当允许批处理时，最大buffer容量

#### batchTimeout ####
默认值: 5000    
当允许批处理时，批处理超时时间

#### bindingRoutingKey ####
默认值: #    
用于将queue绑定到exchange的routing key(路由密钥)（如果 bindQueue 为 true）
可以是多个key,详见[bindingRoutingKeyDelimiter]    
对于分区目标，[-n] 附加到每个键后边    
仅在提供 requiredGroups 时才适用，然后仅适用于这些group

#### bindingRoutingKeyDelimiter ####
默认值: null    
当不为空，bindingRoutingKey为一个被该值分隔的list，这个值通常为逗号    
仅在提供 requiredGroups 时才适用，然后仅适用于这些group    

#### bindQueue ####
默认值: true.
是否声明queue并将其绑定到目标exchange。如果已经设置了自己的基础设施并且之前已经创建并绑定了queue，则将其设置为 false    
仅在提供 requiredGroups 时才适用，然后仅适用于这些group

#### compress ####
默认值: false    
数据发送时是否需要压缩

#### confirmAckChannel ####
默认值: nullChannel (acks are discarded)        
当 [errorChannelEnabled] 为 [true] 时，向其发送交付确认（发布者确认）的通道    
如果channel不存在，则使用此名称注册 DirectChannel    
必须配置connection factory以启用publisher confirms

#### deadLetterQueueName ####
默认值: prefix+destination.dlq    
死信队列的名称仅在提供 requiredGroups 时才适用，然后仅适用于这些组。

#### deadLetterExchange ####
默认值: 'prefix+DLX'    
分配给队列的 DLX。仅当 autoBindDlq 为真时相关     
仅在提供 requiredGroups 时适用，然后仅适用于这些组

#### deadLetterExchangeType ####
默认值: 'direct'    
要分配给队列的 DLX 的类型    
仅当 [autoBindDlq] 为 [true] 时才相关    
仅在提供 requiredGroups 时适用，然后仅适用于这些组。

#### deadLetterRoutingKey ####
默认值: destination    
分配给死信队列的路由键。仅当 [autoBindDlq] 为 [true]时相关。    
仅在提供 requiredGroups 时适用，然后仅适用于这些组。    

#### declareDlx ####
默认值: true  
Whether to declare the dead letter exchange for the destination. Relevant only if autoBindDlq is true. Set to false if you have a pre-configured DLX. Applies only when requiredGroups are provided and then only to those groups.

#### declareExchange ####
默认值: true     
Whether to declare the exchange for the destination.

#### delayExpression ####
A SpEL expression to evaluate the delay to apply to the message (x-delay header). It has no effect if the exchange is not a delayed message exchange.

默认值: No x-delay header is set.

#### delayedExchange ####
Whether to declare the exchange as a Delayed Message Exchange. Requires the delayed message exchange plugin on the broker. The x-delayed-type argument is set to the exchangeType.

默认值: false.

#### deliveryMode ####
The delivery mode.

默认值: PERSISTENT.

#### dlqBindingArguments ####
Arguments applied when binding the dlq to the dead letter exchange; used with headers deadLetterExchangeType to specify headers to match on. For example …​dlqBindingArguments.x-match=any, …​dlqBindingArguments.someHeader=someValue. Applies only when requiredGroups are provided and then only to those groups.

默认值: empty

#### dlqDeadLetterExchange ####
When a DLQ is declared, a DLX to assign to that queue. Applies only if requiredGroups are provided and then only to those groups.

默认值: none

#### dlqDeadLetterRoutingKey ####
When a DLQ is declared, a dead letter routing key to assign to that queue. Applies only when requiredGroups are provided and then only to those groups.

默认值: none

#### dlqExpires ####
How long (in milliseconds) before an unused dead letter queue is deleted. Applies only when requiredGroups are provided and then only to those groups.

默认值: no expiration

#### dlqLazy ####
Declare the dead letter queue with the x-queue-mode=lazy argument. See “Lazy Queues”. Consider using a policy instead of this setting, because using a policy allows changing the setting without deleting the queue. Applies only when requiredGroups are provided and then only to those groups.

#### dlqMaxLength ####
Maximum number of messages in the dead letter queue. Applies only if requiredGroups are provided and then only to those groups.

默认值: no limit

#### dlqMaxLengthBytes ####
Maximum number of total bytes in the dead letter queue from all messages. Applies only when requiredGroups are provided and then only to those groups.

默认值: no limit

#### dlqMaxPriority ####
Maximum priority of messages in the dead letter queue (0-255) Applies only when requiredGroups are provided and then only to those groups.

默认值: none

#### dlqQuorum.deliveryLimit ####
When quorum.enabled=true, set a delivery limit after which the message is dropped or dead-lettered. Applies only when requiredGroups are provided and then only to those groups.

默认值: none - broker default will apply.

#### dlqQuorum.enabled ####
When true, create a quorum dead letter queue instead of a classic queue. Applies only when requiredGroups are provided and then only to those groups.

默认值: false

#### dlqQuorum.initialQuorumSize ####
When quorum.enabled=true, set the initial quorum size. Applies only when requiredGroups are provided and then only to those groups.

默认值: none - broker default will apply.

#### dlqSingleActiveConsumer ####
Set to true to set the x-single-active-consumer queue property to true. Applies only when requiredGroups are provided and then only to those groups.

默认值: false

#### dlqTtl ####
Default time (in milliseconds) to live to apply to the dead letter queue when declared. Applies only when requiredGroups are provided and then only to those groups.

默认值: no limit

#### exchangeAutoDelete ####
If declareExchange is true, whether the exchange should be auto-delete (it is removed after the last queue is removed).

默认值: true.

#### exchangeDurable ####
If declareExchange is true, whether the exchange should be durable (survives broker restart).

默认值: true.

#### exchangeType ####
The exchange type: direct, fanout, headers or topic for non-partitioned destinations and direct, headers or topic for partitioned destinations.

默认值: topic.

#### expires ####
How long (in milliseconds) before an unused queue is deleted. Applies only when requiredGroups are provided and then only to those groups.

默认值: no expiration

#### headerPatterns ####
Patterns for headers to be mapped to outbound messages.

默认值: ['*'] (all headers).

#### lazy ####
Declare the queue with the x-queue-mode=lazy argument. See “Lazy Queues”. Consider using a policy instead of this setting, because using a policy allows changing the setting without deleting the queue. Applies only when requiredGroups are provided and then only to those groups.

默认值: false.

#### maxLength ####
Maximum number of messages in the queue. Applies only when requiredGroups are provided and then only to those groups.

默认值: no limit

#### maxLengthBytes ####
Maximum number of total bytes in the queue from all messages. Only applies if requiredGroups are provided and then only to those groups.

默认值: no limit

#### maxPriority ####
Maximum priority of messages in the queue (0-255). Only applies if requiredGroups are provided and then only to those groups.

默认值: none

#### prefix ####
A prefix to be added to the name of the destination exchange.

默认值: "".

#### queueBindingArguments ####
Arguments applied when binding the queue to the exchange; used with headers exchangeType to specify headers to match on. For example …​queueBindingArguments.x-match=any, …​queueBindingArguments.someHeader=someValue. Applies only when requiredGroups are provided and then only to those groups.

默认值: empty

#### queueNameGroupOnly ####
When true, consume from a queue with a name equal to the group. Otherwise the queue name is destination.group. This is useful, for example, when using Spring Cloud Stream to consume from an existing RabbitMQ queue. Applies only when requiredGroups are provided and then only to those groups.

默认值: false.

#### quorum.deliveryLimit ####
When quorum.enabled=true, set a delivery limit after which the message is dropped or dead-lettered. Applies only when requiredGroups are provided and then only to those groups.

默认值: none - broker default will apply.

#### quorum.enabled ####
When true, create a quorum queue instead of a classic queue. Applies only when requiredGroups are provided and then only to those groups.

默认值: false

#### quorum.initialQuorumSize ####
When quorum.enabled=true, set the initial quorum size. Applies only when requiredGroups are provided and then only to those groups.

默认值: none - broker default will apply.

#### routingKeyExpression ####
A SpEL expression to determine the routing key to use when publishing messages. For a fixed routing key, use a literal expression, such as routingKeyExpression='my.routingKey' in a properties file or routingKeyExpression: '''my.routingKey''' in a YAML file.

默认值: destination or destination-<partition> for partitioned destinations.

#### singleActiveConsumer ####
Set to true to set the x-single-active-consumer queue property to true. Applies only when requiredGroups are provided and then only to those groups.

默认值: false

#### transacted ####
Whether to use transacted channels.

默认值: false.

#### ttl ####
Default time (in milliseconds) to live to apply to the queue when declared. Applies only when requiredGroups are provided and then only to those groups.

默认值: no limit