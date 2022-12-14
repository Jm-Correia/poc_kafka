
CREATE TABLE TIPO_PROCESSO(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(50) NOT NULL,
    create_at TIMESTAMP NOT NULL
);

CREATE TABLE PROCESSO(
    id_processo VARCHAR(120) PRIMARY KEY,
    create_at TIMESTAMP NOT NULL,
    tipo_processo integer NOT NULL,
    descricao VARCHAR(50),
    FOREIGN KEY (tipo_processo) REFERENCES TIPO_PROCESSO(id)
);
