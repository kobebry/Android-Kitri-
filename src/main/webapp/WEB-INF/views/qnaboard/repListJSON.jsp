<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


[
<c:set var="cnt" value="0"/>
<c:forEach var="a" items="${list}">
{num:${a.num}, title:'${a.title}',content:'${a.content}', writer_num:${a.writer_num}, parent_num:${a.parent_num}}<c:if test="${fn:length(list) ne cnt}">,</c:if>
<c:set var="cnt" value="${cnt+1}"/>
</c:forEach>
]