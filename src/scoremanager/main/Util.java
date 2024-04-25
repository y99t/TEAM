package scoremanager.main;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.ClassNumDao;

public class Util {

	public Teacher getUser(HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");
		return teacher;
	}

	public void setClassNumSet(HttpServletRequest req) throws Exception {
		Teacher teacher = getUser(req);
		ClassNumDao cNumDao = new ClassNumDao();
		String classNum = "";  // 入力されたクラス番号
		LocalDate todaysDate = LocalDate.now();  // LocalDateインスタンスを取得
		int year = todaysDate.getYear();  // 現在の年を取得

		// リクエストパラメーターの取得
		classNum = req.getParameter("class_num");

		// DBからデータ取得
		// ログインユーザーの学校コードをもとにクラス番号の一覧を取得
		List<String> list = cNumDao.filter(teacher.getSchool());
	}

	public void setEntYearSet(HttpServletRequest req) {

	}

	public void setSubjects(HttpServletRequest req) {

	}

	public void setNumSet(HttpServletRequest req) {

	}
}
