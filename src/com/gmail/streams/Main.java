package com.gmail.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;


public class Main {

	public static void main(String[] args) {

		/**
		 * 2. Напишите метод, который найдет в массиве целых чисел число, модуль
		 * которого ближе всего к 0. Если есть два таких числа (например 2 и -2),
		 * верните положительное.
		 */
		int[] array = { 2, 6, 3, -1, 8, 2, 3, 4, 5, 1, -1, -2, 4 };
		System.out.println(getNearestToZero(array));

		/**
		 * 3. На основе строки сгенерируйте массив целых чисел, где каждое число должно
		 * быть ASCII кодом соответствующей буквы.
		 */
		String inputStr = "nam primum, si facta mihi revocare liceret, non coepisse fuit: coepta expugnare secundum est";
		int[] asciiCodes = getAsciiFromStr(inputStr);
		System.out.println(Arrays.toString(asciiCodes));

		/**
		 * 4. Найдите максимальное число из набора чисел, которые хранятся в текстовом
		 * файле.
		 */
		System.out.println(getMaxFromFile("a.txt"));

	}

	private static int getMaxFromFile(String fileName) {
		int massimo;
		try {
			massimo = Files.lines(Paths.get(fileName))
					.flatMap(n -> Arrays.stream(n.split(" |;|\\.|,|\\?|!|\\:")))
					.filter(n -> n.matches("\\-?\\d+"))
					.mapToInt(n -> Integer.valueOf(n))
					.max().getAsInt();
			return massimo;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	private static int[] getAsciiFromStr(String inputStr) {
		return inputStr.chars() // .toArray();
				.mapToObj(n -> Integer.valueOf(n))
				.mapToInt(n -> n)
				.toArray();
	}

	private static int getNearestToZero(int[] array) {
		Optional<Integer> mod0 = Arrays.stream(array)
				.mapToObj(n -> n)
				.min((x, y) -> {
			if (Math.abs(x) == Math.abs(y)) {
				return (x >= y) ? 0 : 1;
			} else {
				return Math.abs(x) - Math.abs(y);
			}
		});
		return mod0.get();
	}

}
