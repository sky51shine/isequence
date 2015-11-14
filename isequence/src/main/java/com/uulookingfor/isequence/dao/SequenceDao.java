package com.uulookingfor.isequence.dao;

import java.sql.SQLException;

import com.uulookingfor.isequence.dao.domain.SequenceDO;
import com.uulookingfor.isequence.dao.domain.SequenceQuery;
import com.uulookingfor.isequence.dao.domain.SequenceUpdateDO;

/**
 * @author suxiong.sx
 */
public interface SequenceDao extends BaseDao<SequenceDO, SequenceQuery>{
	int updateSequence(SequenceUpdateDO suDo) throws SQLException;
}