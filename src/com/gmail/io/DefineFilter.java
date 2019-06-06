package com.gmail.io;

import java.io.File;
import java.io.FileFilter;

import javax.swing.JOptionPane;

public class DefineFilter implements FileFilter {

	private String[] extensions;

	public DefineFilter(String... extensions) {
		this.extensions = extensions;
	}

	public DefineFilter() {
		setExtensions(getExtentionsDialog());
	}

	public String[] getExtensions() {
		return extensions;
	}

	public void setExtensions(String... extensions) {
		this.extensions = extensions;
	}

	private boolean isInExtensionsList(String fileName) {
		for (String ext : extensions) {
			if (fileName.endsWith("."+ext)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean accept(File pathname) {
		return isInExtensionsList(pathname.getName());
	}
	
	private String[] getExtentionsDialog() {
//		String input = null;
//		input = JOptionPane.showInputDialog("enter extensions with space \next1 ext2 ...");
		return JOptionPane.showInputDialog("enter extensions with space \next1 ext2 ...").split(" ");
	}

}
