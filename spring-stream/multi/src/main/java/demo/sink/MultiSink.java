package demo.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * 自定义source interface,为了证明多个intput，output的例子，此处是2个input
 * @author hushuming
 *
 */
public interface MultiSink {
	
	String INPUT1 = "input1";

	String INPUT2 = "input2";

	
	//此处用的是 sub订阅通道
	@Input(INPUT1)
	SubscribableChannel input1();

	@Input(INPUT2)
	SubscribableChannel input2();

}
