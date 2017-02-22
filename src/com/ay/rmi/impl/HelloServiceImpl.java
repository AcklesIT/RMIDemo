package com.ay.rmi.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.ay.rmi.HelloService;

public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1675884906605155041L;

	public HelloServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public int hello(String name) {
		System.err.println("Hello " + name);
		return 100;
	}

}
