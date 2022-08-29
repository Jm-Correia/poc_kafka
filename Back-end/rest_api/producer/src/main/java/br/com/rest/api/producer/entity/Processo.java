package br.com.rest.api.producer.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PROCESSO")
public class Processo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_processo")
	private String uuid;
	
	@Column(name = "create_at", columnDefinition = "DATE")
	private LocalDate createAt;
	
	@Column(name = "tipo_processo")
	private int tipo = 1;
	
	@Column(name = "descricao")
	private String descricao;

	public Processo() {
		super();
	}

	public Processo(String uuid, LocalDate createAt, int tipo, String descricao) {
		super();
		this.uuid = uuid;
		this.createAt = createAt;
		this.tipo = tipo;
		this.descricao = descricao;
	}
	
	
}
