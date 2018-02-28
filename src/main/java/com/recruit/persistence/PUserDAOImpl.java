package com.recruit.persistence;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.recruit.domain.PUserVO;

@Repository
public class PUserDAOImpl implements PUserDAO {
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.recruit.mapper.PUserMapper";
	
	@Override
	public PUserVO selectPUser(String id) throws Exception{
		return session.selectOne(namespace + ".selectPuser", id);
	}
	
	@Override
	public void updatePUser(PUserVO vo) throws Exception{
		session.update(namespace+".updatePUser",vo);
	}

}
