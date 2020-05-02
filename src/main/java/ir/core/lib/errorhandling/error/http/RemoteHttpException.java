package ir.core.lib.errorhandling.error.http;

import ir.core.lib.errorhandling.configuration.ResourceBundleInstance;
import ir.core.lib.errorhandling.constant.ErrorConstants;
import ir.core.lib.errorhandling.error.BaseHttpException;
import org.zalando.problem.AbstractThrowableProblem;

import java.util.Locale;

public class RemoteHttpException {

    public AbstractThrowableProblem byGeneral() {
        throw new BaseHttpException(
                ResourceBundleInstance.getInstance().getMessage("exception.http.remote.general", null, Locale.getDefault())
        );
    }

    public AbstractThrowableProblem byHttpStatus(Integer value) {
        throw new BaseHttpException(
                ErrorConstants.HTTP,
                ResourceBundleInstance.getInstance().getMessage("exception.http.remote.statusCode", new Integer[]{value}, Locale.getDefault())
        );
    }
}
