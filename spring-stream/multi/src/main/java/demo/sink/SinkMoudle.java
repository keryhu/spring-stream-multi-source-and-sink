package demo.sink;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * 多个接受者sink
 * @author hushuming
 *
 */
@EnableBinding(MultiSink.class)  //binding 自定义的sink interface
public class SinkMoudle {
	
	//第一个接受者
	@StreamListener(MultiSink.INPUT1)
	public synchronized void receive1(Object message) {
		System.out.println("******************");
		System.out.println("At Sink1");
		System.out.println("******************");
		System.out.println("Received message " + message);
	}
	
	  //第二个接受者
		@StreamListener(MultiSink.INPUT2)
		public synchronized void receive2(Object message) {
			System.out.println("******************");
			System.out.println("At Sink2");
			System.out.println("******************");
			System.out.println("Received message " + message);
		}



}
