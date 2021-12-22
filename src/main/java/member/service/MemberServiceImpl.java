package member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.dao.MemberDao;
import member.exception.DuplicateEmailException;
import member.exception.MemberNotFoundException;
import member.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public void regist(MemberVo vo) {
		MemberVo dbVo = memberDao.selectByEmail(vo.getEmail());
		if(dbVo!=null) {
			throw new DuplicateEmailException();
		}
		memberDao.insert(vo);
	}

	@Override
	public MemberVo authenticate(String email) {
		MemberVo vo = memberDao.selectByEmail(email);
		if(vo==null) {
			throw new MemberNotFoundException();
		}
		return memberDao.authenticate(email);
	}

	@Override
	public MemberVo selectByEmail(String email) {
		return memberDao.selectByEmail(email);
	}


}
