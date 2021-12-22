package member.service;

import member.vo.MemberVo;

public interface MemberService {
	public abstract void regist(MemberVo vo);
	public abstract MemberVo authenticate(String email);
	public abstract MemberVo selectByEmail(String email);
}
