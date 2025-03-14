USE [HuellaDeCarbono]
GO
/****** Object:  Table [dbo].[Consumo]    Script Date: 13/11/2024 12:16:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Consumo](
	[idConsumo] [int] IDENTITY(1,1) NOT NULL,
	[res] [decimal](10, 2) NOT NULL,
	[pollo] [decimal](10, 2) NOT NULL,
	[huevos] [decimal](10, 2) NOT NULL,
	[leche] [decimal](10, 2) NOT NULL,
	[frutasVerduras] [decimal](10, 2) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idConsumo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Energia]    Script Date: 13/11/2024 12:16:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Energia](
	[idEnergia] [int] IDENTITY(1,1) NOT NULL,
	[montoElectricidad] [decimal](10, 2) NOT NULL,
	[balonesGas] [int] NOT NULL,
	[montoGasNatural] [decimal](10, 2) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idEnergia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Residuos]    Script Date: 13/11/2024 12:16:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Residuos](
	[idResiduos] [int] IDENTITY(1,1) NOT NULL,
	[bolsas3kg] [int] NOT NULL,
	[bolsas6kg] [int] NOT NULL,
	[bolsas10kg] [int] NOT NULL,
	[tipoResiduos] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idResiduos] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Transporte]    Script Date: 13/11/2024 12:16:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Transporte](
	[idTransporte] [int] IDENTITY(1,1) NOT NULL,
	[horasTransporte] [int] NOT NULL,
	[kilometrosRecorridos] [decimal](10, 2) NOT NULL,
	[medioTransporteFrecuencia] [varchar](50) NOT NULL,
	[medioTransporteUso] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idTransporte] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Usuario]    Script Date: 13/11/2024 12:16:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Usuario](
	[idUsuario] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](100) NOT NULL,
	[apellido] [varchar](100) NOT NULL,
	[correo] [varchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idUsuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Consumo] ON 

INSERT [dbo].[Consumo] ([idConsumo], [res], [pollo], [huevos], [leche], [frutasVerduras]) VALUES (1, CAST(2.00 AS Decimal(10, 2)), CAST(2.00 AS Decimal(10, 2)), CAST(2.00 AS Decimal(10, 2)), CAST(2.00 AS Decimal(10, 2)), CAST(2.00 AS Decimal(10, 2)))
SET IDENTITY_INSERT [dbo].[Consumo] OFF
GO
SET IDENTITY_INSERT [dbo].[Energia] ON 

INSERT [dbo].[Energia] ([idEnergia], [montoElectricidad], [balonesGas], [montoGasNatural]) VALUES (1, CAST(400.00 AS Decimal(10, 2)), 10, CAST(600.00 AS Decimal(10, 2)))
SET IDENTITY_INSERT [dbo].[Energia] OFF
GO
SET IDENTITY_INSERT [dbo].[Residuos] ON 

INSERT [dbo].[Residuos] ([idResiduos], [bolsas3kg], [bolsas6kg], [bolsas10kg], [tipoResiduos]) VALUES (1, 3, 2, 1, N'Vidrio')
SET IDENTITY_INSERT [dbo].[Residuos] OFF
GO
SET IDENTITY_INSERT [dbo].[Transporte] ON 

INSERT [dbo].[Transporte] ([idTransporte], [horasTransporte], [kilometrosRecorridos], [medioTransporteFrecuencia], [medioTransporteUso]) VALUES (1, 100, CAST(50.00 AS Decimal(10, 2)), N'Automóvil', N'Avión')
SET IDENTITY_INSERT [dbo].[Transporte] OFF
GO
SET IDENTITY_INSERT [dbo].[Usuario] ON 

INSERT [dbo].[Usuario] ([idUsuario], [nombre], [apellido], [correo]) VALUES (1, N'pedro', N'castillo', N'pedro@gmail.com')
SET IDENTITY_INSERT [dbo].[Usuario] OFF
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__Usuario__2A586E0B1AE9C027]    Script Date: 13/11/2024 12:16:17 ******/
ALTER TABLE [dbo].[Usuario] ADD UNIQUE NONCLUSTERED 
(
	[correo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
/****** Object:  StoredProcedure [dbo].[sp_ActualizarConsumo]    Script Date: 13/11/2024 12:16:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_ActualizarConsumo]
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
/****** Object:  StoredProcedure [dbo].[sp_ActualizarEnergia]    Script Date: 13/11/2024 12:16:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_ActualizarEnergia]
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
/****** Object:  StoredProcedure [dbo].[sp_ActualizarResiduos]    Script Date: 13/11/2024 12:16:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_ActualizarResiduos]
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
/****** Object:  StoredProcedure [dbo].[sp_ActualizarTransporte]    Script Date: 13/11/2024 12:16:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_ActualizarTransporte]
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
/****** Object:  StoredProcedure [dbo].[sp_ActualizarUsuario]    Script Date: 13/11/2024 12:16:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_ActualizarUsuario]
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
/****** Object:  StoredProcedure [dbo].[sp_EliminarConsumo]    Script Date: 13/11/2024 12:16:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_EliminarConsumo]
    @idConsumo INT
AS
BEGIN
    DELETE FROM Consumo
    WHERE idConsumo = @idConsumo;
END;
GO
/****** Object:  StoredProcedure [dbo].[sp_EliminarEnergia]    Script Date: 13/11/2024 12:16:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_EliminarEnergia]
    @idEnergia INT
AS
BEGIN
    DELETE FROM Energia
    WHERE idEnergia = @idEnergia;
END;
GO
/****** Object:  StoredProcedure [dbo].[sp_EliminarResiduos]    Script Date: 13/11/2024 12:16:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_EliminarResiduos]
    @idResiduos INT
AS
BEGIN
    DELETE FROM Residuos
    WHERE idResiduos = @idResiduos;
END;
GO
/****** Object:  StoredProcedure [dbo].[sp_EliminarTransporte]    Script Date: 13/11/2024 12:16:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_EliminarTransporte]
    @idTransporte INT
AS
BEGIN
    DELETE FROM Transporte
    WHERE idTransporte = @idTransporte;
END;
GO
/****** Object:  StoredProcedure [dbo].[sp_EliminarUsuario]    Script Date: 13/11/2024 12:16:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_EliminarUsuario]
    @idUsuario INT
AS
BEGIN
    DELETE FROM Usuario
    WHERE idUsuario = @idUsuario;
END;
GO
/****** Object:  StoredProcedure [dbo].[sp_InsertarConsumo]    Script Date: 13/11/2024 12:16:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_InsertarConsumo]
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
/****** Object:  StoredProcedure [dbo].[sp_InsertarEnergia]    Script Date: 13/11/2024 12:16:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_InsertarEnergia]
    @montoElectricidad DECIMAL(10, 2),
    @balonesGas INT,
    @montoGasNatural DECIMAL(10, 2)
AS
BEGIN
    INSERT INTO Energia (montoElectricidad, balonesGas, montoGasNatural)
    VALUES (@montoElectricidad, @balonesGas, @montoGasNatural);
END;
GO
/****** Object:  StoredProcedure [dbo].[sp_InsertarResiduos]    Script Date: 13/11/2024 12:16:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_InsertarResiduos]
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
/****** Object:  StoredProcedure [dbo].[sp_InsertarTransporte]    Script Date: 13/11/2024 12:16:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_InsertarTransporte]
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
/****** Object:  StoredProcedure [dbo].[sp_InsertarUsuario]    Script Date: 13/11/2024 12:16:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_InsertarUsuario]
    @nombre VARCHAR(100),
    @apellido VARCHAR(100),
    @correo VARCHAR(100)
AS
BEGIN
    INSERT INTO Usuario (nombre, apellido, correo)
    VALUES (@nombre, @apellido, @correo);
END;
GO
/****** Object:  StoredProcedure [dbo].[sp_SeleccionarConsumos]    Script Date: 13/11/2024 12:16:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_SeleccionarConsumos]
AS
BEGIN
    SELECT * FROM Consumo;
END;
GO
/****** Object:  StoredProcedure [dbo].[sp_SeleccionarEnergias]    Script Date: 13/11/2024 12:16:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_SeleccionarEnergias]
AS
BEGIN
    SELECT * FROM Energia;
END;
GO
/****** Object:  StoredProcedure [dbo].[sp_SeleccionarResiduos]    Script Date: 13/11/2024 12:16:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_SeleccionarResiduos]
AS
BEGIN
    SELECT * FROM Residuos;
END;
GO
/****** Object:  StoredProcedure [dbo].[sp_SeleccionarTransportes]    Script Date: 13/11/2024 12:16:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_SeleccionarTransportes]
AS
BEGIN
    SELECT * FROM Transporte;
END;
GO
/****** Object:  StoredProcedure [dbo].[sp_SeleccionarUsuarios]    Script Date: 13/11/2024 12:16:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_SeleccionarUsuarios]
AS
BEGIN
    SELECT * FROM Usuario;
END;
GO
