package mx.ine.microservicios.bescine.contrato.aplicacion.convertidores;

import jakarta.enterprise.context.ApplicationScoped;
import mx.ine.microservicios.bescine.contrato.dominio.dto.ProveedorSolidarioResponseDTO;
import mx.ine.microservicios.bescine.contrato.dominio.entidades.Proveedor;

@ApplicationScoped
public class ProveedorSolidarioMapper {
    public void toContratoProveedorSolidarioResponseDTO(Proveedor proveedorEntity, ProveedorSolidarioResponseDTO proveedorSolidarioResponseDTO) {
        if (proveedorEntity == null){
            return;
        }
        if(proveedorSolidarioResponseDTO == null){
            return;
        }

        proveedorSolidarioResponseDTO.setRfc(proveedorEntity.getRfc());
        proveedorSolidarioResponseDTO.setRazonSocial(proveedorEntity.getRazonSocial());
        proveedorSolidarioResponseDTO.setCorreo(proveedorEntity.getCorreo());
        proveedorSolidarioResponseDTO.setDomicilio(proveedorEntity.getDomicilio());
        proveedorSolidarioResponseDTO.setEntidadFederativa(proveedorEntity.getEntidadFederativa());
        proveedorSolidarioResponseDTO.setArticuloServicio(proveedorEntity.getArticuloServicio());
    }

}
