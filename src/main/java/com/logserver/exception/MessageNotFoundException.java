/**
 * 
 */
package com.logserver.exception;

/**
 * @author durgesh.s
 *
 */
public class MessageNotFoundException extends RuntimeException{
	 private static final long serialVersionUID = 1L;

	    public MessageNotFoundException(String exception) {
	        super(exception);
	    }

}
