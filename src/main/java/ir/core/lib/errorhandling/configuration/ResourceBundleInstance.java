package ir.core.lib.errorhandling.configuration;

import org.springframework.context.support.ResourceBundleMessageSource;

public class ResourceBundleInstance {

    private static ResourceBundleMessageSource ourInstance = new ResourceBundleMessageSource();

    public static ResourceBundleMessageSource getInstance() {
        ourInstance.setBasenames("i18n/Errors", "i18n/Defaults", "i18n/ClassNames", "i18n/FieldNames");
        ourInstance.setDefaultEncoding("UTF-8");
        return ourInstance;
    }

    private ResourceBundleInstance() {
    }
}
