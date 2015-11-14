package com.uulookingfor.isequence.dao.ibatis;

import java.sql.SQLException;
import java.util.List;

import com.uulookingfor.isequence.dao.SequenceDao;
import com.uulookingfor.isequence.dao.domain.SequenceDO;
import com.uulookingfor.isequence.dao.domain.SequenceQuery;
import com.uulookingfor.isequence.dao.domain.SequenceUpdateDO;

/**
 * @author suxiong.sx
 */
public class SequenceDaoImpl extends BaseDaoImpl<SequenceDO, SequenceQuery> implements SequenceDao{

    protected String getNameSpace() {
        return "Sequence";
    }


    public long insert(SequenceDO dataObject) throws SQLException {
        Object result = getSqlMapClient().insert(getNameSpace() + ".insert", dataObject);
        return result != null ? (Long) result : 0L;
    }

    public int update(SequenceDO dataObject) throws SQLException {
        return getSqlMapClient().update(getNameSpace() + ".update", dataObject);
    }

	public int updateSequence(SequenceUpdateDO suDo) throws SQLException {
		return getSqlMapClient().update(getNameSpace() + ".updateSequence", suDo);
	}
        
    public int delete(long id) throws SQLException {
        throw new SQLException("remove operation forbidden ");
    }

    @SuppressWarnings("unchecked")
    public List<SequenceDO> query(SequenceQuery query) throws SQLException {
        return getSqlMapClient().queryForList(getNameSpace() + ".query", query);
    }

    public int count(SequenceQuery query) throws SQLException {
        Object result = getSqlMapClient().queryForObject(getNameSpace() + ".count", query);
        return result != null ? (Integer) result : 0;
    }
    
}