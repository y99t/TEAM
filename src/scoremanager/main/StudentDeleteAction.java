package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import bean.Teacher;
import dao.StudentDao;
import tool.Action;
public class StudentDeleteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");
		StudentDao sDao = new StudentDao();
		String no = req.getParameter("no");
		Student student = sDao.get(no);

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

		// レスポンス値をセット
		req.setAttribute("student", student);

		// フォワード
		req.getRequestDispatcher("student_delete.jsp").forward(req, res);
	}
}
