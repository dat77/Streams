package com.gmail.students;

import java.util.List;

public class MilitaryDepartment {
	
	
	public void getInfo(MilitaryConscription students) {
		List<Student> conscripts = students.getConscripts();
		StringBuilder stringBuilder = new StringBuilder("Conscripts:\n");
		for (Student student : conscripts) {
			if (student != null) {
				stringBuilder.append(student + "\n");
			}
		}
		System.out.println(stringBuilder.toString());
	}

}
