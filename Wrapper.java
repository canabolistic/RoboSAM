package Yobit;

import java.util.Scanner;

public class Wrapper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String request = "Ticker";
		System.out.println(Yobit.Wrapper.setRequest(request));
	}

	
	
	public static String setRequest(String request) {

		if (request == "Info") {
			request = "Slected Info";
			return request;
		} else
		if (request == "Depth") {
			request = "Slected Depth";
			return request;
		} else
		if (request == "Ticker") {
			request = "Slected Ticker";
			return request;
		} else 
		if (request == "Trades") {
			request = "Slected Trades";
			return request;
		}
			System.out.println(request);
			request = "Invalid Request";
			return request;
	}

}
