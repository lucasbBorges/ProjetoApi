CREATE TABLE datas (
    data DATE
);

DELIMITER //

CREATE PROCEDURE PreencherTabelaDatasNoIntervalo(
    IN data_inicio DATE,
    IN data_fim DATE
)
BEGIN
    DECLARE data_atual DATE;

    SET data_atual = data_inicio;

    -- Preencher a tabela com todas as datas no intervalo especificado
    WHILE data_atual <= data_fim DO
        INSERT INTO datas (data) VALUES (data_atual);
        SET data_atual = DATE_ADD(data_atual, INTERVAL 1 DAY);
    END WHILE;

    -- Consultar as datas armazenadas na tabela temporária
    SELECT * FROM datas;

END //

DELIMITER ;

CALL PreencherTabelaDatasNoIntervalo('2022-01-01', '2030-12-31');