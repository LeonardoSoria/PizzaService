package com.lsoria.loginservice.domain.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogEntry {

    private Long id;

    private String message;

    private String timestamp;
}
