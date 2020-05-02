package ir.core.lib.errorhandling.error;

import ir.core.lib.errorhandling.configuration.ResourceBundleInstance;
import ir.core.lib.errorhandling.constant.ErrorConstants;
import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import javax.annotation.Nullable;
import java.net.URI;
import java.util.Locale;

public class BaseNotFoundException extends AbstractThrowableProblem {

    public BaseNotFoundException(@Nullable String detail) {
        this(ErrorConstants.NOT_FOUNT, detail);
    }

    public BaseNotFoundException(@Nullable URI type,
                                 @Nullable String detail) {
        super(
                type,
                ResourceBundleInstance.getInstance().getMessage("exception.notfound.title", null, Locale.getDefault()),
                Status.NOT_FOUND,
                detail
        );
    }
}
