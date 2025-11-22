package mx.ine.microservicios.bescine.contrato.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContratoPaginadoResponseDTO {
    private Integer pageIndex;
    private Integer pageSize;
    private Integer totalItems;
    private Integer totalPages;
    private List<ContratoDataGridResponseDTO> contratoDatosGeneralesResponseDTOList;
}
