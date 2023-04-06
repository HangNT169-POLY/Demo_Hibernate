-- DROP SCHEMA dbo;

CREATE DATABASE hibernate_demo;
-- hibernate_demo.dbo.category definition

USE [hibernate_demo]
GO
/****** Object:  Table [dbo].[category]    Script Date: 11/14/2022 7:58:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[category](
	[id] [bigint] IDENTITY(0,1) NOT NULL,
	[category_code] [varchar](10) NULL,
	[category_name] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[product]    Script Date: 11/14/2022 7:58:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[product](
	[id] [bigint] IDENTITY(0,1) NOT NULL,
	[category_id] [bigint] NULL,
	[product_code] [varchar](20) NULL,
	[product_name] [nvarchar](50) NULL,
	[price] [float] NULL,
	[description] [nvarchar](4000) NULL,
 CONSTRAINT [product_PK] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[category] ON 

INSERT [dbo].[category] ([id], [category_code], [category_name]) VALUES (0, N'C01', N'category1')
INSERT [dbo].[category] ([id], [category_code], [category_name]) VALUES (1, N'C02', N'Category2')
INSERT [dbo].[category] ([id], [category_code], [category_name]) VALUES (2, N'C03', N'Category3')
SET IDENTITY_INSERT [dbo].[category] OFF
GO
SET IDENTITY_INSERT [dbo].[product] ON 

INSERT [dbo].[product] ([id], [category_id], [product_code], [product_name], [price], [description]) VALUES (0, 1, N'P01', N'product1', 10, N'abc')
INSERT [dbo].[product] ([id], [category_id], [product_code], [product_name], [price], [description]) VALUES (1, 1, N'P02', N'product2', 20, N'hihi')
INSERT [dbo].[product] ([id], [category_id], [product_code], [product_name], [price], [description]) VALUES (2, 2, N'P03', N'product2', 15, N'hihihihi1')
SET IDENTITY_INSERT [dbo].[product] OFF
GO
ALTER TABLE [dbo].[product]  WITH CHECK ADD  CONSTRAINT [product_FK] FOREIGN KEY([category_id])
REFERENCES [dbo].[category] ([id])
GO
ALTER TABLE [dbo].[product] CHECK CONSTRAINT [product_FK]
GO
