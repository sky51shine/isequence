package com.uulookingfor.isequence.dao.ibatis;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uulookingfor.isequence.dao.BaseDao;
import com.uulookingfor.isequence.dao.SingletonSqlMapClient;
/**
 * @author suxiong.sx
 */
public abstract class BaseDaoImpl<T, Q> implements BaseDao<T, Q>{

	protected SqlMapClient getSqlMapClient(){
		
		return SingletonSqlMapClient.getInstance();
		
	}
}
