package com.anurag.restaurant;

import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.ws.rs.core.Response.StatusType;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RestaurantServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantServiceApplication.class, args);
	}

	//how to choose the thread pool count? since too many threads increase memory consumption
	//if you need to execute tasks which involve a lot of computation eg compression algo but No IO operations
	//then you should keep the number of threads equal to the number of processor, because your threads won't be waiting
	//but for IO intensive tasks like you have a lot of read write operations in DB or calling an API over network using HTTP protocol,
	//your threads might be in a wait state for sometime to get a response over network or from database
	//then a good strategy is to use 2 multiplier or 4 multiplier
	//so if you have 4 processors, and your code involves IO operations, take 8 or 16 threads
	//P.S. int coreCount = Runtime.getRuntime().availableProcessors();
	public static final int THREADS_COUNT=8;

	public void processRecords() throws InterruptedException, BrokenBarrierException {
		Vector<Integer> vector  = new Vector<>(); //Replace Integer in the type argument by your Record POJO
		vector.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10)); 
		//Taken Integers for simplicity
		//For a count of 1 lakh records, we will be processing records in chunk, say 100 records at a time

		Runnable barrierAction = () -> System.out.println("success");
		CyclicBarrier barrier = new CyclicBarrier(THREADS_COUNT + 1, barrierAction); //thread count injected as 5 

		ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);
		for(Integer record:vector) {
			//vector will be shared resource for all the tasks
			//we are creating 100 tasks for 8 threads to execute concurrently
			executorService.execute((new RenewalRunnable(barrier , vector /*, failedRccounts */)));
			/* ThreadPoolExecutor, implementation of ExecutorService, internally uses a BlockingQueue and ReentrantLock  */
			//in this blocking queues, all the tasks are stored and executed in a thread safe way
		}

		//why cyclic barrier is used?
		//if not used, your main thread will jump on to pick other chunk of 100 records and more number of threads might get created
		//even though your previously created threads are still using CPU
		//so you want a mechanism where you pick 100 records and process them first, before proceeding with the next chunk of records
		//this barrier ensures that main thread will wait at the barrier for the remaining 8 threads to call await method on barrier
		//So until all the other 8 threads(from thread pool) have finished their tasks and call the await method on barrier,
		//the other finished threads will wait at the barrier along with main thread
		//and after all threads have called await method, barrier will trip and barrier action will be executed
		barrier.await();
	}

}


class RenewalRunnable implements Runnable{

	CyclicBarrier barrier = null;
	Vector<Integer> vector = null;
	public RenewalRunnable(CyclicBarrier barrier, Vector<Integer> vector) {
		this.barrier=barrier;
		this.vector=vector;
	}

	@Override
	public void run() {
		boolean isRecordAvailable = true;
		while(isRecordAvailable) {
			Integer record = getRecordFromVector(vector);
			if(record!=null) {
				//process the record, update the record

				//if there is any exception while processing the record
				//catch the ex, update the failed records list and invoke barrier.await() method
			}else {
				isRecordAvailable=false;
			}
		}
		barrier.await();
	}

	private Integer getRecordFromVector(Vector<Integer> vector) {
		if(vector.size() > 0)
			return vector.remove(0);
		return null;
	}

}
