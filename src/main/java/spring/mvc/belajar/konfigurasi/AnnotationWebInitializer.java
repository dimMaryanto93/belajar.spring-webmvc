package spring.mvc.belajar.konfigurasi;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import spring.mvc.belajar.KonfigurasiWeb;

public class AnnotationWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{KonfigurasiWeb.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
