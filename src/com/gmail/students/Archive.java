package com.gmail.students;

import java.io.File;

import javax.swing.JFileChooser;

public class Archive {

	public void saveObjectToFile(Archivable archivableObject) {
		JFileChooser dfc = new JFileChooser();
		if (dfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			archivableObject.saveToFile(dfc.getSelectedFile());
		}
	}
	
	public void readObjectFromFile(Archivable archivableObject) {
		JFileChooser dfc = new JFileChooser();
		if (dfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			archivableObject.readFromFile(dfc.getSelectedFile());
		}
	}
	
	

}
