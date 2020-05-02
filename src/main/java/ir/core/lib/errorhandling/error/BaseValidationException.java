package ir.core.lib.errorhandling.error;

import ir.core.lib.errorhandling.configuration.ResourceBundleInstance;
import ir.core.lib.errorhandling.constant.ErrorConstants;
import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import javax.annotation.Nullable;
import java.net.URI;
import java.util.Locale;
import java.util.Map;

public class BaseValidationException extends AbstractThrowableProblem {

    public BaseValidationException(@Nullable String detail) {
        this(detail, null);
    }

    public BaseValidationException(@Nullable String detail,
                                   Map<String, Object> otherParameters) {
        this(ErrorConstants.CONSTRAINT_VIOLATION_TYPE, detail, otherParameters);
    }

    public BaseValidationException(@Nullable URI type,
                                   @Nullable String detail,
                                   Map<String, Object> otherParameters) {
        super(
                type,
                ResourceBundleInstance.getInstance().getMessage("exception.validation.title", null, Locale.getDefault()),
                Status.BAD_REQUEST,
                detail,
                null,
                null,
                otherParameters
        );
    }
}
