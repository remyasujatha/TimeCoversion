package com.test;

public class TimeConvertion {

	public static void main(String[] args) {

		System.out.println(convertTo24Hour("12:03:01PM"));
		System.out.println(convertTo24Hour("12:03:01AM"));
		System.out.println(convertTo24Hour("01:03:01AM"));
		System.out.println(convertTo24Hour("01:03:01PM"));
	}

	private static String convertTo24Hour(String timeIn12Hr) {
		String result = "";
		String[] spliitedArr = timeIn12Hr.split(":");
		String seconds = spliitedArr[spliitedArr.length - 1];

		String ampm = seconds.substring(seconds.length() - 2, seconds.length());
		if (ampm.toUpperCase().equals("AM") && spliitedArr[0].equals("12")) {
			spliitedArr[0] = "00";
		} else if (ampm.toUpperCase().equals("PM") && !spliitedArr[0].equals("12")) {
			int hours = Integer.parseInt(spliitedArr[0]);
			hours += 12;
			spliitedArr[0] = String.format("%02d", hours);
		}

		spliitedArr[spliitedArr.length - 1] = seconds.substring(0, seconds.length() - 2);
		for (String items : spliitedArr) {
			result = result.concat(items + ":");
		}

		return result.substring(0, result.length() - 1);
	}

}
