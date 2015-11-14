package com.uulookingfor.isequence.service.exception;

/**
 * @author suxiong.sx
 */
public class SequenceException extends Exception{

	private static final long serialVersionUID = 6621016623573925947L;
	
	public SequenceException(){
		super();
	}
	
	public SequenceException(String message){
		super(message);
	}
	
	public SequenceException(String message, Throwable cause){
		super(message, cause);
	}
	
	public SequenceException(Throwable cause){
		super(cause);
	}
}
