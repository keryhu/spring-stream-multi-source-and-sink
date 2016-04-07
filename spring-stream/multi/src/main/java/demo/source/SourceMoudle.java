package demo.source;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

/**
 * 本例子是证明多个source，sink 的例子，所以，此处用了2个发送的source
 * @author hushuming
 *
 */
@EnableBinding(MultiSource.class) //binding 的是 自己创建的 source output interface
public class SourceMoudle {
	
	
	
	@Bean
	//映射到自己创建的output1 messageChannel
	@InboundChannelAdapter(value = MultiSource.OUTPUT1, poller = @Poller(fixedDelay = "1000", maxMessagesPerPoll = "1"))
	//因为是多个messageSource一同，所以此处加了synchronized，同步锁
	public synchronized MessageSource<String> messageSource1() {
		
		return new MessageSource<String>() {
			public Message<String> receive() {
				String message = "FromSource1";
				System.out.println("******************");
				System.out.println("From Source1");
				System.out.println("******************");
				System.out.println("Sending value: " + message);
				return MessageBuilder.withPayload(message).build();
			}
		};
	}
	
	//第二个source 
	@Bean
	//映射到自己创建的output1 messageChannel
	@InboundChannelAdapter(value = MultiSource.OUTPUT2, poller = @Poller(fixedDelay = "1000", maxMessagesPerPoll = "1"))
	//因为是多个messageSource一同，所以此处加了synchronized，同步锁
	public synchronized MessageSource<String> messageSource2() {
		
		return new MessageSource<String>() {
			public Message<String> receive() {
				String message = "FromSource2";
				System.out.println("******************");
				System.out.println("From Source2");
				System.out.println("******************");
				System.out.println("Sending value: " + message);
				return MessageBuilder.withPayload(message).build();
			}
		};
	}
	


}
