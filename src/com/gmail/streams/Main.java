package com.gmail.streams;

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
		Optional<Integer> mod0 = Arrays.stream(array).mapToObj(n -> n).min((x, y) -> {
			if (Math.abs(x) == Math.abs(y)) {
				return (x >= y) ? 0 : 1;
			} else {
				return Math.abs(x) - Math.abs(y);
			}
		});
		System.out.println(mod0.get());
		
		
		
		
	}

}
