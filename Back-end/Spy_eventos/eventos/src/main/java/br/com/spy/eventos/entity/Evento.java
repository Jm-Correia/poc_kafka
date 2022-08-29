package br.com.spy.eventos.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "LOG_EVENTO", schema = "EVENTO")
@AllArgsConstructor
@Setter
@Getter
public class Evento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "create_at", columnDefinition = "DATE")
	private LocalDate createAT;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "log_processo_id")
	private Long logProcessoId;

	public Evento() {
		super();
	}
	
	
}
