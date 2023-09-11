package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

import com.example.exceptions.EdificioException;
import com.example.exceptions.PersonaException;
import com.example.exceptions.ReclamoException;
import com.example.exceptions.UnidadException;
import com.example.modelo.Edificio;
import com.example.modelo.Persona;
import com.example.modelo.Reclamo;
import com.example.modelo.Unidad;
import com.example.modelo.repository.EdificioRepository;
import com.example.modelo.repository.ImagenRepository;
import com.example.modelo.repository.PersonaRepository;
import com.example.modelo.repository.ReclamoRepository;
import com.example.modelo.repository.UnidadRepository;
import com.example.views.EdificioView;
import com.example.views.Estado;
import com.example.views.PersonaView;
import com.example.views.ReclamoView;
import com.example.views.UnidadView;



@Controller
public class Controlador {

	@Autowired
	PersonaRepository personaRepository;

	@Autowired
	EdificioRepository edificioRepository;

	@Autowired
	ImagenRepository imagenRepository;

	@Autowired
	ReclamoRepository reclamoRepository;

	@Autowired
	UnidadRepository unidadRepository;

	public void prueba(){



		List<Edificio> lista = edificioRepository.findAll();



		System.out.println();


	}

	public List<EdificioView> getEdificios(){
		return null;
	}

	public Persona getPersona(String nombre){

		Optional<Persona> lista = personaRepository.findByNombre(nombre);

		if(lista.isEmpty()){
			return null;
		}else{
			return lista.get(); //si retorno solo esto cuando es null, tira una ecepcion... genera un error
		}
	}

	// Fede -----------------------------------------------------------------------------

	public List<UnidadView> getUnidadesPorEdificio(int codigo) throws EdificioException{
		List<UnidadView> resultado = new ArrayList<UnidadView>();
		Edificio edificio = buscarEdificio(codigo);
		List<Unidad> unidades = edificio.getUnidades();
		for(Unidad unidad : unidades)
			resultado.add(unidad.toView());
		return resultado;
	}

	public List<PersonaView> habilitadosPorEdificio(int codigo) throws EdificioException{
		List<PersonaView> resultado = new ArrayList<PersonaView>();
		Edificio edificio = buscarEdificio(codigo);
		Set<Persona> habilitados = edificio.habilitados();
		for(Persona persona : habilitados)
			resultado.add(persona.toView());
		return resultado;
	}

	public List<PersonaView> dueniosPorEdificio(int codigo) throws EdificioException{
		List<PersonaView> resultado = new ArrayList<PersonaView>();
		Edificio edificio = buscarEdificio(codigo);
		Set<Persona> duenios = edificio.duenios();
		for(Persona persona : duenios)
			resultado.add(persona.toView());
		return resultado;
	}

	public List<PersonaView> habitantesPorEdificio(int codigo) throws EdificioException{
		List<PersonaView> resultado = new ArrayList<PersonaView>();
		Edificio edificio = buscarEdificio(codigo);
		Set<Persona> habitantes = edificio.habitantes();
		for(Persona persona : habitantes)
			resultado.add(persona.toView());

		if (resultado.isEmpty())
			return null;

		return resultado;
	}

	public List<PersonaView> dueniosPorUnidad(int codigo, String piso, String numero) throws UnidadException{
		List<PersonaView> resultado = new ArrayList<PersonaView>();
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		List<Persona> duenios = unidad.getDuenios();
		for(Persona persona : duenios)
			resultado.add(persona.toView());
		return resultado;
	}

	public List<PersonaView> inquilinosPorUnidad(int codigo, String piso, String numero) throws UnidadException{
		List<PersonaView> resultado = new ArrayList<PersonaView>();
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		List<Persona> inquilinos = unidad.getInquilinos();
		for(Persona persona : inquilinos)
			resultado.add(persona.toView());
		return resultado;
	}

	// Igna -----------------------------------------------------------------------------

	public void transferirUnidad(int codigo, String piso, String numero, String documento) throws UnidadException, PersonaException {
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		Persona persona = buscarPersona(documento);
		unidad.transferir(persona);

		// actualizar la unidad con el nuevo dueño
		unidadRepository.save(unidad);
	}

	public void agregarDuenioUnidad(int codigo, String piso, String numero, String documento) throws UnidadException, PersonaException {
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		Persona persona = buscarPersona(documento);
		unidad.agregarDuenio(persona);

		// actualizar la unidad con el dueño agregado
		unidadRepository.save(unidad);
	}

	public void alquilarUnidad(int codigo, String piso, String numero, String documento) throws UnidadException, PersonaException{
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		Persona persona = buscarPersona(documento);
		unidad.alquilar(persona);

		// actualizar la unidad con el nuevo inquilino
		unidadRepository.save(unidad);
	}

	public void agregarInquilinoUnidad(int codigo, String piso, String numero, String documento) throws UnidadException, PersonaException{
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		Persona persona = buscarPersona(documento);
		unidad.agregarInquilino(persona);

		// actualizar la unidad con el inquilino agregado
		unidadRepository.save(unidad);
	}

	public void liberarUnidad(int codigo, String piso, String numero) throws UnidadException {
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		unidad.liberar();

		// actualizar la unidad eliminando los inquilinos
		unidadRepository.save(unidad);
	}

	public void habitarUnidad(int codigo, String piso, String numero) throws UnidadException {
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		unidad.habitar();

		// actualizar la unidad (habitada)
		unidadRepository.save(unidad);
	}

	// Santi ------------------------------------------------------------------------------

	public void agregarPersona(String documento, String nombre, String mail, String contrasenia) {
		Persona persona = new Persona(documento, nombre, mail, contrasenia);
		personaRepository.save(persona);
		//guardar el objeto
	}
	
	public void eliminarPersona(String documento) throws PersonaException {  
		Persona persona = buscarPersona(documento);
		personaRepository.delete(persona);
		//eliminar el objeto
	}
	//############################################## se queda en un bucle y tira error
	public List<ReclamoView> reclamosPorEdificio(int codigo)throws EdificioException{
		Edificio edificio = buscarEdificio(codigo);
		List<ReclamoView> reclamosV = new ArrayList<ReclamoView>();
		List<Reclamo> reclamos = reclamoRepository.findAll();
		System.out.println("BBBBBBBB");
		for(Reclamo elemento: reclamos)
			if (elemento.getEdificio() != edificio){
				reclamosV.add(elemento.toView());
				System.out.println("DDDDDDD");
			}
		System.out.println("CCCCCCC");
		return reclamosV;
	}
	//##############################################
	public List<ReclamoView> reclamosPorUnidad(int codigo, String piso, String numero) {
		List<ReclamoView> resultado = new ArrayList<ReclamoView>();
		return resultado;
	}
	//##############################################
	public ReclamoView reclamosPorNumero(int numero) {
		ReclamoView resultado = null;
		return resultado;
	}

	public void agregarReclamo(int codigo, String piso, String numero, String documento, String ubicacion, String descripcion) throws EdificioException, UnidadException, PersonaException {
		Edificio edificio = buscarEdificio(codigo);
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		Persona persona = buscarPersona(documento);
		Reclamo reclamo = new Reclamo(persona, edificio, ubicacion, descripcion, unidad);
		reclamoRepository.save(reclamo);
	}

	// función extra (filtrar reclamos por estado -- enum) ---------------- NO TESTED
	//##############################################
	public List<ReclamoView> reclamosPorEstado(Estado estado) {
		List<ReclamoView> resultado = new ArrayList<ReclamoView>();
		List<Reclamo> reclamos = reclamoRepository.findAllByEstado(estado);
		for(Reclamo reclamo : reclamos)
			resultado.add(reclamo.toView());
		return resultado;
	}

	// Juani ------------------------------------------------------------------------------

	public List<ReclamoView> reclamosPorPersona(String documento) {
		List<ReclamoView> resultado = new ArrayList<ReclamoView>();
		return resultado;
	}

	public void agregarImagenAReclamo(int numero, String direccion, String tipo) throws ReclamoException {
		Reclamo reclamo = buscarReclamo(numero);
		reclamo.agregarImagen(direccion, tipo);
	}

	public void cambiarEstado(int numero, Estado estado) throws ReclamoException {
		Reclamo reclamo = buscarReclamo(numero);
		reclamo.cambiarEstado(estado);
	}

	// DONE (JPA Repository) - Internal
	private Edificio buscarEdificio(int codigo) throws EdificioException {
		Optional<Edificio> edificio = edificioRepository.findById(codigo);

		if (edificio.isPresent())
			return edificio.get();
		else
			throw new EdificioException("No existe el edificio");
	}

	// DONE (JPA Repository) - Internal
	private Unidad buscarUnidad(int codigo, String piso, String numero) throws UnidadException{
		Optional<Unidad> unidad = unidadRepository.findByEdificioCodigoAndPisoAndNumero(codigo, piso, numero);

		if (unidad.isPresent())
			return unidad.get();
		else
			throw new UnidadException("No existe la unidad");
	}

	// DONE (JPA Repository) - Internal
	private Persona buscarPersona(String documento) throws PersonaException {
		Optional<Persona> persona = personaRepository.findById(documento);

		if (persona.isPresent())
			return persona.get();
		else
			throw new PersonaException("No existe la persona");
	}

	// DONE (JPA Repository) - Internal
	private Reclamo buscarReclamo(int numero) throws ReclamoException {
		Optional<Reclamo> reclamo = reclamoRepository.findById(numero);

		if (reclamo.isPresent())
			return reclamo.get();
		else
			throw new ReclamoException("No existe el reclamo");
	}
}
