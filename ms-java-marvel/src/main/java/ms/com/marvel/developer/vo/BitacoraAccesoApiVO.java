package ms.com.marvel.developer.vo;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;


public class BitacoraAccesoApiVO {
	private long idBitacoraAccesoApi;
	private String codigoApi;
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
