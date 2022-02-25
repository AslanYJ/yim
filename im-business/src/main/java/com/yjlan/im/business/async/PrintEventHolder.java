package com.yjlan.im.business.async;

import com.yjlan.im.business.async.event.Print1Event;
import com.yjlan.im.business.async.event.Print2Event;
import com.yjlan.im.business.async.event.Print3Event;

/**
 * @author yjlan
 * @version V1.0
 * @Description 初始化所有数据类型
 * @date 2022.02.24 16:44
 */
public class PrintEventHolder {
    
    public static final Print1Event PRINT_1_EVENT = new Print1Event();
    
    public static final Print2Event PRINT_2_EVENT = new Print2Event();
    
    public static final Print3Event PRINT_3_EVENT = new Print3Event();
    
    
}
