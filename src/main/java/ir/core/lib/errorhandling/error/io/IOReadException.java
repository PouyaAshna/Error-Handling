package ir.core.lib.errorhandling.error.io;

import ir.core.lib.errorhandling.configuration.ResourceBundleInstance;
import ir.core.lib.errorhandling.constant.ErrorConstants;
import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.util.Locale;

public class IOReadException extends AbstractThrowableProblem {
    public IOReadException(String name) {
        super(
                ErrorConstants.IO,
                ResourceBundleInstance.getInstance().getMessage("exception.io.title", null, Locale.getDefault()),
                Status.BAD_REQUEST,
                ResourceBundleInstance.getInstance().getMessage("exception.io.read", new String[]{name}, Locale.getDefault())
        );
    }
}
