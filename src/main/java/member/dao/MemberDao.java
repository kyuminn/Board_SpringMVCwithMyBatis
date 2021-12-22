package member.dao;

import member.vo.MemberVo;

public interface MemberDao {
	public abstract void insert(MemberVo vo);
	public abstract String authenticate(String email);
	
}
