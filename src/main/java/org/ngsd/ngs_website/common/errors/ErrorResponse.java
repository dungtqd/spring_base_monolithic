package org.ngsd.ngs_website.common.errors;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Trieu Quang Dung
 * @created 2023.08.01 - 2:34 PM
 * @project NGS Website
 */
@Data
@AllArgsConstructor
public class ErrorResponse {

    private String errorMessage;
    private String field;
}
