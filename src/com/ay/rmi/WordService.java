package com.ay.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.ay.rmi.annotation.RmiName;

@RmiName(value = "WordService")
public interface WordService extends Remote {

	String sayWord(String words) throws RemoteException;
}
