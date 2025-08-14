ALTER TABLE Temas
ADD CONSTRAINT tema_unique_constraint UNIQUE(titulo, mensaje);