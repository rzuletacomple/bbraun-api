package com.bbraun.config;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;
    private Integer status;
    private String info;

    public ServiceException(String message, Integer status, String info) {
        this.message = message;
        this.status = status;
        this.info = info;
    }

}
