package trong.lixco.util;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class MyException extends Exception {
	private static final long serialVersionUID = 1L;
	public MyException() {

	}
	public MyException(String s) {
		System.out.println("" + s);
	}

	
}
