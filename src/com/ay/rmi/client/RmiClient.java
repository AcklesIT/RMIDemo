package com.ay.rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Arrays;

import com.ay.rmi.HelloService;
import com.ay.rmi.RmiHelper;
import com.ay.rmi.WordService;

public class RmiClient {

	public static void main(String[] args) {
		try {
			String[] strings = Naming.list("//localhost:8888");
			System.out.println(Arrays.toString(strings));
			HelloService remote = RmiHelper.getService(HelloService.class);
			int hello = remote.hello("ack");
			System.out.println("result : " + hello);
			System.out.println(RmiHelper.getService(WordService.class).sayWord("Hello bbs"));
		} catch (MalformedURLException | RemoteException e) {
			e.printStackTrace();
		}
	}
}
