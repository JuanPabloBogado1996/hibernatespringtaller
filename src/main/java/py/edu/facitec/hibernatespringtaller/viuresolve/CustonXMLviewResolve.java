package py.edu.facitec.hibernatespringtaller.viuresolve;



import java.util.ArrayList;
import java.util.List;
import java.util.Locale; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.xml.MarshallingView;

import py.edu.facitec.hibernatespringtaller.model.Producto; 

public abstract class CustonXMLviewResolve implements ViewResolver { 

	public ViewResolver contentNegotiatingViewResolver( 
			ContentNegotiationManager manager) { 
		List<ViewResolver> resolvers = new 
				ArrayList<ViewResolver>(); 

		resolvers.add(InternalResourceViewResolver ());  	 	
		resolvers.add(new JsonViuResolve()); 
		resolvers.add(getMarshallingXmlViewResolver()); 

		ContentNegotiatingViewResolver resolver = new 
				ContentNegotiatingViewResolver();  	 	resolver.setViewResolvers(resolvers); 
				resolver.setContentNegotiationManager(manager); 
				return resolver; 
	} 

	private ViewResolver InternalResourceViewResolver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Bean 
	public CustonXMLviewResolve getMarshallingXmlViewResolver() { 
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();  	 	
		marshaller.setClassesToBeBound(Producto.class); 
		return new  CustonXMLviewResolve() {
		
		};
		
		

		}
	
			@Override
			public View resolveViewName(String arg0, Locale arg1) throws Exception {
				// TODO Auto-generated method stub
				return null;
			}




		}


