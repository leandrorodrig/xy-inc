=======================================================================================
=					Nome do Projeto: api-service 							          =
=					Desenvolvedor: Tiago Poliano Tibães						          =
=					Blog: www.webstuff.eti.br										  =
=					E-mail: tibaestiago@gmail.com									  =
=					Data de conclusão: 26/02/2017									  =
= 																					  =
=======================================================================================
=       																			  =
=                   Ferramentas de software utilizadas 								  =
= 																					  =
=                   MySQL Query Browser   - Versão:   1.1 							  =             
=                   Eclipse Luna   													  =
=                   SoapUAI   			  - Versão: 5.2.1 							  = 
=                   Git/ GitBash and GitHub    										  =
=   																				  =
=======================================================================================
=                                                                                     =
=    		                  Tecnologias utililizadas 			                      =
= 																					  =
=     				Java 7 			- Versão: 1.7.0_79 							      =
=     				Tomcat 			- Versão: 7.0.68 								  =
=     				Spring 			- Versão: 4.1.0.RELEASE 						  =
=     				JPA/Hibernate 	- Versão: 4.3.0.Final  						      =
=     				MySQL 			- Versão: 5.1.15  								  =
=                   log4j          	- Versão: 1.2.16  								  =
=					jackson      	- Versão: 2.5.1  								  =
=					maven   		- Versão: 3.3  								      =
=					JSP  															  =
= 																					  =
=                   Obs.: consulte o pom.xml do projeto e veja com maiores 7 		  =
= 					detalhes as dependências utilizadas pelo projeto. 				  =
=  																					  =
=======================================================================================
=						      Como importar o projeto?             		              =
= 																					  =
= gitbash ou shell:  																  =
=     git clone https://github.com/webstuff-eti/xy-inc.git                            =
=																					  =	
=======================================================================================
=   																				  =
=       				Particularidas do projeto - Faça!   						  =  
=																					  =
=   Após importar seu projeto para sua área de trabalho, crie o diretório com 	      =
=   "log-service" dentro do C: (C:\log-service); esse diretório será onde o log do    =
=   projeto de software será salvo.											          =
=																					  =
= 	Antes de rodar o projeto, crie também o banco de dados de nome "productsbd", pois =
= 	o JPA/ Hibernate precisará para gerar a tabelas de maneira automática.			  =
=																					  =
=   Importe o projeto "REST-Project-SoapUI-Test-Complete" localizado dentro do        =																			  
=   diretório "Test-SoapUI" para que seja possível realizar os testes desse projeto;  =
=   caso seu servidor Tomcat rode em uma outra porta, ou seja, diferente da 		  =
=   configurada desse projeto (localhost:8085), altere a mesma no seu projeto de 	  =
=   SoapUI ou altere a porta do seu Tomcat para rodar em "localhost:8085". 			  =
=																					  =
=======================================================================================
=																					  =
=                    URIs para acessos aos serviços da API-SERVICE					  =
=																					  =
=    Serviço POST: salvar um produto												  =
=    uri = "http://localhost:8085/api-service/saveProductsbody"						  =
=    JSON exemplo:																	  =
=       {																			  =
=   			"name":"test save",													  =
=   			"description":"test save",											  =
=   			"category":"test save",												  =
=   			"price":"115.5"														  =
=       } 																			  =
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
=																					  =
=    Serviço GET: buscar um produto pelo ID											  =
=    uri = "http://localhost:8085/api-service/search/products/id/{id}"				  =
=    {ID} exemplo: 3 (existente no banco)											  =
=																					  =
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
=																					  =
=    Serviço PUT: alterar um produto pelo ID										  =
=    uri = "http://localhost:8085/api-service/update/products"						  =
=    JSON exemplo:																	  =
=       {																			  =
=   		"id":"53",																  =
=   		"name":"test",															  =
=   		"description":"tiago",													  =
=   		"category":"test update",												  =
=   		"price":"125.5"															  =
=       }																			  =
=																					  =
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
=																					  =
=    Serviço DELETE: deletar um produto pelo ID										  =
=    uri = "http://localhost:8085/api-service/delete/products/id/{id}"				  =
=    {ID} exemplo: 3 (existente no banco)											  =
=																					  =
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
=																					  =
=    Serviço GET: buscar todos produtos    											  =
=    uri = "http://localhost:8085/api-service/search/all							  =
=																					  =
=======================================================================================
							  				 
