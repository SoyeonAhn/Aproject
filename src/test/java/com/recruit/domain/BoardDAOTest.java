package com.recruit.domain;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.recruit.persistence.PUserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"
})

public class BoardDAOTest {
	
	@Inject
	private PUserDAO dao;
	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Test
	public void testUpdate() throws Exception{
		PUserVO puser = new PUserVO();
		puser.setId("jin");
		puser.setPw("0101");
		puser.setPname("수정한 민경");
		puser.setEmail("hello@naver.com");
		puser.setBirth("2018-02-28");
		//p216
		dao.updatePUser(puser);
	}
	@Test
	public void testSelect() throws Exception{
		logger.info(dao.selectPUser("jin").toString());
	}
}
