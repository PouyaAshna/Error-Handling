package ir.core.lib.errorhandling.constant;

import java.net.URI;

public final class ErrorConstants {
    public static final String BASE_URL = "base-url";
    public static final String PROBLEM_BASE_URL = "http://" + BASE_URL + "/problem";
    public static final String ERR_VALIDATION = "error.validation";
    public static final URI INTERNAL_SERVER_ERROR = URI.create(PROBLEM_BASE_URL + "/internal-server-error");
    public static final URI CONSTRAINT_VIOLATION_TYPE = URI.create(PROBLEM_BASE_URL + "/constraint-violation");
    public static final URI NOT_FOUNT = URI.create(PROBLEM_BASE_URL + "/not-found");
    public static final URI EXIST = URI.create(PROBLEM_BASE_URL + "/exist");
    public static final URI HTTP = URI.create(PROBLEM_BASE_URL + "/http");
    public static final URI GENERAL = URI.create(PROBLEM_BASE_URL + "/general");
    public static final URI SECURITY = URI.create(PROBLEM_BASE_URL + "/security");
    public static final URI IO = URI.create(PROBLEM_BASE_URL + "/io");
    public static final URI COMMUNICATION = URI.create(PROBLEM_BASE_URL + "/communication");
}
