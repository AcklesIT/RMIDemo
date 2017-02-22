package com.ay.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import com.ay.rmi.annotation.RmiName;

public class RmiHelper {

	/**
	 * 或者:"//localhost:8888/"
	 */
	private static final String rmi_root = "rmi://localhost:8888/";

	@SuppressWarnings("unchecked")
	public static <T> T getService(Class<T> clazz) {
		try {
			RmiName rmiName = clazz.getAnnotation(RmiName.class);
			if (rmiName == null) {
				return null;
			}
			Remote remote = Naming.lookup(rmi_root + rmiName.value());
			if (remote != null) {
				return (T) remote;
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T extends Remote> void bindService(Class<T> clazz, Remote service) {
		RmiName rmiName = clazz.getAnnotation(RmiName.class);
		if (rmiName == null || "".equals(rmiName.value())) {
			System.err.println(clazz.getSimpleName() + " isn't annotated by @RmiName");
			return;
		}
		System.out.println("rminame : " + rmiName.value());
		try {
			Naming.bind(rmi_root + rmiName.value(), service);
		} catch (MalformedURLException | RemoteException | AlreadyBoundException e) {
			e.printStackTrace();
		}
	}
	
}
