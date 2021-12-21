package member.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberVo {
	private int id;
	private String email;
	private String name;
	private String password;
	
}
