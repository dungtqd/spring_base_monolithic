package org.ngsd.ngs_website.common.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Trieu Quang Dung
 * @created 2023.08.01 - 2:34 PM
 * @project NGS Website
 */
@AllArgsConstructor
@Getter
public enum ErrorMessages {
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR"), // request sai trang thai
    USER_USERNAME_PASSWORD_ERROR("USER_USERNAME_PASSWORD_ERROR"), // Username password ko hợp lệ
    USER_USERNAME_ALREADY_ERROR("USER_USERNAME_EXIT_ERROR"), // Username password ko hợp lệ
    USER_ADMIN_AGENT_ALREADY_ERROR("USER_ADMIN_AGENT_ALREADY_ERROR"), // Username password ko hợp lệ
    ROLE_NOT_FOUND_ERROR("ROLE_NOT_FOUND_ERROR"), // call otp error
    USER_NOT_FOUND_ERROR("USER_NOT_FOUND_ERROR"); // call otp error
    private final String message;
}
