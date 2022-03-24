package com.junefw.infra.modules.code;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class CodeDao {
	
	@Inject
	@Resource(name = "sqlSession")
	private SqlSession sqlSession;
	
	private static String namespace = "com.junefw.infra.modules.code.CodeMpp";

//	infrCodeGroup
	public int selectOneCount(CodeVo vo) { return sqlSession.selectOne(namespace + ".selectOneCount", vo);}
	public List<Code> selecList(CodeVo vo) { List<Code> list = sqlSession.selectList(namespace + ".selectList", vo); return list; }
	public int insert(Code dto) {return sqlSession.insert(namespace + ".insert", dto);}
	public Code selectOne(CodeVo vo) { return sqlSession.selectOne(namespace + ".selectOne", vo);}
	public int update(Code dto) { return sqlSession.update(namespace + ".update", dto); }
	public int delete(CodeVo vo) { return sqlSession.delete(namespace + ".delete", vo); }
	public int updateDelete(CodeVo vo) {return sqlSession.update(namespace + ".updateDelete", vo);}
	
//	infrCode
	public List<Code> selecListCode(CodeVo vo) { List<Code> list = sqlSession.selectList(namespace + ".selectListCode", vo); return list; }
	public int insertCode(Code dto) {return sqlSession.insert(namespace + ".insertCode", dto);}
	public Code selectOneCode(CodeVo vo) { return sqlSession.selectOne(namespace + ".selectOneCode", vo);}
	public int updateCode(Code dto) { return sqlSession.update(namespace + ".updateCode", dto); }

	public List<Code> selectListForCache() { List<Code> list = sqlSession.selectList(namespace + ".selectListForCache", ""); return list; }
	
}
