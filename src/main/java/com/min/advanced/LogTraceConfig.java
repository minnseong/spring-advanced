package com.min.advanced;

import com.min.advanced.trace.logtrace.LogTrace;
import com.min.advanced.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean // 스프링 빈으로 등록 - 싱글톤!
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
