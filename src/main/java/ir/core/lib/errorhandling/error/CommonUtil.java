package ir.core.lib.errorhandling.error;

import ir.core.lib.errorhandling.configuration.ResourceBundleInstance;

import java.util.Locale;

public class CommonUtil {
    public static String loadClassName(Class clazz) {
        String requestedClassName = null;
        String className = "class";
        if (clazz.getSimpleName().contains("Entity")) {
            requestedClassName = clazz.getSimpleName().replace("Entity", "");
        } else if (clazz.getSimpleName().contains("DTO")) {
            requestedClassName = clazz.getSimpleName().replace("DTO", "");
        }
        if (requestedClassName != null)
            className = ResourceBundleInstance.getInstance().getMessage(requestedClassName, null, Locale.getDefault());

        return className;
    }

    public static String loadFieldName(String fieldName) {
        return ResourceBundleInstance.getInstance().getMessage(fieldName, null, Locale.getDefault());
    }
}
