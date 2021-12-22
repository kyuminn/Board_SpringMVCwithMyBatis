package member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.dao.MemberDao;
import member.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public void regist(MemberVo vo) {
		memberDao.insert(vo);
	}

	@Override
	public MemberVo authenticate(String email) {
		return memberDao.authenticate(email);
	}


}
