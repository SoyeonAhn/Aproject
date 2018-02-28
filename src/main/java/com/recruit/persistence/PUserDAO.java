package com.recruit.persistence;

import com.recruit.domain.PUserVO;

public interface PUserDAO {
	
	public PUserVO selectPUser(String id) throws Exception;
	
	public void updatePUser(PUserVO vo) throws Exception;
	
}
