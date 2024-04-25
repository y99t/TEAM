package scoremanager.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import bean.Teacher;
import dao.ClassNumDao;
import dao.StudentDao;
import tool.Action;

public class StudentUpdateAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");

		StudentDao sDao = new StudentDao();
		ClassNumDao cDao = new ClassNumDao();
		String no = req.getParameter("no");

		// 入力された学生番号の学生の詳細データを取得
		Student student = sDao.get(no);
		// セッションユーザーの学校のクラス一覧を取得
		List<String> classNumSet = cDao.filter(teacher.getSchool());



		// レスポンス値をセット
		req.setAttribute("ent_year", student.getEntYear());
		req.setAttribute("no", student.getNo());
		req.setAttribute("name", student.getName());
		req.setAttribute("class_num_set", classNumSet);

		// フォワード
		req.getRequestDispatcher("student_update.jsp").forward(req, res);
	}

}
