package com.example.Reto.services;

import com.example.Reto.model.Empresa;
import com.example.Reto.model.Solicitud;
import com.example.Reto.model.Vacante;
import com.example.Reto.repository.EmpresaRepository;
import com.example.Reto.repository.SolicitudRepository;
import com.example.Reto.repository.VacanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VacanteServiceImpl implements VacanteService{

    @Autowired
    private VacanteRepository vacanteRepository;
    @Autowired
    private SolicitudRepository solicitudRepository;
    @Autowired
    private EmpresaRepository empresaRepository;

    // ------------------------------    EMPRESA ----------------------------------
    // Antes de guardar la vacante e insertarla en la base de datos le cambiamos el estatus a la vacante a CREADA para que siempre que se cree tenga ese estatus
    @Override
    public Vacante publicarVacante(Vacante vacante, int id_empresa) {
        vacante.setFecha(LocalDate.now());
        vacante.setEstatus(Vacante.Estatus.CREADA);

        Empresa empresa = empresaRepository.findById(id_empresa).orElse(null);

        vacante.setEmpresa(empresa);
        return vacanteRepository.save(vacante);





    }
    //Borrar Vacante(La ponemos en estado CANCELADA)
    @Override
    public void borrarVacante(int id_vacante) {
        Vacante vacante = vacanteRepository.findById(id_vacante).orElse(null);
        if(vacante != null){
            vacante.setEstatus(Vacante.Estatus.CANCELADA);
            vacanteRepository.save(vacante);
            System.out.println("La vacante ha sido borrada con éxito");
        }else {
            System.out.println("No se encontrón ninguna vacante con el id: " + id_vacante);
        }

    }
    //Asignar una solicitud a una vacante y cambiar su estado a ASIGNADO
    @Override
    public void asignarVacante(int id_vacante, int id_solicitud) {

        Vacante vacante = vacanteRepository.findById(id_vacante).orElse(null);
        Solicitud solicitud = solicitudRepository.findById(id_solicitud).orElse(null);
        if(vacante != null &&  solicitud != null){
            vacante.setEstatus(Vacante.Estatus.ASIGNADA);
            vacanteRepository.save(vacante);
            solicitud.setEstado(1);
            solicitudRepository.save(solicitud);

        }else {
            System.out.println("El nombre de la vacante o el id de la solicitud es incorrecto");
        }

    }

    @Override
    public List<Solicitud> obtenerSolicitudesDeVacante(int id_vacante) {
        Vacante vacante = vacanteRepository.findById(id_vacante).orElse(null);
        if(vacante != null){
            return vacante.getSolicitudes();
        }else{
            System.out.println("No hay vacantes en esta solicitud");
        }
        return null;
    }

    @Override
    public Optional<Vacante> buscarVacantePorId(int id_vacante) {
        return vacanteRepository.findById(id_vacante);
    }

    @Override
    public List<Vacante> buscarTodas(int id_empresa) {
        return vacanteRepository.findByIdEmpresa(id_empresa);
    }

    @Override
    public Vacante modificarVacante(int id_vacante, Vacante nuevavacante) {
        Vacante vacante = vacanteRepository.findById(id_vacante).orElse(null);

        if(vacante != null){
            if(nuevavacante.getNombre() != null){
                vacante.setNombre(nuevavacante.getNombre());
            }
            if(nuevavacante.getDescripcion() != null){
                vacante.setDescripcion(nuevavacante.getDescripcion());
            }
            if(nuevavacante.getSalario() != null){
                vacante.setSalario(nuevavacante.getSalario());
            }
            if(nuevavacante.getDestacado() != null){
                vacante.setDestacado(nuevavacante.getDestacado());
            }
            if(nuevavacante.getImagen() != null){
                vacante.setImagen(nuevavacante.getImagen());
            }
            if(nuevavacante.getDetalles() != null){
                vacante.setDetalles(nuevavacante.getDetalles());
            }
            return vacanteRepository.save(vacante);
        }else {
            return null;
        }
    }


    @Override
    public List<Vacante> buscarPorEmpresa(int id_empresa) {
          return vacanteRepository.findByEmpresa(id_empresa);
    }

    @Override
    public List<Vacante> buscarPorCategoria(int id_categoria) {
        return vacanteRepository.findByCategoria(id_categoria);

    }



}
