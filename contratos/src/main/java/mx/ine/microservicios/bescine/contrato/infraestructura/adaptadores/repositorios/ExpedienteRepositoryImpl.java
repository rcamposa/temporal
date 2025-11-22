package mx.ine.microservicios.bescine.contrato.infraestructura.adaptadores.repositorios;

import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import mx.ine.microservicios.bescine.contrato.aplicacion.puertos.repositorios.IExpedienteRepository;
import mx.ine.microservicios.bescine.contrato.dominio.entidades.Expediente;

import java.util.List;

@ApplicationScoped
public class ExpedienteRepositoryImpl implements IExpedienteRepository {

    @Override
    public Boolean updateEstatusExpediente(Long id, Integer idEstatus) {

        int valorRet = update("IdEstatus = :valor WHERE id = :id",
                Parameters.with("valor", idEstatus).and("id", id));
        if(valorRet == 0){
            return false;
        }
        return true;
    }

    @Override
    public Expediente findById(Long id) {
        return find("id",id).firstResult();
    }

    @Override
    public Expediente findByNumeroExpediente(String numeroExpediente) {
        return find("numeroExpediente",numeroExpediente).firstResult();
    }

    @Override
    public List<Expediente> findListaExpediente() {
        return listAll();
    }

}
