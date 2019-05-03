package com.xaau.bs.busx.manager.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * description:
 * 
 * @author Mr.Tsang
 * @date 2019/4/13
 */
public class ValidateCodeException extends AuthenticationException {

    ValidateCodeException(String msg) {
        super(msg);
    }
}
