package ms.com.marvel.developer.bd;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "BITACORA_ACCESO_API")
public class BitacoraAccesoApiEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   	@Column(name = "ID_BITACORA_ACCESO_API", nullable = false)
	private long idBitacoraAccesoApi;
	
	@Column(name = "CODIGO_API", nullable = false)
	private String codigoApi;
	
	@Column(name = "FECHA_CONSULTA", nullable = false)
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private LocalDateTime fechaConsulta;

	/**
	 * @return the idBitacoraAccesoApi
	 */
	public long getIdBitacoraAccesoApi() {
		return idBitacoraAccesoApi;
	}

	/**
	 * @param idBitacoraAccesoApi the idBitacoraAccesoApi to set
	 */
	public void setIdBitacoraAccesoApi(long idBitacoraAccesoApi) {
		this.idBitacoraAccesoApi = idBitacoraAccesoApi;
	}

	/**
	 * @return the codigoApi
	 */
	public String getCodigoApi() {
		return codigoApi;
	}

	/**
	 * @param codigoApi the codigoApi to set
	 */
	public void setCodigoApi(String codigoApi) {
		this.codigoApi = codigoApi;
	}

	/**
	 * @return the fechaConsulta
	 */
	public LocalDateTime getFechaConsulta() {
		return fechaConsulta;
	}

	/**
	 * @param fechaConsulta the fechaConsulta to set
	 */
	public void setFechaConsulta(LocalDateTime fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}

}
