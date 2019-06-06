package com.gmail.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

public class FileHandler {

	public static void copyFile(File sourceFile, File destFile) throws FileAlreadyExistException {
		if (sourceFile == null || destFile == null) {
			throw new IllegalArgumentException();
		}
		if (sourceFile.getAbsolutePath().equalsIgnoreCase(destFile.getAbsolutePath())) {
			throw new FileAlreadyExistException();
		}
		try (FileInputStream fis = new FileInputStream(sourceFile);
				FileOutputStream fos = new FileOutputStream(destFile)) {
			byte[] buffer = new byte[1024];
			int readedBytes = 0;
			while ((readedBytes = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, readedBytes);
			}
			System.out.println(destFile.getName() + " copied!");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String readFromFile(File sourceFile) {
		if (sourceFile == null) {
			throw new IllegalArgumentException();
		}
		StringBuilder stringBuilder = new StringBuilder();
		try (BufferedReader sourceBuffer = new BufferedReader(new FileReader(sourceFile))) {
			String str = "";
			while ((str = sourceBuffer.readLine()) != null) {
				stringBuilder.append(" " + str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}

	public static String[] readFromFileLineByLine(File sourceFile) {
		if (sourceFile == null) {
			throw new IllegalArgumentException();
		}
		StringBuilder stringBuilder = new StringBuilder();
		try (BufferedReader sourceBuffer = new BufferedReader(new FileReader(sourceFile))) {
			String str = "";
			while ((str = sourceBuffer.readLine()) != null) {
				stringBuilder.append(str+"\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringBuilder.toString().split("\n");
	}
	
	
	public static void writeToFile(File destFile, String... strings) {
		if (destFile == null || strings.length == 0) {
			throw new IllegalArgumentException();
		}
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destFile))){
			for (String str : strings) {
				if (str != null && !str.equals("")) {
					bufferedWriter.write(str+",");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeToFileLineByLine(File destFile, String... strings) {
		if (destFile == null || strings.length == 0) {
			throw new IllegalArgumentException();
		}
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destFile))){
			for (String str : strings) {
				if (str != null && !str.equals("")) {
					bufferedWriter.write(str);
					bufferedWriter.newLine();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public static File intersectionFiles(File sourceFile1, File sourceFile2) {
		if (sourceFile1 == null || sourceFile2 == null) {
			throw new IllegalArgumentException();
		}
		String[] dictionary1 = readFromFile(sourceFile1).split("[ .,;:!?]");
		String[] dictionary2 = readFromFile(sourceFile2).split("[ .,;:!?]");
		outer: for (int i = 0; i < dictionary1.length; i++) {
			for (String str : dictionary2) {
				if (dictionary1[i].equalsIgnoreCase(str)) {
					continue outer;
					}
			}
			dictionary1[i]=null;
		}
		String fileName = sourceFile1.getAbsolutePath().substring(0, sourceFile1.getAbsolutePath().lastIndexOf(".")) 
				+ "(intersec).txt";
		File returnFile = new File(fileName); 
		writeToFile(returnFile, dictionary1);
		return returnFile;
	}

}
