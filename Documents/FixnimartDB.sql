-- Cambiar al contexto de la base de datos "master"
USE [master];
GO

-- Verificar si la base de datos existe y eliminarla si es el caso
IF DB_ID('FixnimartDB') IS NOT NULL
BEGIN
    -- Cambiar la base de datos al modo de usuario único y deshacer cualquier transacción en curso
    ALTER DATABASE [FixnimartDB] SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    
    -- Eliminar la base de datos
    DROP DATABASE [FixnimartDB];
END
GO

-- Crear la base de datos con el nombre especificado
CREATE DATABASE [FixnimartDB];	
GO

-- Cambiar al contexto de la base de datos recién creada
USE [FixnimartDB];
GO


CREATE TABLE [dbo].[Products](
	[ProductId][uniqueidentifier] PRIMARY KEY DEFAULT NEWID() NOT NULL,
	[ProductImage][varbinary](max) NULL,
	[Name] [varchar](100) NOT NULL,
	[Description] [varchar](500) NULL,
	[Price][money] NOT NULL DEFAULT 0.00,
	[Stock][int] NOT NULL DEFAULT 0,
	[BarCode][varchar](50) NOT NULL UNIQUE,
);

CREATE TABLE [dbo].[Sales](
	[SaleId][uniqueidentifier] PRIMARY KEY DEFAULT NEWID() NOT NULL,
	[DateOfSale][datetime] NOT NULL DEFAULT GETDATE(),
	[TotalSale][money] NOT NULL,
    [ClientName] VARCHAR(100) NOT NULL,
	[Nrc][varchar](50) NULL,
	[Iva][money] NULL,
	[Sum][money] NULL
);

CREATE TABLE [dbo].[SaleProducts](
    [SaleProductId] [uniqueidentifier] PRIMARY KEY DEFAULT NEWID() NOT NULL,
    [SaleId] [uniqueidentifier] NOT NULL,
    [ProductId] [uniqueidentifier] NOT NULL,
    [Quantity] [int] NOT NULL DEFAULT 1,
    [UnitPrice] [money] NOT NULL,
	[SubTotal][money]NOT NULL,
    CONSTRAINT [FK_SaleProduct_Sale] FOREIGN KEY ([SaleId]) REFERENCES [dbo].[Sales] ([SaleId]),
    CONSTRAINT [FK_SaleProduct_Products] FOREIGN KEY ([ProductId]) REFERENCES [dbo].[Products] ([ProductId])
);

