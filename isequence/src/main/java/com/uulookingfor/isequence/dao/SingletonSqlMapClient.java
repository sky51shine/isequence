package com.uulookingfor.isequence.dao;

import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.uulookingfor.isequence.SequenceConstants;

/**
 * @author suxiong.sx
 */
public class SingletonSqlMapClient implements SequenceConstants{
	
	private static SqlMapClient sqlMapClient     = null;
	
	private static String 		sqlmapConfigFile = DEFAULT_SQLMAP_CONFIG;
	
	public static SqlMapClient getInstance(){
		
		if(sqlMapClient == null){
			init();
		}
		
		if(sqlMapClient == null){
			
			throw new RuntimeException("sqlMapClient has not inited ");
			
		}
		
		return sqlMapClient;
	}
	
	public static void init(){
		
		if(sqlMapClient != null){
			return ;
		}
		
		try {
			
            String resource = sqlmapConfigFile;
            
            Reader reader = Resources.getResourceAsReader(resource);
            
            sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
            
        } catch (Exception e) {
        	
            throw new RuntimeException("error initializing SqlConfig class. Cause: " + e);
            
        }
	}
	
	private SingletonSqlMapClient(){}
	
	public static void main(String[] args){
		
	}
}
