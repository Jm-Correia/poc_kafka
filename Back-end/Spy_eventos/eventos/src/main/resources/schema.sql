CREATE SCHEMA IF NOT EXISTS EVENTO;

CREATE TABLE EVENTO.TIPO_PROCESSO(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(50) NOT NULL,
    create_at TIMESTAMP NOT NULL
);

CREATE TABLE EVENTO.LOG_PROCESSO(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    id_processo VARCHAR(120) NOT NULL,
    create_at TIMESTAMP NOT NULL,
    tipo_processo integer NOT NULL,
    FOREIGN KEY (tipo_processo) REFERENCES EVENTO.TIPO_PROCESSO(id)    
);

CREATE TABLE EVENTO.LOG_EVENTO(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    create_at TIMESTAMP NOT NULL,
    descricao VARCHAR(100) NOT NULL,
    log_processo_id INTEGER NOT NULL,
    FOREIGN KEY (log_processo_id) REFERENCES EVENTO.LOG_PROCESSO(id)
);