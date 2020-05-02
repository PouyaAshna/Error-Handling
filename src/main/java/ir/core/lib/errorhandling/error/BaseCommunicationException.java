package ir.core.lib.errorhandling.error;

import ir.core.lib.errorhandling.configuration.ResourceBundleInstance;
import ir.core.lib.errorhandling.constant.ErrorConstants;
import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import javax.annotation.Nullable;
import java.net.URI;
import java.util.Locale;

public class BaseCommunicationException extends AbstractThrowableProblem {

    public BaseCommunicationException(@Nullable String detail) {
        this(ErrorConstants.COMMUNICATION, detail);
    }

    public BaseCommunicationException(@Nullable URI type,
                                      @Nullable String detail) {
        super(
                type,
                ResourceBundleInstance.getInstance().getMessage("exception.communication.title", null, Locale.getDefault()),
                Status.BAD_GATEWAY,
                detail
        );
    }
}
