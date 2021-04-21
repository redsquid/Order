package ru.redsquid.examples.ms.order.mq.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

    public static final String EXCHANGE = "ms_exchange";

    public static final String STORE_ACCEPTATION_EVENT_QUEUE = "order_store_acceptation_event_queue";

    public static final String ACCOUNTING_INVOICING_EVENT_QUEUE = "order_accounting_invoicing_event_queue";

    public static final String ACCOUNTING_PAID_EVENT_QUEUE = "order_accounting_paid_event_queue";

    public static final String STORE_IN_PROGRESS_EVENT_QUEUE = "order_store_in_progress_event_queue";

    public static final String STORE_READY_EVENT_QUEUE = "order_store_ready_event_queue";
}
