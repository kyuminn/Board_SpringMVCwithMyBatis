package member.dao;

import member.vo.MemberVo;

public interface MemberDao {
	public abstract void insert(MemberVo vo);
	public abstract MemberVo authenticate(String email);
	public abstract MemberVo selectByEmail(String email);
	
}
