package org.ngsd.ngs_website.common.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Trieu Quang Dung
 * @created 2023.08.01 - 2:34 PM
 * @project NGS Website
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(String exception) {
        super(exception);
    }
}
