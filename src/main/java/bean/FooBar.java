package bean;

import org.springframework.core.io.ResourceLoader;

public class FooBar {

    private ResourceLoader resourceLoader;

    public void foo(String location) {
        System.out.println(getResourceLoader().getResource(location).getClass());
        System.out.println(getResourceLoader().getResource(location).getDescription());
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
