package br.eti.webstuff.fiveware.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.eti.webstuff.fiveware.controller.HomeController;
import br.eti.webstuff.fiveware.controller.ProductsResponseEntityController;
import br.eti.webstuff.fiveware.dao.ProductsDAO;
import br.eti.webstuff.fiveware.service.ProductsService;


@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class, 
		                           ProductsResponseEntityController.class, 
		                           ProductsDAO.class, 
		                           ProductsService.class})  

                                                                       
public class AppWebConfiguration {
	
	@Bean 
	public InternalResourceViewResolver internalResourceViewResolve() {
        InternalResourceViewResolver resolve = new InternalResourceViewResolver();
        resolve.setPrefix("/WEB-INF/views/");
        resolve.setSuffix(".jsp");
        return resolve;
    }

}


/*
    realiza configura��o do Spring MVC
    
    M�todo: internalResourceViewResolve();
    Responsabilidade: indicar qual diret�rio est�o as views (interface usu�rio) do projeto.
    @Bean: anota��o importante para que o Spring gerencie.
*/
