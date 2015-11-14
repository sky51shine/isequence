package com.uulookingfor.isequence.service;

import com.uulookingfor.isequence.service.exception.SequenceException;

/**
 * @author suxiong.sx
 */
public interface Sequence {
	
	long nextSequence() throws SequenceException;
	
}

