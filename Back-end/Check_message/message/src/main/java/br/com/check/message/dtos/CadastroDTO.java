package br.com.check.message.dtos;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastroDTO {

	private String idProcesso;
	
	private String name;
	
	private String lastName;
	private LocalDate dtNascimento;
	
	private Integer querSeguro = 0;
	private String descricao;

}
