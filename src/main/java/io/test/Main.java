package io.test;

import static spark.Spark.*;

public class Main {
	static int i = 1;

	public static void main(String[] args) {
		threadPool(1000000, 1, 10000);
		port(80);
		get("/", (req, res) -> {
			System.out.println(i++);
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(10000);
			return "WORKED";
		});
		get("/cpu", (req, res) -> {
			System.out.println(i++);
			for (int j = 6; j < 1000; j++) {
				j = j / 2;
				System.out.println(j);
				j = j * 2;
				System.out.println(j);
				j = j + 2;
				System.out.println(j);
			}
			return "WORKED";
		});
	}
}