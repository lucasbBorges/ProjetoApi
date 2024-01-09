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

    WHILE data_atual <= data_fim DO
        INSERT INTO datas (data) VALUES (data_atual);
        SET data_atual = DATE_ADD(data_atual, INTERVAL 1 DAY);
    END WHILE;

    SELECT * FROM datas;

END //

DELIMITER ;