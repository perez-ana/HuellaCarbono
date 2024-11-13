CREATE DATABASE HuellaDeCarbono;
GO

USE HuellaDeCarbono;
GO

-- Crear tabla Usuario primero
CREATE TABLE Usuario (
    idUsuario INT IDENTITY(1,1) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    correo VARCHAR(100) NOT NULL UNIQUE
);

SELECT * FROM Usuario;
DROP TABLE Usuario;


-- Crear tabla Transporte
CREATE TABLE Transporte (
    idTransporte INT IDENTITY(1,1) PRIMARY KEY,
    horasTransporte INT NOT NULL,
    kilometrosRecorridos DECIMAL(10, 2) NOT NULL,
    medioTransporteFrecuencia VARCHAR(50) NOT NULL,
    medioTransporteUso VARCHAR(50) NOT NULL
);

SELECT * FROM Transporte;
DROP TABLE Transporte;

-- Crear tabla Energia
CREATE TABLE Energia (
    idEnergia INT IDENTITY(1,1) PRIMARY KEY,
    montoElectricidad DECIMAL(10, 2) NOT NULL,
    balonesGas INT NOT NULL,
    montoGasNatural DECIMAL(10, 2) NOT NULL
);

SELECT * FROM Energia;
DROP TABLE Energia;

-- Crear tabla Consumo
CREATE TABLE Consumo (
    idConsumo INT IDENTITY(1,1) PRIMARY KEY,
    res DECIMAL(10, 2) NOT NULL,
    pollo DECIMAL(10, 2) NOT NULL,
    huevos DECIMAL(10, 2) NOT NULL,
    leche DECIMAL(10, 2) NOT NULL,
    frutasVerduras DECIMAL(10, 2) NOT NULL
);

SELECT * FROM Consumo;
DROP TABLE Consumo;

-- Crear tabla Residuos
CREATE TABLE Residuos (
    idResiduos INT IDENTITY(1,1) PRIMARY KEY,
    bolsas3kg INT NOT NULL,
    bolsas6kg INT NOT NULL,
    bolsas10kg INT NOT NULL,
    tipoResiduos VARCHAR(50) NOT NULL
);

SELECT * FROM Residuos;
DROP TABLE Residuos;


--STORE PROCEDURES

--USUARIO

-- Procedimiento para insertar un nuevo usuario
CREATE PROCEDURE sp_InsertarUsuario
    @nombre VARCHAR(100),
    @apellido VARCHAR(100),
    @correo VARCHAR(100)
AS
BEGIN
    INSERT INTO Usuario (nombre, apellido, correo)
    VALUES (@nombre, @apellido, @correo);
END;
GO

-- Procedimiento para actualizar un usuario
CREATE PROCEDURE sp_ActualizarUsuario
    @idUsuario INT,
    @nombre VARCHAR(100),
    @apellido VARCHAR(100),
    @correo VARCHAR(100)
AS
BEGIN
    UPDATE Usuario
    SET nombre = @nombre, apellido = @apellido, correo = @correo
    WHERE idUsuario = @idUsuario;
END;
GO

-- Procedimiento para eliminar un usuario
CREATE PROCEDURE sp_EliminarUsuario
    @idUsuario INT
AS
BEGIN
    DELETE FROM Usuario
    WHERE idUsuario = @idUsuario;
END;
GO

-- Procedimiento para seleccionar todos los usuarios
CREATE PROCEDURE sp_SeleccionarUsuarios
AS
BEGIN
    SELECT * FROM Usuario;
END;
GO

--TRANSPORTE

-- Procedimiento para insertar un nuevo registro en Transporte
CREATE PROCEDURE sp_InsertarTransporte
    @horasTransporte INT,
    @kilometrosRecorridos DECIMAL(10, 2),
    @medioTransporteFrecuencia VARCHAR(50),
    @medioTransporteUso VARCHAR(50)
AS
BEGIN
    INSERT INTO Transporte (horasTransporte, kilometrosRecorridos, medioTransporteFrecuencia, medioTransporteUso)
    VALUES (@horasTransporte, @kilometrosRecorridos, @medioTransporteFrecuencia, @medioTransporteUso);
END;
GO

-- Procedimiento para actualizar un registro en Transporte
CREATE PROCEDURE sp_ActualizarTransporte
    @idTransporte INT,
    @horasTransporte INT,
    @kilometrosRecorridos DECIMAL(10, 2),
    @medioTransporteFrecuencia VARCHAR(50),
    @medioTransporteUso VARCHAR(50)
AS
BEGIN
    UPDATE Transporte
    SET horasTransporte = @horasTransporte,
        kilometrosRecorridos = @kilometrosRecorridos,
        medioTransporteFrecuencia = @medioTransporteFrecuencia,
        medioTransporteUso = @medioTransporteUso
    WHERE idTransporte = @idTransporte;
END;
GO

-- Procedimiento para eliminar un registro en Transporte
CREATE PROCEDURE sp_EliminarTransporte
    @idTransporte INT
AS
BEGIN
    DELETE FROM Transporte
    WHERE idTransporte = @idTransporte;
END;
GO

-- Procedimiento para seleccionar todos los registros de Transporte
CREATE PROCEDURE sp_SeleccionarTransportes
AS
BEGIN
    SELECT * FROM Transporte;
END;
GO

--ENERGIA

-- Procedimiento para insertar un nuevo registro en Energia
CREATE PROCEDURE sp_InsertarEnergia
    @montoElectricidad DECIMAL(10, 2),
    @balonesGas INT,
    @montoGasNatural DECIMAL(10, 2)
AS
BEGIN
    INSERT INTO Energia (montoElectricidad, balonesGas, montoGasNatural)
    VALUES (@montoElectricidad, @balonesGas, @montoGasNatural);
END;
GO

-- Procedimiento para actualizar un registro en Energia
CREATE PROCEDURE sp_ActualizarEnergia
    @idEnergia INT,
    @montoElectricidad DECIMAL(10, 2),
    @balonesGas INT,
    @montoGasNatural DECIMAL(10, 2)
AS
BEGIN
    UPDATE Energia
    SET montoElectricidad = @montoElectricidad,
        balonesGas = @balonesGas,
        montoGasNatural = @montoGasNatural
    WHERE idEnergia = @idEnergia;
END;
GO

-- Procedimiento para eliminar un registro en Energia
CREATE PROCEDURE sp_EliminarEnergia
    @idEnergia INT
AS
BEGIN
    DELETE FROM Energia
    WHERE idEnergia = @idEnergia;
END;
GO

-- Procedimiento para seleccionar todos los registros de Energia
CREATE PROCEDURE sp_SeleccionarEnergias
AS
BEGIN
    SELECT * FROM Energia;
END;
GO

--CONSUMO

-- Procedimiento para insertar un nuevo registro en Consumo
CREATE PROCEDURE sp_InsertarConsumo
    @res DECIMAL(10, 2),
    @pollo DECIMAL(10, 2),
    @huevos DECIMAL(10, 2),
    @leche DECIMAL(10, 2),
    @frutasVerduras DECIMAL(10, 2)
AS
BEGIN
    INSERT INTO Consumo (res, pollo, huevos, leche, frutasVerduras)
    VALUES (@res, @pollo, @huevos, @leche, @frutasVerduras);
END;
GO

-- Procedimiento para actualizar un registro en Consumo
CREATE PROCEDURE sp_ActualizarConsumo
    @idConsumo INT,
    @res DECIMAL(10, 2),
    @pollo DECIMAL(10, 2),
    @huevos DECIMAL(10, 2),
    @leche DECIMAL(10, 2),
    @frutasVerduras DECIMAL(10, 2)
AS
BEGIN
    UPDATE Consumo
    SET res = @res,
        pollo = @pollo,
        huevos = @huevos,
        leche = @leche,
        frutasVerduras = @frutasVerduras
    WHERE idConsumo = @idConsumo;
END;
GO

-- Procedimiento para eliminar un registro en Consumo
CREATE PROCEDURE sp_EliminarConsumo
    @idConsumo INT
AS
BEGIN
    DELETE FROM Consumo
    WHERE idConsumo = @idConsumo;
END;
GO

-- Procedimiento para seleccionar todos los registros de Consumo
CREATE PROCEDURE sp_SeleccionarConsumos
AS
BEGIN
    SELECT * FROM Consumo;
END;
GO

--RESIDUOS

-- Procedimiento para insertar un nuevo registro en Residuos
CREATE PROCEDURE sp_InsertarResiduos
    @bolsas3kg INT,
    @bolsas6kg INT,
    @bolsas10kg INT,
    @tipoResiduos VARCHAR(50)
AS
BEGIN
    INSERT INTO Residuos (bolsas3kg, bolsas6kg, bolsas10kg, tipoResiduos)
    VALUES (@bolsas3kg, @bolsas6kg, @bolsas10kg, @tipoResiduos);
END;
GO

-- Procedimiento para actualizar un registro en Residuos
CREATE PROCEDURE sp_ActualizarResiduos
    @idResiduos INT,
    @bolsas3kg INT,
    @bolsas6kg INT,
    @bolsas10kg INT,
    @tipoResiduos VARCHAR(50)
AS
BEGIN
    UPDATE Residuos
    SET bolsas3kg = @bolsas3kg,
        bolsas6kg = @bolsas6kg,
        bolsas10kg = @bolsas10kg,
        tipoResiduos = @tipoResiduos
    WHERE idResiduos = @idResiduos;
END;
GO

-- Procedimiento para eliminar un registro en Residuos
CREATE PROCEDURE sp_EliminarResiduos
    @idResiduos INT
AS
BEGIN
    DELETE FROM Residuos
    WHERE idResiduos = @idResiduos;
END;
GO

-- Procedimiento para seleccionar todos los registros de Residuos
CREATE PROCEDURE sp_SeleccionarResiduos
AS
BEGIN
    SELECT * FROM Residuos;
END;
GO