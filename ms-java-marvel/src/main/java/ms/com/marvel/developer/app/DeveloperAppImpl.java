package ms.com.marvel.developer.app;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.json.JSONException;
import org.json.JSONObject;
import com.marvel.developer.ConectorMarvelAPI;

import ms.com.marvel.developer.bd.BitacoraAccesoApiEntity;
import ms.com.marvel.developer.bd.BitacoraAccesoApiRepositoryDao;

@Service
public class DeveloperAppImpl implements DeveloperApp{
	@Autowired
	private ConectorMarvelAPI conectorMarvelAPI;
	@Autowired
	private BitacoraAccesoApiRepositoryDao bitacoraAccesoApiRepositoryDao;
	@Value("${urlBase}")
	private String urlBase;
	@Value("${pathCharacter}")
	private String pathCharacter;
	@Value("${pathCharacterById}")
	private String pathCharacterById;
	@Value("${publicKey}")
	private String publicKey;
	@Value("${privateKey}")
	private String privateKey;


	@Override
	public String getAllCharacters() {
		Long ts = new Date().getTime();

		String jsonResponse = conectorMarvelAPI.conect(urlBase, pathCharacter, publicKey, privateKey, ts);		

		try {
			JSONObject jo = new JSONObject(jsonResponse);

			if(jo.optLong("code")== 200L) {

				BitacoraAccesoApiEntity bitacoraAccesoApiEntity = new BitacoraAccesoApiEntity();

				bitacoraAccesoApiEntity.setCodigoApi("AllCharacters");
				bitacoraAccesoApiEntity.setFechaConsulta(LocalDateTime.now());

				bitacoraAccesoApiRepositoryDao.save(bitacoraAccesoApiEntity);
			}

		} catch (JSONException e) {

		}

		return jsonResponse;
	}


	@Override
	public String getCharacterById(Long characterId) {
		Long ts = new Date().getTime();

		String path = pathCharacterById.replace("{characterId}", characterId.toString());

		String jsonResponse = conectorMarvelAPI.conect(urlBase, path, publicKey, privateKey, ts);		

		try {
			JSONObject jo = new JSONObject(jsonResponse);

			if(jo.optLong("code")== 200L) {

				BitacoraAccesoApiEntity bitacoraAccesoApiEntity = new BitacoraAccesoApiEntity();

				bitacoraAccesoApiEntity.setCodigoApi("CharacterById");
				bitacoraAccesoApiEntity.setFechaConsulta(LocalDateTime.now());

				bitacoraAccesoApiRepositoryDao.save(bitacoraAccesoApiEntity);
			}

		} catch (JSONException e) {

		}

		return jsonResponse;
	}


}
