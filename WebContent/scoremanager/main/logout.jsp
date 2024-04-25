<%-- ログアウトJSP --%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
	<c:param name="title">
		得点管理システム
	</c:param>

	<c:param name="scripts"></c:param>

	<c:param name="content">
		<section class="logout">
			<p>
				<label>ログアウトしました</label>
			</p>
			<a href="Login.action">ログイン</a>
		</section>
	</c:param>
</c:import>
