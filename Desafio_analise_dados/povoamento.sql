-- Povoamento da tabela "PACIENTE" no "stg_hospital_a"
INSERT INTO stg_hospital_a.PACIENTE (id, nome, dt_nascimento, cpf, nome_mae, dt_atualizacao)
VALUES
    (1, 'João Silva', '1985-05-10', 12345078900, 'Maria Silva', CONVERT(DATETIME, '2023-07-30 10:15:00', 120)),
    (2, 'Maria Santos', '1990-02-15', 98705432100, 'Ana Santos', CONVERT(DATETIME, '2023-07-30 10:25:00', 120)),
    (3, 'Pedro Alves', '1980-11-20', 45670912300, 'Sandra Alves', CONVERT(DATETIME, '2023-07-30 11:30:00', 120)),
    (4, 'Paula Souza', '1992-07-22', 852360974100, 'Marta Souza', CONVERT(DATETIME, '2023-07-30 12:45:00', 120)),
    (5, 'Ana Pereira', '1988-04-18', 45612378900, 'Beatriz Pereira', CONVERT(DATETIME, '2023-07-30 13:20:00', 120)),
    (6, 'José Lima', '1976-12-01', 65498732100, 'Sandra Lima', CONVERT(DATETIME, '2023-07-30 14:15:00', 120)),
    (7, 'Mariana Torres', '1994-09-05', 74185296300, 'Clara Torres', CONVERT(DATETIME, '2023-07-30 15:30:00', 120)),
    (8, 'Lucas Fernandes', '1998-03-25', 36025814700, 'Carla Fernandes', CONVERT(DATETIME, '2023-07-30 16:00:00', 120)),
    (9, 'Julia Mendes', '1982-06-28', 95175305200, 'Rita Mendes', CONVERT(DATETIME, '2023-07-30 17:10:00', 120)),
    (10, 'Rafaela Costa', '1991-11-14', 25836914700, 'Eva Costa', CONVERT(DATETIME, '2023-07-30 18:20:00', 120)),
    (11, 'Gustavo Ferreira', '1986-08-12', 70945612300, 'Sofia Ferreira', CONVERT(DATETIME, '2023-07-30 19:30:00', 120)),
    (12, 'Fernando Oliveira', '1979-04-30', 45678912300, 'Marta Oliveira', CONVERT(DATETIME, '2023-07-30 20:40:00', 120)),
    (13, 'Carolina Rodrigues', '1993-12-09', 35710924600, 'Laura Rodrigues', CONVERT(DATETIME, '2023-07-30 21:50:00', 120)),
    (14, 'Gabriel Silva', '1999-10-05', 96325874103, 'Paula Silva', CONVERT(DATETIME, '2023-07-30 22:25:00', 120)),
    (15, 'Carlos Oliveira', '1977-09-05', 15948726300, 'Lucia Oliveira', CONVERT(DATETIME, '2023-07-31 09:45:00', 120));



-- Povoamento da tabela "PACIENTE" no "stg_hospital_b"
INSERT INTO stg_hospital_b.PACIENTE (id, nome, dt_nascimento, cpf, nome_mae, dt_atualizacao)
VALUES
    (16, 'Laura Santos', '1995-03-18', 85214796300, 'Ana Santos', CONVERT(DATETIME, '2023-08-01 10:30:00', 120)),
    (17, 'Fernando Pereira', '1987-07-22', 45600912300, 'Beatriz Pereira', CONVERT(DATETIME, '2023-08-01 11:00:00', 120)),
    (18, 'Carla Lima', '1977-11-20', 36905814700, 'Sandra Lima', CONVERT(DATETIME, '2023-08-01 11:30:00', 120)),
    (19, 'Lucas Torres', '1993-05-22', 12345678900, 'Clara Torres', CONVERT(DATETIME, '2023-08-01 12:00:00', 120)),
    (20, 'Gustavo Borges', '1990-01-14', 85236974100, 'Eva Costa', CONVERT(DATETIME, '2023-08-01 12:30:00', 120)),
    (21, 'Carol Costa', '1983-06-22', 15940726300, 'Mana Oliveira', CONVERT(DATETIME, '2023-08-01 13:00:00', 120)),
    (22, 'Julia Mendes', '1982-06-28', 35705924600, 'Rita Mendes', CONVERT(DATETIME, '2023-08-01 13:30:00', 120)),
    (23, 'Rafaela Costa', '1991-11-14', 96325874100, 'Paula Silva', CONVERT(DATETIME, '2023-08-01 14:00:00', 120)),
    (24, 'João Oliveira', '1977-09-05', 45610378900, 'Maria Silva', CONVERT(DATETIME, '2023-08-01 14:30:00', 120)),
    (25, 'Paula Souza', '1992-07-22', 78940612300, 'Marta Souza', CONVERT(DATETIME, '2023-08-01 15:00:00', 120)),
    (26, 'Mariana Torres', '1994-09-05', 74185296300, 'Clara Torres', CONVERT(DATETIME, '2023-08-01 15:30:00', 120)),
    (27, 'Lucas Fernandes', '1998-03-25', 98765432100, 'Carla Fernandes', CONVERT(DATETIME, '2023-08-01 16:00:00', 120)),
    (28, 'Ana Pereira', '1988-04-18', 45612378900, 'Beatriz Pereira', CONVERT(DATETIME, '2023-08-01 16:30:00', 120)),
    (29, 'Gustavo Ferreira', '1986-08-12', 70945612300, 'Sofia Ferreira', CONVERT(DATETIME, '2023-08-01 17:00:00', 120)),
    (30, 'Mariana Costa', '1983-06-22', 95175385200, 'Lucia Oliveira', CONVERT(DATETIME, '2023-08-01 17:30:00', 120));



-- Povoamento da tabela "PACIENTE" no "stg_hospital_c"
INSERT INTO stg_hospital_c.PACIENTE (id, nome, dt_nascimento, cpf, nome_mae, dt_atualizacao)
VALUES
    (31, 'Fernanda Souza', '1996-02-10', 95075385200, 'Marta Souza', CONVERT(DATETIME, '2023-08-02 10:15:00', 120)),
    (32, 'Paulo Lima', '1975-11-20', 78945612300, 'Sandra Lima', CONVERT(DATETIME, '2023-08-02 10:25:00', 120)),
    (33, 'Luciana Fernandes', '1993-12-12', 35715924600, 'Carla Fernandes', CONVERT(DATETIME, '2023-08-02 10:35:00', 120)),
    (34, 'Fernando Oliveira', '1979-04-30', 45678912300, 'Marta Oliveira', CONVERT(DATETIME, '2023-08-02 11:30:00', 120)),
    (35, 'Carlos Oliveira', '1977-09-05', 15948726300, 'Lucia Oliveira', CONVERT(DATETIME, '2023-08-02 12:45:00', 120)),
    (36, 'Julia Mendes', '1982-06-28', 85236974100, 'Rita Mendes', CONVERT(DATETIME, '2023-08-02 13:20:00', 120)),
    (37, 'Rafaela Costa', '1991-11-14', 12340678900, 'Eva Costa', CONVERT(DATETIME, '2023-08-02 14:15:00', 120)),
    (38, 'Paulo Torres', '1994-09-05', 74183296300, 'Elisabete Torres', CONVERT(DATETIME, '2023-08-02 15:30:00', 120)),
    (39, 'Lucas Fernandes', '1998-03-25', 98765432100, 'Carla Fernandes', CONVERT(DATETIME, '2023-08-02 16:00:00', 120)),
    (40, 'Ana Pereira', '1988-04-18', 45612378900, 'Beatriz Pereira', CONVERT(DATETIME, '2023-08-02 17:10:00', 120)),
    (41, 'Gustavo Ferreira', '1986-08-12', 70945612300, 'Sofia Ferreira', CONVERT(DATETIME, '2023-08-02 18:20:00', 120)),
    (42, 'Laura Santos', '1995-03-18', 85214796300, 'Ana Santos', CONVERT(DATETIME, '2023-08-02 20:40:00', 120)),
    (43, 'Paulo Lima', '1975-11-20', 78945612300, 'Sandra Lima', CONVERT(DATETIME, '2023-08-02 21:50:00', 120)),
    (44, 'Luciana Fernandes', '1993-12-12', 35715924600, 'Carla Fernandes', CONVERT(DATETIME, '2023-08-02 22:25:00', 120));
