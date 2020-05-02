package ir.core.lib.errorhandling.exception;

import org.zalando.problem.AbstractThrowableProblem;

public abstract class BaseThrowableException {
    public abstract AbstractThrowableProblem byId(Class clazz, Long id);
}
