package ir.core.lib.errorhandling.error;

import ir.core.lib.errorhandling.configuration.ResourceBundleInstance;
import ir.core.lib.errorhandling.constant.ErrorConstants;
import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import javax.annotation.Nullable;
import java.net.URI;
import java.util.Locale;

public class BaseHttpException extends AbstractThrowableProblem {

    public BaseHttpException(@Nullable String detail) {
        this(ErrorConstants.HTTP, detail);
    }

    public BaseHttpException(@Nullable URI type,
                             @Nullable String detail) {
        super(
                type,
                ResourceBundleInstance.getInstance().getMessage("exception.http.title", null, Locale.getDefault()),
                Status.BAD_GATEWAY,
                detail
        );
    }
}
