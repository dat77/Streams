package com.gmail.io;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileFilter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		JFileChooser sfc = new JFileChooser();
		sfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		JFileChooser dfc = new JFileChooser();
		dfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		try {
			// DefineFilter filter = new DefineFilter("pdf");
			DefineFilter filter = new DefineFilter();
			sfc.showDialog(null, "Choose source folder");
			dfc.showDialog(null, "Choose destination folder");
			File sourceFolder = sfc.getSelectedFile();
			File destFolder = dfc.getSelectedFile();
			File[] files = sourceFolder.listFiles(filter);
			int errorCopies = 0;
			for (File file : files) {
				File destFile = new File(destFolder + "\\" + file.getName());
				System.out.println(file.getName() + " is coping");
				try {
					FileHandler.copyFile(file, destFile);
				} catch (FileAlreadyExistException e) {
					System.out.println(destFile.getName() + " " + e.getMessage());
					errorCopies++;
				}
			}
			System.out.println((files.length - errorCopies) + " files were copied");
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println("Extensions or folders have not been choosed");
		}


		sfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		sfc.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("*.txt", "txt"));
		dfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		dfc.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("*.txt", "txt"));
		sfc.showDialog(null, "Choose first file to intersect");
		dfc.showDialog(null, "Choose second file to intersect");
		File file1 = sfc.getSelectedFile();
		System.out.println(file1.getAbsolutePath());
		File file2 = dfc.getSelectedFile();
		System.out.println(file2.getAbsolutePath());
		//FileHandler.intersectionFiles(new File("Text1.txt"), new File("Text2.txt"));
		System.out.println(FileHandler.intersectionFiles(file1, file2).getAbsolutePath());

	}

}
