package ir.core.lib.errorhandling.error.exits;

import ir.core.lib.errorhandling.configuration.ResourceBundleInstance;
import ir.core.lib.errorhandling.error.BaseExistException;
import ir.core.lib.errorhandling.error.CommonUtil;
import ir.core.lib.errorhandling.exception.BaseThrowableException;
import org.zalando.problem.AbstractThrowableProblem;

import java.util.Locale;

public class CommonExistException extends BaseThrowableException {

    public AbstractThrowableProblem common(Class clazz, String fieldName, Object value) {
        throw new BaseExistException(
                ResourceBundleInstance.getInstance().getMessage(
                        "exception.exist.common",
                        new Object[]{CommonUtil.loadClassName(clazz), CommonUtil.loadFieldName(fieldName), value.toString()},
                        Locale.getDefault())
        );
    }

    @Override
    public AbstractThrowableProblem byId(Class clazz, Long id) {
        throw new CommonExistException().common(clazz, "id", id);
    }
}
