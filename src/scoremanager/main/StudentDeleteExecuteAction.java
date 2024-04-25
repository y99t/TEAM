package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.StudentDao;
import tool.Action;

public class StudentDeleteExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");
		String no = req.getParameter("no");
		StudentDao sDao = new StudentDao();

		/* テストデータ
		School school = new School();
		school.setCd("oom");
		school.setName("学校名");
		Teacher teacher = new Teacher();
		teacher.setId("admin");
		teacher.setName("大原花子");
		teacher.setPassword("password");
		teacher.setSchool(school);
		System.out.println(teacher.getSchool());
		*/

		// 学生を削除
		sDao.delete(no);

		// フォワード
		req.getRequestDispatcher("student_delete_done.jsp").forward(req, res);
	}
}
