package com.postech.logistica.dto;

import java.util.List;

public record MapApiResponseDTO (
        List<ResultDTO> results
) {
}
