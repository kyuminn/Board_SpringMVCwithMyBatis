package board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.dao.BoardDao;
import board.vo.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao= boardDao;
	}
	@Override
	public List<BoardVo> list() {
		return boardDao.list();
	}

	@Override
	public int delete(BoardVo vo) {
		return boardDao.delete(vo);
	}

	@Override
	public int edit(BoardVo vo) {
		return boardDao.update(vo);
	}

	@Override
	public void write(BoardVo vo) {
		boardDao.insert(vo);
	}

	@Override
	public BoardVo read(int seq) {
		return boardDao.select(seq);
	}
	@Override
	public void addReadCnt(int seq) {
		boardDao.updateReadCount(seq);
		
	}

}
