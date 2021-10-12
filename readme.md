# Java小工具
[SpringCould Stream官方文档](https://docs.spring.io/spring-cloud-stream-binder-rabbit/docs/3.0.8.RELEASE/reference/html/spring-cloud-stream-binder-rabbit.html#_rabbitmq_consumer_properties)    
[参考文档](Documentation)
- [RabbitMQ-Listener-demo](ListenerStream)
    - 可以急速测试上手的消费者，可以接受并打印消息队列中的Payload区域
- [Basic_RabbitMQ](Basic_RabbitMQ)
    - 一个基础的实现一对一的生产者消费者队列,包括接口包装的全流程消息队列     
- [Message_Partition](Message_Partition)    
    - 消息分区与条件消费实例: 可用来实现多个消息队列负载均衡