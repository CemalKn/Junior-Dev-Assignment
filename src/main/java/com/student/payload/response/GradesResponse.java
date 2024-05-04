package com.student.payload.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
// Response class representing grades information sent to clients
public class GradesResponse {

    private String code;
    private Integer value;
}
