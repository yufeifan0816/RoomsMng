package com.yff.roomsMng.utils.net;

public class Test {

	public static void main(String[] args) {
		String httpUrl = "http://www.baidu.com/";
		int size = 10;
		String costTimes = "";
		long total = 0;
		for (int i = 0; i < size; i++) {
			long start = System.currentTimeMillis();

			// String s1 =
			// HttpclientCore.doPost(httpsUrl);
			// System.out.println(s1);

			String s2 = HttpclientCore.doPostHttps(httpUrl);
			System.out.println(s2);

			long cost = (System.currentTimeMillis() - start);
			total += cost;
			costTimes += "cost : " + cost + "ms   \n";
			System.out.println(i);
		}
		System.out.println(costTimes);
		System.out.println("total : " + total);

		// 使用pool==>
		// total : 38844 count: 100
		// total : 36039 count: 100
		// total : 32779 count: 100
		// total : 30176 count: 100
		// total : 51002 count: 100
		// total : 33322 count: 100

		//
		// 不使用pool==>
		// total : 60003 count: 100
		// total : 51386 count: 100
		// total : 32143 count: 100
		// total : 36660 count: 100
		// total : 39954 count: 100
		// total : 43646 count: 100

		// doPostHttps
		// total : 53613 count: 100
		// total : 47741 count: 100
		// total : 59493 count: 100
		// total : 80465 count: 100
		// total : 55854 count: 100
	}
}
