package br.com.spy.eventos.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "LOG_PROCESSO", schema = "EVENTO")
public class LogProcesso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Column(name = "id_processo")
	private String uuid;
	
	@Column(name = "create_at", columnDefinition = "DATE")
	private LocalDate createAt;
	
	@Column(name = "tipo_processo")
	private int tipo;

	public LogProcesso() {
		super();
	}
	
	
}
