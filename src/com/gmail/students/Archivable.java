package com.gmail.students;

import java.io.File;

public interface Archivable {
	public abstract void saveToFile(File file);
	public abstract void readFromFile(File file);
}
