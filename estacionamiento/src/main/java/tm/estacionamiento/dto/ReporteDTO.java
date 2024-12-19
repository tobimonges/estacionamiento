package tm.estacionamiento.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReporteDTO {
    private String descripcion;
    private Object datos;
}
