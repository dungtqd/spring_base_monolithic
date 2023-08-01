package org.ngsd.ngs_website.common.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Trieu Quang Dung
 * @created 2023.08.01 - 2:34 PM
 * @project NGS Website
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LogicException extends RuntimeException {

    public LogicException(String exception) {
        super(exception);
    }
}
