package ir.core.lib.errorhandling.error.communication;

import ir.core.lib.errorhandling.configuration.ResourceBundleInstance;
import ir.core.lib.errorhandling.error.BaseCommunicationException;
import org.zalando.problem.AbstractThrowableProblem;

import java.util.Locale;

public class MailException extends AbstractThrowableProblem {

    public MailException(String receptor) {
        throw new BaseCommunicationException(
                ResourceBundleInstance.getInstance().getMessage("exception.communication.mail", new String[]{receptor}, Locale.getDefault())
        );
    }
}
