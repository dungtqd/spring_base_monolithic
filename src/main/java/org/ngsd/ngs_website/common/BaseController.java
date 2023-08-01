package org.ngsd.ngs_website.common;

import org.slf4j.Logger;

/**
 * @author Trieu Quang Dung
 * @created 2023.08.01 - 2:34 PM
 * @project NGS Website
 */
public class BaseController {
    protected final Logger logger;

    public BaseController(Logger logger) {
        this.logger = logger;
    }
}
