package ru.redsquid.examples.ms.order.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QueueName {

    public static final String STORE_ACCEPTATION_COMMAND = "store_acceptation_command";

    public static final String STORE_ACCEPTATION_EVENT = "store_acceptation_event";

    public static final String ACCOUNTING_INVOICED_EVENT = "accounting_invoiced_event";

    public static final String ACCOUNTING_PAID_EVENT = "accounting_paid_event";

    public static final String STORE_IN_PROGRESS_EVENT = "store_in_progress_event";

    public static final String STORE_READY_EVENT = "store_ready_event";
}
