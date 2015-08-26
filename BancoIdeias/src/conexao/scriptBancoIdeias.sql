

CREATE TABLE Professor (
idProfessor Int PRIMARY KEY,
nome Varchar(255),
email Varchar(255)
)

CREATE TABLE ideia (
idIdeia Int PRIMARY KEY,
tema Varchar(255),
descricao Varchar(255),
dt_cadastro DATETIME,
idSolicitante Int
)

CREATE TABLE Aluno (
idAluno Int PRIMARY KEY,
Nome Varchar(255),
email Varchar(255),
telefone Varchar(255)
)

CREATE TABLE Solicitante (
idSolicitante Int PRIMARY KEY,
Nome Varchar(255),
email Varchar(255),
telefone Varchar(255)
)

CREATE TABLE interesse_desenvolver (
idIdeia Int,
idAluno Int,
PRIMARY KEY(idIdeia,idAluno),
FOREIGN KEY(idIdeia) REFERENCES ideia (idIdeia),
FOREIGN KEY(idAluno) REFERENCES Aluno (idAluno)
)

CREATE TABLE interesse_orientar (
idProfessor Int,
idIdeia Int,
PRIMARY KEY(idProfessor,idIdeia),
FOREIGN KEY(idProfessor) REFERENCES Professor (idProfessor)/*falha: chave estrangeira*/
)

ALTER TABLE ideia ADD FOREIGN KEY(idSolicitante) REFERENCES Solicitante (idSolicitante)
