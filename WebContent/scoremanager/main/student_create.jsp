<%-- 学生登録JSP --%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
	<c:param name="title">
		得点管理システム
	</c:param>

	<c:param name="scripts"></c:param>

	<c:param name="content">
		<section class="me-4">
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">学生情報登録</h2>
			<form action="StudentCreateExecute.action" method="post">
				<label>入学年度</label>
				<select name="ent_year">
					<option value="0">--------</option>
					<c:forEach var="year" items="${ent_year_set}">
						<option value="${year}">${year}</option>
					</c:forEach>
				</select>
				<div>入学年度を選択してください</div>
				<label>学生番号</label>
				<input type="text" name="no" value="${no}" maxlength="10" required placeholder="学生番号を入力してください">
				<label>氏名</label>
				<input type="text" name="name" value="${name}" maxlength="30" required placeholder="氏名を入力してください">
				<label>クラス</label>
				<select name="class_num">
					<option value="0">--------</option>
					<c:forEach var="num" items="${class_num}">
						<option value="${num}">${num}</option>
					</c:forEach>
				</select>
				<button type="submit" name="end">登録して終了</button>
			</form>
			<a href="StudentList.action">戻る</a>
		</section>
	</c:param>
</c:import>
