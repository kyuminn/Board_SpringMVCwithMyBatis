package board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.vo.BoardVo;

@Repository
public class BoardDaoImpl implements BoardDao{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public BoardDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate=sqlSessionTemplate;
	}
	@Override
	public List<BoardVo> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(BoardVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BoardVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insert(BoardVo vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BoardVo select(int seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateReadCount(int seq) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
