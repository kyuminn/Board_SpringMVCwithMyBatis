package member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import member.vo.MemberVo;

@Repository
public class MemberDaoImpl implements MemberDao{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	public MemberDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public void insert(MemberVo vo) {
		sqlSessionTemplate.insert("memberDao.insert", vo);
	}

	@Override
	public MemberVo authenticate(String email) {
		return sqlSessionTemplate.selectOne("memberDao.authenticate", email);
		
	}

	@Override
	public MemberVo selectByEmail(String email) {
		return sqlSessionTemplate.selectOne("memberDao.selectByEmail",email);
	}

}
