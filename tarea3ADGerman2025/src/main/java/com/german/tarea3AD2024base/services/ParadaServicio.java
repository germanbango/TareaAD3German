package com.german.tarea3AD2024base.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.german.tarea3AD2024base.modelo.Parada;
import com.german.tarea3AD2024base.repositorios.ParadaRepositorio;


@Service
public class ParadaServicio {
	
	@Autowired
	private ParadaRepositorio paradaRepositorio;
	
	public Parada guardar(Parada entity) {
		return paradaRepositorio.save(entity);
	}
	
	public Parada actualizar(Parada entity) {
		return paradaRepositorio.save(entity);
	}
	
	public void borrar(Parada entity ) {
		paradaRepositorio.delete(entity);
	}
	
	public void borrarPorId(Long id) {
		paradaRepositorio.deleteById(id);
	}
	
	public void borrarPorLote(List<Parada> paradas) {
		paradaRepositorio.deleteAll(paradas);
	}
	
	public Parada encontrarPorId(Long id) {
		return paradaRepositorio.findById(id).get();
	}
	
	public List<Parada> encontrarTodos() {
		return paradaRepositorio.findAll();
	}
	 public boolean existeParadaConNombreYRegion(String nombre, char region) {
	        return paradaRepositorio.existsByNombreAndRegion(nombre, region);
	    }

}
