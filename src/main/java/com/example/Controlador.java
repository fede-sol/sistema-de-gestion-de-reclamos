package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
//import javax.swing.text.html.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.exceptions.EdificioException;
import com.example.exceptions.PersonaException;
import com.example.exceptions.ReclamoException;
import com.example.exceptions.UnidadException;
import com.example.modelo.Edificio;
import com.example.modelo.Imagen;
import com.example.modelo.Persona;
import com.example.modelo.Reclamo;
import com.example.modelo.Unidad;
import com.example.modelo.repository.EdificioRepository;
import com.example.modelo.repository.ImagenRepository;
import com.example.modelo.repository.PersonaRepository;
import com.example.modelo.repository.ReclamoRepository;
import com.example.modelo.repository.UnidadRepository;
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

	public List<UnidadView> getUnidadesPorEdificio(int codigo) throws EdificioException {
		List<UnidadView> resultado = new ArrayList<UnidadView>();
		Edificio edificio = buscarEdificio(codigo);
		List<Unidad> unidades = edificio.getUnidades();
		for (Unidad unidad : unidades)
			resultado.add(unidad.toView());
		return resultado;
	}

	public List<PersonaView> habilitadosPorEdificio(int codigo) throws EdificioException {
		List<PersonaView> resultado = new ArrayList<PersonaView>();
		Edificio edificio = buscarEdificio(codigo);
		Set<Persona> habilitados = edificio.habilitados();
		for (Persona persona : habilitados)
			resultado.add(persona.toView());
		return resultado;
	}

	public List<PersonaView> dueniosPorEdificio(int codigo) throws EdificioException {
		List<PersonaView> resultado = new ArrayList<PersonaView>();
		Edificio edificio = buscarEdificio(codigo);
		Set<Persona> duenios = edificio.duenios();
		for (Persona persona : duenios)
			resultado.add(persona.toView());
		return resultado;
	}

	public List<PersonaView> habitantesPorEdificio(int codigo) throws EdificioException {
		List<PersonaView> resultado = new ArrayList<PersonaView>();
		Edificio edificio = buscarEdificio(codigo);
		Set<Persona> habitantes = edificio.habitantes();
		for (Persona persona : habitantes)
			resultado.add(persona.toView());

		if (resultado.isEmpty())
			return null;

		return resultado;
	}

	public List<PersonaView> dueniosPorUnidad(int codigo, String piso, String numero) throws UnidadException {
		List<PersonaView> resultado = new ArrayList<PersonaView>();
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		List<Persona> duenios = unidad.getDuenios();
		for (Persona persona : duenios)
			resultado.add(persona.toView());
		return resultado;
	}

	public List<PersonaView> inquilinosPorUnidad(int codigo, String piso, String numero) throws UnidadException {
		List<PersonaView> resultado = new ArrayList<PersonaView>();
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		List<Persona> inquilinos = unidad.getInquilinos();
		for (Persona persona : inquilinos)
			resultado.add(persona.toView());
		return resultado;
	}

	public void transferirUnidad(int codigo, String piso, String numero, String documento)
			throws UnidadException, PersonaException {
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		Persona persona = buscarPersona(documento);
		unidad.transferir(persona);
		unidadRepository.save(unidad);
	}

	public void agregarDuenioUnidad(int codigo, String piso, String numero, String documento)
			throws UnidadException, PersonaException {
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		Persona persona = buscarPersona(documento);
		unidad.agregarDuenio(persona);
		unidadRepository.save(unidad);
	}

	public void alquilarUnidad(int codigo, String piso, String numero, String documento)
			throws UnidadException, PersonaException {
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		Persona persona = buscarPersona(documento);
		unidad.alquilar(persona);
		unidadRepository.save(unidad);
	}

	public void agregarInquilinoUnidad(int codigo, String piso, String numero, String documento)
			throws UnidadException, PersonaException {
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		Persona persona = buscarPersona(documento);
		unidad.agregarInquilino(persona);
		unidadRepository.save(unidad);
	}

	public void liberarUnidad(int codigo, String piso, String numero) throws UnidadException {
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		unidad.liberar();
		unidadRepository.save(unidad);
	}

	public void habitarUnidad(int codigo, String piso, String numero) throws UnidadException {
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		unidad.habitar();
		unidadRepository.save(unidad);
	}

	public void agregarPersona(String documento, String nombre, String mail, String contrasenia) {
		Persona persona = new Persona(documento, nombre, mail, contrasenia);
		personaRepository.save(persona);
	}

	public void eliminarPersona(String documento) throws PersonaException {
		if (!unidadRepository.findAllByDueniosDocumento(documento).isEmpty()) {
			throw new PersonaException("la persona es un duenio");
		} else {
			List<Reclamo> reclamos = reclamoRepository.findAllByUsuario_Documento(documento);
			for (Reclamo elemento : reclamos) {
				for (Imagen foto : elemento.getImagenes()) {
					imagenRepository.delete(imagenRepository.findById(foto.getNumero()).get());
				}
				elemento.borrarImagenes();
				reclamoRepository.save(elemento);
				reclamoRepository.delete(elemento);
			}
			List<Unidad> unidades = unidadRepository.findAllByInquilinosDocumento(documento);
			for (Unidad elemento : unidades) {
				elemento.borrarInquilino(documento);
				unidadRepository.save(elemento);
			}
			personaRepository.delete(buscarPersona(documento));
		}
	}

	public List<ReclamoView> reclamosPorEdificio(int codigo) throws EdificioException {
		Edificio edificio = edificioRepository.findById(codigo).get();
		List<Reclamo> reclamos = reclamoRepository.findByEdificio_Codigo(edificio.getCodigo());
		List<ReclamoView> reclamos2 = new ArrayList<ReclamoView>();
		for (Reclamo elemento : reclamos) {
			reclamos2.add(elemento.toView());
		}
		return reclamos2;
	}

	public List<ReclamoView> reclamosPorUnidad(int codigo, String piso, String numero) {
		Edificio edificio = edificioRepository.findById(codigo).get();
		List<Unidad> unidades = edificio.getUnidades();
		Unidad unidad = new Unidad();
		for (Unidad elemento : unidades) {
			if (elemento.getPiso() == piso) {
				unidad = elemento;
			}
		}
		List<Reclamo> reclamos = reclamoRepository.findByUnidad_Id(unidad.getId());
		List<ReclamoView> reclamosV = new ArrayList<>();
		for (Reclamo elemento : reclamos) {
			reclamosV.add(elemento.toView());
		}
		return reclamosV;
	}

	public List<ReclamoView> reclamosPorNumero(int numero) {
		List<Reclamo> resultado = reclamoRepository.findByNumero(numero);
		List<ReclamoView> reclamos = new ArrayList<>();
		for (Reclamo elemento : resultado) {
			reclamos.add(elemento.toView());
		}
		return reclamos;
	}

	public void agregarReclamo(int codigo, String piso, String numeroEdificio, String documento, String ubicacion,
			String descripcion) throws EdificioException, UnidadException, PersonaException {
		Edificio edificio = buscarEdificio(codigo);
		if (edificio.getUnidades().contains(buscarUnidad(codigo, piso, numeroEdificio))) {
			if ((buscarUnidad(codigo, piso, numeroEdificio).getInquilinos().contains(buscarPersona(documento)))
					|| (buscarUnidad(codigo, piso, numeroEdificio).getDuenios().contains(buscarPersona(documento)))) {
				Reclamo reclamo = new Reclamo(buscarPersona(documento), edificio, ubicacion, descripcion,
						buscarUnidad(codigo, piso, numeroEdificio));
				reclamoRepository.save(reclamo);
			} else {
				throw new UnidadException("la persona no es duenio y/o inquilino");
			}
		} else {
			throw new EdificioException("la unidad no esta en el edificio");
		}
	}

	public List<ReclamoView> reclamosPorEstado(Estado estado) {
		List<ReclamoView> resultado = new ArrayList<ReclamoView>();
		List<Reclamo> reclamos = reclamoRepository.findAllByEstado(estado);
		for (Reclamo reclamo : reclamos)
			resultado.add(reclamo.toView());
		return resultado;
	}

	public List<ReclamoView> reclamosPorPersona(String documento) throws PersonaException {
		List<ReclamoView> reclamos = new ArrayList<ReclamoView>();
		List<Reclamo> reclamosPersona = reclamoRepository.findAllByUsuario_Documento(documento);
		for (Reclamo reclamo : reclamosPersona)
			reclamos.add(reclamo.toView());
		return reclamos;
	}

	public void agregarImagenAReclamo(int idreclamo, String direccion, String tipo) throws ReclamoException {

		Reclamo reclamo = buscarReclamo(idreclamo);
		Imagen imagen = new Imagen(direccion, tipo, idreclamo);
		imagenRepository.save(imagen);
		reclamo.agregarImagen(imagen);
		reclamoRepository.save(reclamo);

	}

	public void cambiarEstado(int numero, Estado estado) throws ReclamoException {
		Reclamo reclamo = buscarReclamo(numero);
		reclamo.cambiarEstado(estado);
		reclamoRepository.save(reclamo);
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
	private Unidad buscarUnidad(int codigo, String piso, String numero) throws UnidadException {
		Optional<Unidad> unidad = unidadRepository.findByEdificioCodigoAndPisoAndNumero(codigo, piso, numero);

		if (unidad.isPresent())
			return unidad.get();
		else
			throw new UnidadException("No existe la unidad");
	}

	// DONE (JPA Repository) - Internal
	public Persona buscarPersona(String documento) throws PersonaException { //////////////$$$$$$$$$$$$$$$$$$ private
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
