package py.edu.facitec.hibernatespringtaller.conf;

import javax.servlet.Filter;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[]{AppWebConfiguration.class,JPAConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]{"/"};
	}
	// Tener habilitado en el EntityManager durante las requisiciones. 
	 	@Override 
	 	
	protected Filter[] getServletFilters() {  	 	
		return new Filter[]{ 
				new OpenEntityManagerInViewFilter()}; 
	} 



}
