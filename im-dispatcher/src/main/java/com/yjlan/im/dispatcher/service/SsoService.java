package com.yjlan.im.dispatcher.service;

import com.yjlan.im.common.proto.AuthenticateRequest;
import org.springframework.stereotype.Service;

@Service
public class SsoService {


    /**
     * 验证是否已经登录获得token
     * @param request 认证请求
     * @return 是否认证
     */
    public boolean authenticate(AuthenticateRequest request) {
        return true;
    }
}
