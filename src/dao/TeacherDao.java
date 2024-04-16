package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Teacher;

public class TeacherDao extends Dao {

	public Teacher get(String id) {

	}

	public Teacher login(String id, String password) throws Exception {
		Teacher teacher = null;

		Connection con = getConnection();

		PreparedStatement st;
		st = con.prepareStatement("select * from teacher where id = ? and password = ?");
		st.setString(1, id);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			teacher = new Teacher();
			teacher.setId(id);
			teacher.setPassword(password);
		}

		st.close();
		con.close();
		return teacher;
	}
}
