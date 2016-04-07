package demo.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 自定义source interface,为了证明多个intput，output的例子，此处是2个output
 * @author hushuming
 *
 */
public interface MultiSource {
	
	String OUTPUT1="output1";
	
	String OUTPUT2="output2";
	
	@Output(OUTPUT1)
	MessageChannel output1();
	
	@Output(OUTPUT2)
	MessageChannel output2();
	
	
	

}
