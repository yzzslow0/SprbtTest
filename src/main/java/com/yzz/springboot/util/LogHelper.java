package com.yzz.springboot.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Yzz
 */
public class LogHelper {

    private static Logger logger;

    public static Logger run(Object object) {
        return logger = LoggerFactory.getLogger(object.getClass());
    }

}
