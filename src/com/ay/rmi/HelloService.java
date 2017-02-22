package com.ay.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.ay.rmi.annotation.RmiName;

@RmiName("HelloService")
public interface HelloService extends Remote {

	int hello(String name) throws RemoteException;
}
