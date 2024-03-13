package com.example.testcontainers2024.dto.subscribing;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class subscriberStatus {
private final boolean result;
private final String error;

public subscriberStatus(boolean result, String errortext) {
    this.result = result;
    this.error = errortext;
}
}
