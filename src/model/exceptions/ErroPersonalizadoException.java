package model.exceptions;

public class ErroPersonalizadoException extends RuntimeException {

	private static final long serialVersionUID = 1L;//RuntimeException -> Não é obriogado a tratar já o Exception deve ser trato (igual o parse)

	public ErroPersonalizadoException(String msg) {//passar uma mensagem para minha excessão
		super(msg);
	}
	
	
	
	
}
