package ms.com.marvel.developer.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ms.com.marvel.developer.bd.BitacoraAccesoApiEntity;
import ms.com.marvel.developer.bd.BitacoraAccesoApiRepositoryDao;
import ms.com.marvel.developer.vo.BitacoraAccesoApiVO;

@Service
public class BitacoraAccesoApiAppImpl implements BitacoraAccesoApiApp{
	@Autowired
	private BitacoraAccesoApiRepositoryDao bitacoraAccesoApiRepositoryDao;

	@Override
	public List<BitacoraAccesoApiVO> getBitacoraAccesoApiLst() {
		
		List<BitacoraAccesoApiEntity> bitacoraAccesoApiEntityLst = (List<BitacoraAccesoApiEntity>) bitacoraAccesoApiRepositoryDao.findAll();

		List<BitacoraAccesoApiVO> bitacoraAccesoApiVOLst = new ArrayList<>();

		BitacoraAccesoApiVO bitacoraAccesoApiVO;
		for (BitacoraAccesoApiEntity bitacoraAccesoApiEntity : bitacoraAccesoApiEntityLst) {
			bitacoraAccesoApiVO = new BitacoraAccesoApiVO();
			bitacoraAccesoApiVO.setCodigoApi(bitacoraAccesoApiEntity.getCodigoApi());
			bitacoraAccesoApiVO.setFechaConsulta(bitacoraAccesoApiEntity.getFechaConsulta());
			bitacoraAccesoApiVO.setIdBitacoraAccesoApi(bitacoraAccesoApiEntity.getIdBitacoraAccesoApi());
			bitacoraAccesoApiVOLst.add(bitacoraAccesoApiVO);
		}
		
		return bitacoraAccesoApiVOLst;
	}
}
