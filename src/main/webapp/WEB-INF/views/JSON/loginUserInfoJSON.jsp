<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
{
num:${member.num}, 
id:'${member.id}', 
password:'${member.password}', 
name:'${member.name}', 
address:'${member.address}', 
phone:'${member.phone}', 
email:'${member.email}', 
type:${member.type}, 
valid:'${member.valid}'
}