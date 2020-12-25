package myweb.algorithm.exception;

public class NoDataException extends RuntimeException{
    /**
	 *
	 */
	private static final long serialVersionUID = 1919186923890154284L;

	public NoDataException(String msg, Throwable t) {
        super(msg, t);
    }

    public NoDataException(String msg) {
        super(msg);
    }

    public NoDataException() {
        super();
    }
}
