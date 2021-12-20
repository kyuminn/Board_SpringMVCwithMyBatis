package board.dao;

import java.util.List;

import board.vo.BoardVo;

public interface BoardDao {
	public abstract List<BoardVo> list();
	public abstract int delete(BoardVo vo);
	public abstract int deleteAll();
	public abstract int update(BoardVo vo);
	public abstract void insert(BoardVo vo);
	public abstract BoardVo select(int seq);
	public abstract int updateReadCount(int seq);
}
