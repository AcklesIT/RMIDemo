package com.ay.rmi.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import com.ay.rmi.HelloService;
import com.ay.rmi.RmiHelper;
import com.ay.rmi.WordService;
import com.ay.rmi.impl.HelloServiceImpl;
import com.ay.rmi.impl.WordServiceImpl;

public class RmiServer {

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(8888);
			RmiHelper.bindService(WordService.class, new WordServiceImpl());
			RmiHelper.bindService(HelloService.class, new HelloServiceImpl());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
