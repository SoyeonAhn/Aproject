package com.recruit.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.recruit.domain.AdminResumeVO;
import com.recruit.domain.ResumeVO;

@Repository
public class ResumeDAOImpl implements ResumeDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.recruit.mapper.ResumeMapper";

	@Override
	public AdminResumeVO read(String id) throws Exception {
		return session.selectOne(namespace + ".read", id);
	}

	@Override
	public void update(AdminResumeVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(String id) throws Exception {
		session.delete(namespace + ".delete", id);
	}

	@Override
	public List<AdminResumeVO> listAll(String id) throws Exception {
		return session.selectList(namespace + ".listAll", id);
	}

	@Override
	public void createROne(ResumeVO vo) throws Exception {
		session.insert(namespace + ".createROne", vo);
	}

	@Override
	public ResumeVO readROne(Integer bno) throws Exception {
		return session.selectOne(namespace + ".readROne", bno);
	}

	@Override
	public void updateROne(ResumeVO vo) throws Exception {
		System.out.println("Service updateROne");
		session.update(namespace + ".updateROne", vo);
	}

	@Override
	public void deleteROne(Integer bno) throws Exception {
		System.out.println("dao" + bno);
		session.delete(namespace + ".deleteROne", bno);
	}

	@Override
	public List<ResumeVO> selectRList(String id) throws Exception {
		System.out.println("ResumeDAOImpl selectRList");
		System.out.println("ResumeDAOImpl selectRList" + id);
		return session.selectList(namespace + ".selectRList", id);
	}
	
	@Override
	public void addRimgAttach(String fullName)throws Exception{
		session.insert(namespace+".addRimgAttach", fullName);
	};

}