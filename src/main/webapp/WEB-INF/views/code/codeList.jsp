<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="rb" uri="http://www.springframework.org/tags" %>


<form id="" name="" method="get" action="/infra/code/codeList">
<select name="shIfcgSeq">
	<option value="">::코드그룹::
		<c:forEach items="${listCodeGroup}" var="item" varStatus="status">
	<option value="<c:out value="${item.ifcgSeq }"/>" <c:if test="${param.shIfcgSeq eq item.ifcgSeq }">selected</c:if>><c:out value="${item.ifcgName }"/>
		</c:forEach>
</select>
<input type="submit" name="search">
<br>
<br>

<c:choose>
	<c:when test="${fn:length(list) eq 0}">
		<tr>
			<td class="text-center" colspan="9">There is no data!</td>
		</tr>	
	</c:when>
	<c:otherwise>
		<c:forEach items="${list}" var="item" varStatus="status">	
		
		<c:out value="${item.ifcgSeq}"/> : <c:out value="${item.ifcdSeq}"/> | <a href="/infra/code/codeView?ifcdSeq=<c:out value="${item.ifcdSeq}"/>"><c:out value="${item.ifcdName}"/></a> | 
		<c:choose>
			<c:when test="${item.ifcdDelNy eq 0 }">
				O
			</c:when>
			<c:otherwise>
				X
			</c:otherwise>
		</c:choose>
		<%-- <c:out value="${item.ifcdDelNy}"/>  --%><br>
		
		</c:forEach>
	</c:otherwise>
</c:choose>	 

</form>

<nav aria-label="...">
  <ul class="pagination">
  
<c:if test="${vo.startPage gt vo.pageNumToShow}">
                <li class="page-item"><a class="page-link" href="/infra/code/codeGroupList?thisPage=${vo.startPage - 1}&shOption=<c:out value="${vo.shOption }"/>&shValue=<c:out value="${vo.shValue }"/>">Previous</a></li>
</c:if>
<c:forEach begin="${vo.startPage}" end="${vo.endPage}" varStatus="i">
	<c:choose>
		<c:when test="${i.index eq vo.thisPage}">
                <li class="page-item active"><a class="page-link" href="/infra/code/codeGroupList?thisPage=${i.index}&shOption=<c:out value="${vo.shOption }"/>&shValue=<c:out value="${vo.shValue }"/>">${i.index}</a></li>
		</c:when>
		<c:otherwise>             
                <li class="page-item"><a class="page-link" href="/infra/code/codeGroupList?thisPage=${i.index}&shOption=<c:out value="${vo.shOption }"/>&shValue=<c:out value="${vo.shValue }"/>">${i.index}</a></li>
		</c:otherwise>
	</c:choose>
</c:forEach>     
<c:if test="${vo.endPage ne vo.totalPages}">                
                <li class="page-item"><a class="page-link" href="/infra/code/codeGroupList?thisPage=${vo.endPage + 1}&shOption=<c:out value="${vo.shOption }"/>&shValue=<c:out value="${vo.shValue }"/>">Next</a></li>
</c:if>  

  </ul>
</nav>