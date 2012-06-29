-- MS SQL Server 
--
-- Host: localhost    Database: dodoshop
-- ------------------------------------------------------
-- Server version	5.1.37-1ubuntu5

--
-- Table structure for table dodoshop_invoice_numbers
--
DELETE FROM configuration where configuration_key in ('ORDER_PDF_FATTURA_DIRECTORY','ORDER_PDF_FATTURA_COMMAND')
GO
INSERT INTO [dbo].[configuration]
           ([configuration_title]
           ,[configuration_key]
           ,[configuration_value]
           ,[configuration_description]
           ,[configuration_group_id]
           ,[sort_order]
           ,[last_modified]
           ,[date_added])
     VALUES
           ('Directory Fatture'
           ,'ORDER_PDF_FATTURA_DIRECTORY'
           ,'C:\Programmi\KonaKart\webapps\konakart\invoices'
           ,''
           ,9
           ,1
           ,getDate()
           ,getDate())
GO

INSERT INTO [dbo].[configuration]
           ([configuration_title]
           ,[configuration_key]
           ,[configuration_value]
           ,[configuration_description]
           ,[configuration_group_id]
           ,[sort_order]
           ,[last_modified]
           ,[date_added])
     VALUES
           ('HtmlToPdf CommandFattura'
           ,'ORDER_PDF_FATTURA_COMMAND'
           ,'wkhtmltopdf --quiet %s %s'
           ,''
           ,9
           ,1
           ,getDate()
           ,getDate())
GO
DELETE FROM configuration where configuration_key in ('ORDER_PDF_DIRECTORY','ORDER_PDF_COMMAND')
GO
INSERT INTO [dbo].[configuration]
           ([configuration_title]
           ,[configuration_key]
           ,[configuration_value]
           ,[configuration_description]
           ,[configuration_group_id]
           ,[sort_order]
           ,[last_modified]
           ,[date_added])
     VALUES
           ('Directory Bolle'
           ,'ORDER_PDF_DIRECTORY'
           ,'C:\Programmi\KonaKart\webapps\konakart\invoices'
           ,''
           ,9
           ,1
           ,getDate()
           ,getDate())
GO

INSERT INTO [dbo].[configuration]
           ([configuration_title]
           ,[configuration_key]
           ,[configuration_value]
           ,[configuration_description]
           ,[configuration_group_id]
           ,[sort_order]
           ,[last_modified]
           ,[date_added])
     VALUES
           ('HtmlToPdf CommandBolle'
           ,'ORDER_PDF_COMMAND'
           ,'wkhtmltopdf --quiet %s %s'
           ,''
           ,9
           ,1
           ,getDate()
           ,getDate())
GO



