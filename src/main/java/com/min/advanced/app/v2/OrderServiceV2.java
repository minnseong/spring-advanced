package com.min.advanced.app.v2;

import com.min.advanced.trace.TraceId;
import com.min.advanced.trace.TraceStatus;
import com.min.advanced.trace.hellotrace.HelloTraceV1;
import com.min.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 trace;

    public void orderItem(String itemId, TraceId nextId) {

        TraceStatus status = null;
        try {
            status = trace.beginSync(nextId, "OrderService.orderItem()");
            orderRepository.save(itemId, status.getTraceId());
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
