package com.min.advanced.trace.callback;

import com.min.advanced.trace.TraceStatus;
import com.min.advanced.trace.logtrace.LogTrace;

public class TraceTemplate {

    private LogTrace trace;

    public TraceTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public <T> T execute(String message, Callback<T> callback) {
        TraceStatus status = null;

        try {
            status = trace.begin(message);
            T result = callback.call();
            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
