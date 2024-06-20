package com.yjlan.im.business.async;

import com.yjlan.async.AsyncContext;

/**
 * @author yjlan
 * @version V1.0
 * @Description 要传递的内容
 * @date 2022.02.24 16:30
 */
public class PrintContext extends AsyncContext {
    
    /**
     * 内容
     */
    private String content;
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
}
