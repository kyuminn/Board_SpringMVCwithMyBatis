package board.service;

import java.util.List;

import board.vo.BoardVo;

public interface BoardService {
	public abstract List<BoardVo> list();
	public abstract int delete(BoardVo vo);
	public abstract int edit(BoardVo vo);
	public abstract void write(BoardVo vo);
	public abstract BoardVo read(int seq);
}
