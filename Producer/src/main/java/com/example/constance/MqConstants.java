package com.example.constance;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MqConstants {
    public static final String DEV_EXCHANGE = "dev-exchange";

    public static final String PARTITION_EXCHANGE = "partition-exchange";

    public static final String COMMIT_EXCHANGE = "commit-exchange";

    public static final String COMMIT_EXCHANGE_PRODUCER_CONFIRM = "commit-exchange-producer-confirm";

    public static final ThreadPoolExecutor EXECUTOR =
            new ThreadPoolExecutor(5,
                    10,
                    60,
                    TimeUnit.SECONDS,
                    new ArrayBlockingQueue<>(10)
            );
}
