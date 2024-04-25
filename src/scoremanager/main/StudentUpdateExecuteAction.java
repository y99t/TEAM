package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import bean.Teacher;
import dao.StudentDao;
import tool.Action;

public class StudentUpdateExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");

		//
		Student student = new Student();
		StudentDao sDao = new StudentDao();
		String no = req.getParameter("no");
		String name = req.getParameter("name");
		String entYearStr = req.getParameter("ent_year");
		String classNumStr = req.getParameter("class_num");
		String isAttendStr = req.getParameter("is_attend");
		int entYear = Integer.parseInt(entYearStr);
		int classNum = Integer.parseInt(classNumStr);
		boolean isAttend = true;

		if (isAttendStr == null) {
			isAttend = false;
		}

		student.setName(name);
		student.setEntYear(entYear);
		student.setClassNum(classNumStr);
		student.setAttend(isAttend);
		student.setNo(no);

		// 更新
		sDao.save(student);

		// フォワード
		req.getRequestDispatcher("student_update_done.jsp").forward(req, res);
	}

}
