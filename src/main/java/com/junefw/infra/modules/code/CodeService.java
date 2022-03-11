package com.junefw.infra.modules.code;

import java.util.List;

public interface CodeService {
	
//	infrCodeGroup
	public List<Code> selectList(CodeVo vo) throws Exception; 
	public int insert(Code dto) throws Exception;
	public Code selectOne(CodeVo vo) throws Exception;
	public int update(Code dto) throws Exception;
	
//	infrCode
	public List<Code> selectListCode(CodeVo vo) throws Exception; 
	public int insertCode(Code dto) throws Exception;
	public Code selectOneCode(CodeVo vo) throws Exception;
	public int updateCode(Code dto) throws Exception;

}
