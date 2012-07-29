-- MS SQL Server 
--
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
           ('Html to pdf converter'
           ,'ORDER_PDF_COMMAND'
           ,'wkhtmltopdf --quiet %s %s'
           ,'Command to transform html invoice to pdf (first %s will be replaced with the source html file, the latter with the destination)'
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
           ('Invoice directory'
           ,'ORDER_PDF_DIRECTORY'
           ,'C:\Programmi\KonaKart\webapps\konakart\invoices'
           ,'Directory where generated pdf''s will be placed'
           ,9
           ,1
           ,getDate()
           ,getDate())
GO
