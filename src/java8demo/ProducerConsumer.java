
package java8demo;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

public class ProducerConsumer {
	protected static LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);
	
	
	public static void main(String[] args) {
		Producer producer = new Producer();
		producer.start();
		new Consumer(producer).start();
		//new Consumer(producer).start();
		//new Consumer(producer).start();

	}
	
	
}


class Producer extends Thread{
	public Producer() {
		System.out.println("Producer started");
	}
	@Override
	public void run() {
		
		IntStream.range(0, 10).forEach(t -> ProducerConsumer.queue.offer(t));
				
		IntStream.range(11, 100).forEach(t -> {			
			try {
				ProducerConsumer.queue.put(t);
				if(t >= 20) {
					Thread.sleep(10000l);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		//ProducerConsumer.queue.add - throws error when queue reach its capacity 
		
	}
}

class Consumer extends Thread {
	private Producer producer;
	
	public Consumer(Producer producer) {
		System.out.println("Consumer started");
		this.producer = producer;
	}
	
	@Override
	public void run() {
		while(producer.isAlive()) {
			try {
				System.out.println(ProducerConsumer.queue);
				System.out.println(Thread.currentThread().getName() +" Received -->  "+ProducerConsumer.queue.take());
				Thread.sleep(2000l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
