package clases;

import java.time.LocalDate;
import java.util.HashSet;

import interfaces.Tarea;

public class Salida {
		private byte numeroPax;
		private boolean mascota;
		private boolean ninios;
		private LocalDate fechaEntrada;
		private Empleado empleado;
		private HashSet<Tarea> tareas;
		public byte getNumeroPax() {
			return numeroPax;
		}
		public void setNumeroPax(byte numeroPax) {
			this.numeroPax = numeroPax;
		}
		public boolean isMascota() {
			return mascota;
		}
		public void setMascota(boolean mascota) {
			this.mascota = mascota;
		}
		public boolean isNinios() {
			return ninios;
		}
		public void setNinios(boolean ninios) {
			this.ninios = ninios;
		}
		public LocalDate getFechaEntrada() {
			return fechaEntrada;
		}
		public void setFechaEntrada(LocalDate fechaEntrada) {
			this.fechaEntrada = fechaEntrada;
		}
		public Empleado getEmpleado() {
			return empleado;
		}
		public void setEmpleado(Empleado empleado) {
			this.empleado = empleado;
		}
		public HashSet<Tarea> getTareas() {
			return tareas;
		}
		public void setTareas(HashSet<Tarea> tareas) {
			this.tareas = tareas;
		}
		public Salida(byte numeroPax, boolean mascota, boolean ninios, LocalDate fechaEntrada, Empleado empleado,
				HashSet<Tarea> tareas) {
			this.numeroPax = numeroPax;
			this.mascota = mascota;
			this.ninios = ninios;
			this.fechaEntrada = fechaEntrada;
			this.empleado = empleado;
			this.tareas = tareas;
		} 
		
		public void anadirTarea(Tarea t) {
			this.tareas.add(t);
		}
		
		public void quitarTarea(Tarea t) {
			this.tareas.remove(t);
		}
		
		public Salida() {
			
		}
	}

