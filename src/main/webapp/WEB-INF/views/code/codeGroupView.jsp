<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="rb" uri="http://www.springframework.org/tags" %>

<c:out value="${item.ifcgSeq}"/> | <c:out value="${item.ifcgName}"/> | <c:out value="${item.ifcgDelNy}"/> <br>

<a href="/infra/code/codeGroupList?thisPage=<c:out value="${vo.thisPage }"/>&shOption=<c:out value="${vo.shOption }"/>&shValue=<c:out value="${vo.shValue }"/>">목록</a>
<a href="/infra/code/codeGroupForm2?ifcgSeq=<c:out value="${item.ifcgSeq}"/>">수정</a>