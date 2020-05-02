package ir.core.lib.errorhandling.error;

import ir.core.lib.errorhandling.configuration.ResourceBundleInstance;
import ir.core.lib.errorhandling.constant.ErrorConstants;
import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import javax.annotation.Nullable;
import java.net.URI;
import java.util.Locale;

public class BaseSecurityException extends AbstractThrowableProblem {

    public BaseSecurityException(@Nullable String detail) {
        this(ErrorConstants.SECURITY, detail);
    }

    public BaseSecurityException(@Nullable URI type,
                                 @Nullable String detail) {
        super(
                type,
                ResourceBundleInstance.getInstance().getMessage("exception.security.title", null, Locale.getDefault()),
                Status.FORBIDDEN,
                detail
        );
    }
}
