package ir.core.lib.errorhandling.error.notfound;

import ir.core.lib.errorhandling.configuration.ResourceBundleInstance;
import ir.core.lib.errorhandling.error.BaseNotFoundException;
import ir.core.lib.errorhandling.error.CommonUtil;
import ir.core.lib.errorhandling.exception.BaseThrowableException;
import org.zalando.problem.AbstractThrowableProblem;

import java.util.Locale;

public class CommonNotFoundException extends BaseThrowableException {


    public AbstractThrowableProblem common(Class clazz, String fieldName, Object value) {
        throw new BaseNotFoundException(
                ResourceBundleInstance.getInstance().getMessage(
                        "exception.notfound.common",
                        new Object[]{CommonUtil.loadClassName(clazz), CommonUtil.loadFieldName(fieldName), value.toString()},
                        Locale.getDefault())
        );
    }

    @Override
    public AbstractThrowableProblem byId(Class clazz, Long id) {
        throw new CommonNotFoundException().common(clazz, "id", id);
    }
}
