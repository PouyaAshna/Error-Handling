package ir.core.lib.errorhandling.exception;


import ir.core.lib.errorhandling.vm.FieldErrorVM;

import java.util.List;

public class BaseException {
    private String type;
    private String title;
    private int status;
    private String detail;
    private String path;
    private String message;
    private List<FieldErrorVM> fieldErrors;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<FieldErrorVM> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<FieldErrorVM> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    @Override
    public String toString() {
        return "BaseException{" +
                "type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                ", detail='" + detail + '\'' +
                ", path='" + path + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
