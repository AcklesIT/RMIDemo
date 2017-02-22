package com.ay.rmi.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.ay.rmi.WordService;

public class WordServiceImpl extends UnicastRemoteObject implements WordService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5043915162356570326L;

	public WordServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public String sayWord(String words) throws RemoteException {
		System.err.println("say : " + words);
		return words;
	}

}
