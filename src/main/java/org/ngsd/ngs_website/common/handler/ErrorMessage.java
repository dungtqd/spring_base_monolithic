package org.ngsd.ngs_website.common.handler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Trieu Quang Dung
 * @created 2023.08.01 - 2:41 PM
 * @project NGS Website
 */
@Data
@Builder
@AllArgsConstructor
public class ErrorMessage {
    private final int code;
    private final String message;
}
