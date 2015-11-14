package com.uulookingfor.isequence.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.uulookingfor.isequence.service.Sequence;
import com.uulookingfor.isequence.service.exception.SequenceException;
import com.uulookingfor.isequence.service.impl.DefaultSequence;

/**
 * @author suxiong.sx
 */
public class SequenceExample {
	
	public static void main(String[] args){
		
		//uuidTest();
		
		selfDefIdTest();
		
	}
	
	private static void uuidTest(){
		final Sequence seq = new DefaultSequence();
		
		ExecutorService excutor = Executors.newFixedThreadPool(10);
		
		for(int i = 0; i<100; i++){
			final long index = i;
			excutor.submit(new Runnable(){
				public void run() {
					try {
						System.out.println(index + ":" + seq.nextSequence());
					} catch (SequenceException e) {
						e.printStackTrace();
					}

				}
			});
		}
	
	}
	
	private static void selfDefIdTest(){
		final DefaultSequence seq = new DefaultSequence();
		
		seq.setMax(100L);
		seq.setMin(1L);
		seq.setName("self_id");
		seq.setStep(5L);
		
		ExecutorService excutor = Executors.newFixedThreadPool(10);
		
		for(int i = 0; i<100; i++){
			final long index = i;
			excutor.submit(new Runnable(){
				public void run() {
					try {
						System.out.println(index + ":" + seq.nextSequence());
					} catch (SequenceException e) {
						e.printStackTrace();
					}

				}
			});
		}
	}
}
