package board.vo;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Alias("vo")
public class BoardVo {
	private int seq;
	private String title;
	private String content;
	private String writer;
	private int password;
	private Timestamp regdate;
	private int cnt;
	
	public BoardVo(String title, String content,String writer, int password) {
		this.title=title;
		this.content=content;
		this.writer=writer;
		this.password=password;
		this.cnt=0;
	}
}
