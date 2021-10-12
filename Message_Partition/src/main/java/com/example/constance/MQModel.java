package com.example.constance;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


/*
 * 消息模型
 */
@Data
@Accessors(chain = true)
public class MQModel implements Serializable {
    private long mid;

    private long version;

    private long sno;

}
