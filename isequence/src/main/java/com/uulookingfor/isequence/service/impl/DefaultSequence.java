package com.uulookingfor.isequence.service.impl;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.uulookingfor.isequence.SequenceConstants;
import com.uulookingfor.isequence.dao.SequenceDao;
import com.uulookingfor.isequence.dao.domain.SequenceDO;
import com.uulookingfor.isequence.dao.domain.SequenceQuery;
import com.uulookingfor.isequence.dao.domain.SequenceUpdateDO;
import com.uulookingfor.isequence.dao.ibatis.SequenceDaoImpl;
import com.uulookingfor.isequence.service.Sequence;
import com.uulookingfor.isequence.service.exception.OutOfBottomRangeException;
import com.uulookingfor.isequence.service.exception.OutOfUpRangeException;
import com.uulookingfor.isequence.service.exception.SequenceException;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author suxiong.sx
 */
public class DefaultSequence implements Sequence, SequenceConstants{

    //private Logger log = LoggerFactory.getLogger(DefaultSequence.class.getName());

	private final Lock lock = new ReentrantLock();
	
    @Getter @Setter private SequenceDao sequenceDao = new SequenceDaoImpl();
    
    @Getter @Setter private String name = DEFAULT_NAME;
    
    @Getter @Setter private Long step = DEFAULT_STEP;
    
    @Getter @Setter private Long min  = DEFAULT_MIN;
    
    @Getter @Setter private Long max  = DEFAULT_MAX;
        
    
	public long nextSequence() throws SequenceException {
		
		lock.lock();
		try {
			long currentSequence = nextSequence(name);

			return currentSequence;
		} finally {
			lock.unlock();
		}
	}

	private long nextSequence(@NonNull String name) throws SequenceException{
		
		SequenceDO sDo = currentSequence();
		
		updateToNextSequence(sDo);
		
		return sDo.getValue();
		
	}
	
	private SequenceDO currentSequence() throws SequenceException{
		
		SequenceQuery query = new SequenceQuery();
		query.setName(name);
		
		List<SequenceDO> searchRet = null;
		try {
			searchRet = sequenceDao.query(query);
		} catch (SQLException e) {
			//log.error("sequenceDao.query exception for name:" + name, e);
			throw new SequenceException("sequenceDao.query exception for name:" + name, e);
		}
		
		if(emptyCollection(searchRet)){
			//log.error("sequenceDao.query empty for name:" + name);
			throw new SequenceException("sequenceDao.query empty for name:" + name);
		}
		
		if(searchRet.size() != 1){
			//log.error("sequenceDao.query size error for name:" + name + ", size:" + searchRet.size());
			throw new SequenceException("sequenceDao.query size error for name:" + name + ", size:" + searchRet.size());
		}
		
		
		Long ret = searchRet.get(0).getValue();
		
		if(ret.longValue() < min.longValue()){
			//log.error("select from db ret < min:" + ret + "<" + min);
			throw new OutOfBottomRangeException("select from db ret < min:" + ret + "<" + min);
		}
		
		if(ret.longValue() > max.longValue()){
			//log.error("select from db ret < max:" + ret + "<" + max);
			throw new OutOfUpRangeException("select from db ret < max:" + ret + "<" + max);
		}
		
		return searchRet.get(0);
	}
		
	private void updateToNextSequence(SequenceDO sDo) throws SequenceException{
		Long oldValue = sDo.getValue();
		Long newValue = nextSequence(oldValue);
		
		if(newValue.longValue() < min.longValue()){
			//log.error("before to db ret < min:" + newValue + "<" + min);
			throw new OutOfBottomRangeException("before to db ret < min:" + newValue + "<" + min);
		}
		
		if(newValue.longValue() > max.longValue()){
			//log.error("before to db ret < max:" + newValue + "<" + max);
			throw new OutOfUpRangeException("before to db ret < max:" + newValue + "<" + max);
		}
		
		SequenceUpdateDO updateDo = new SequenceUpdateDO();
		updateDo.setId(sDo.getId());
		updateDo.setName(name);
		updateDo.setOldValue(oldValue);
		updateDo.setNewValue(newValue);
		
		int updateRet = -1;
		try {
			updateRet = sequenceDao.updateSequence(updateDo);
		} catch (SQLException e) {
			//log.error("sequenceDao.updateSequence exception:" + updateDo, e);
			throw new SequenceException("sequenceDao.updateSequence exception:" + updateDo, e);
		}
		
		if(updateRet <= 0){
			//log.error("sequenceDao.updateSequence unkonw:" + updateDo);
			throw new SequenceException("sequenceDao.updateSequence unkonw:" + updateDo);
		}
	}
	
	private long nextSequence(long ret){
		return ret + step;
	} 
	
	private static boolean emptyCollection(Collection<?> col){
		
		if(col == null || col.isEmpty() || col.size() == 0){
			return true;
		}
		
		return false;
	}
	
}