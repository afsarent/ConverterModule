package co.entrar.exam.ConverterModule.exception;

import java.io.IOException;

public class QRCodeAlreadyExistsException extends IOException{
	public QRCodeAlreadyExistsException(String string) {
		super(string);
	}
	public static long QRCODE_EXCEPTION_IDENTIFIER=1288L;
	private static final long serialVersionUID = QRCODE_EXCEPTION_IDENTIFIER;

}
