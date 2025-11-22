package mx.ine.microservicios.bescine.contrato.aplicacion.convertidores;

import jakarta.enterprise.context.ApplicationScoped;
import mx.ine.microservicios.bescine.contrato.dominio.dto.ProveedorResponseDTO;
import mx.ine.microservicios.bescine.contrato.dominio.entidades.Proveedor;

@ApplicationScoped
public class ProveedorMapper {
    public ProveedorResponseDTO toProveedorResponseDTO(Proveedor proveedorEntity) {
        if (proveedorEntity == null){
            return null;
        }
        ProveedorResponseDTO proveedorResponseDTO = new ProveedorResponseDTO();
        proveedorResponseDTO.setIdProveedor(proveedorEntity.getId());
        proveedorResponseDTO.setRfc(proveedorEntity.getRfc());
        proveedorResponseDTO.setRazonSocial(proveedorEntity.getRazonSocial());
        proveedorResponseDTO.setCorreo(proveedorEntity.getCorreo());
        proveedorResponseDTO.setDomicilio(proveedorEntity.getDomicilio());
        proveedorResponseDTO.setEntidadFederativa(proveedorEntity.getEntidadFederativa());
        proveedorResponseDTO.setArticuloServicio(proveedorEntity.getArticuloServicio());
        proveedorResponseDTO.setEstatus(proveedorEntity.getEstatus());
        return proveedorResponseDTO;
    }

}
