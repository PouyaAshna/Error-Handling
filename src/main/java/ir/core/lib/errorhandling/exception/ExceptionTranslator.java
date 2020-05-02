package ir.core.lib.errorhandling.exception;


import ir.core.lib.errorhandling.configuration.ResourceBundleInstance;
import ir.core.lib.errorhandling.constant.ErrorConstants;
import ir.core.lib.errorhandling.vm.FieldErrorVM;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.NativeWebRequest;
import org.zalando.problem.Problem;
import org.zalando.problem.ProblemBuilder;
import org.zalando.problem.ProblemModule;
import org.zalando.problem.Status;
import org.zalando.problem.spring.web.advice.ProblemHandling;
import org.zalando.problem.violations.ConstraintViolationProblem;
import org.zalando.problem.violations.ConstraintViolationProblemModule;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionTranslator implements ProblemHandling {

    public static final String MESSAGE_KEY = "message";

    @Bean
    ProblemModule problemModule() {
        return new ProblemModule();
    }

    @Bean
    ConstraintViolationProblemModule constraintViolationProblemModule() {
        return new ConstraintViolationProblemModule();
    }

    @Override
    public ResponseEntity<Problem> process(@Nullable ResponseEntity<Problem> entity, NativeWebRequest request) {
        if (entity == null || entity.getBody() == null) {
            return entity;
        }
        Problem problem = entity.getBody();
        ProblemBuilder builder;
        if (problem.getType() != null && problem.getType().getPath() != null && problem.getType().getHost().contains(ErrorConstants.BASE_URL)) {
            builder = Problem.builder()
                    .withType(problem.getType())
                    .withStatus(problem.getStatus())
                    .withTitle(problem.getTitle())
                    .withDetail(problem.getDetail())
                    .with(MESSAGE_KEY, problem.getDetail() != null ? problem.getDetail() : "خطایی رخ داده است");
            for (String key : problem.getParameters().keySet()) {
                builder.with(key, problem.getParameters().get(key));
            }
        } else {
            builder = Problem.builder()
                    .withType(ErrorConstants.INTERNAL_SERVER_ERROR)
                    .withStatus(Status.INTERNAL_SERVER_ERROR)
                    .withTitle(ResourceBundleInstance.getInstance().getMessage("exception.internal.server.error.title", null, Locale.getDefault()))
                    .withDetail(ResourceBundleInstance.getInstance().getMessage("exception.internal.server.error", null, Locale.getDefault()))
                    .with(MESSAGE_KEY, ResourceBundleInstance.getInstance().getMessage("exception.internal.server.error", null, Locale.getDefault()))
            ;
        }
        builder.with("path", request.getNativeRequest(HttpServletRequest.class).getRequestURI());
        if (problem instanceof ConstraintViolationProblem) {
            builder
                    .with("violations", ((ConstraintViolationProblem) problem).getViolations())
                    .with(MESSAGE_KEY, ErrorConstants.ERR_VALIDATION);
            return new ResponseEntity<>(builder.build(), entity.getHeaders(), entity.getStatusCode());
        } else {
            builder
                    .withInstance(problem.getInstance());
            problem.getParameters().forEach(builder::with);
            return new ResponseEntity<>(builder.build(), entity.getHeaders(), entity.getStatusCode());
        }
    }

    @Override
    public ResponseEntity<Problem> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, @Nonnull NativeWebRequest request) {
        BindingResult result = ex.getBindingResult();
        List<FieldErrorVM> fieldErrors = result.getFieldErrors().stream()
                .map(f -> new FieldErrorVM(f.getObjectName(), f.getField(), f.getDefaultMessage()))
                .collect(Collectors.toList());

        Problem problem = Problem.builder()
                .withType(ErrorConstants.CONSTRAINT_VIOLATION_TYPE)
                .withTitle("Method argument not valid")
                .withStatus(defaultConstraintViolationStatus())
                .with("message", ErrorConstants.ERR_VALIDATION)
                .with("fieldErrors", fieldErrors)
                .build();
        return create(ex, problem, request);
    }

    @Override
    public ResponseEntity<Problem> handleConstraintViolation(ConstraintViolationException exception, NativeWebRequest request) {
        return null;
    }
}
