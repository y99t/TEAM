package dao;

import java.sql.ResultSet;

import javax.security.auth.Subject;

import bean.School;
import bean.Student;

public class TestDao extends Dao {

	private String baseSql;

	public Test get(Student student, Subject subject, School school, int no) {

	}

	private List<Test> postFilter(ResultSet rSet, School school) {

	}

	public List<Test> filter(int entYear, String classNum, Subject, subject, int num, School school) {

	}

	public boolean save(List<Test> list) {

	}

	private boolean save(Test test, Connection connection) {

	}

	public boolean delete(List<Test> list) {

	}

	private boolean delete(Test test, Connection connetion) {

	}
}
