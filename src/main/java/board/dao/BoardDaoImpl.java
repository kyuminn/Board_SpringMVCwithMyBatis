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
		return sqlSessionTemplate.selectList("boardDao.list");
	}

	@Override
	public int delete(BoardVo vo) {
		return sqlSessionTemplate.delete("boardDao.delete",vo);
	}

	@Override
	public int deleteAll() {
		return sqlSessionTemplate.delete("boardDao.deleteAll");
	}

	@Override
	public int update(BoardVo vo) {
		return sqlSessionTemplate.update("boardDao.update", vo);
	}

	@Override
	public void insert(BoardVo vo) {
		sqlSessionTemplate.insert("boardDao.insert",vo);
	}

	@Override
	public BoardVo select(int seq) {
		BoardVo vo = sqlSessionTemplate.selectOne("boardDao.select", seq);
		return vo;
	}

	@Override
	public int updateReadCount(int seq) {
		return sqlSessionTemplate.update("boardDao.updateCount", seq);
	}
	
}
