package com.incidentmanagement.util;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtil {
	
	public static Map<String, Map<String, String>> parseSimpleDropDowns(InputStream in) {
		
		JSONParser parser = new JSONParser();

		Map<String, Map<String, String>> dropdowns = new HashMap<>();

		try {
			Object object = parser.parse(new InputStreamReader(in, "UTF-8"));

			// convert Object to JSONObject
			JSONObject jsonObject = (JSONObject) object;

			// AK
			JSONArray akJsonArray = (JSONArray) jsonObject.get(Constants.DECISION_ADMISSION_REJECT);

			Map<String, String> akMap = new HashMap<>();

			for (int i = 0; i < akJsonArray.size(); i++) {
				String value = (String) akJsonArray.get(i);

				akMap.put(value, value);
			}

			dropdowns.put(Constants.DECISION_ADMISSION_REJECT, akMap);

			// AL
			JSONArray alJsonArray = (JSONArray) jsonObject.get(Constants.STATUS_DE_INCIDENT);

			Map<String, String> alMap = new HashMap<>();

			for (int i = 0; i < alJsonArray.size(); i++) {
				String value = (String) alJsonArray.get(i);

				alMap.put(value, value);
			}

			dropdowns.put(Constants.STATUS_DE_INCIDENT, alMap);

			// AM
			JSONArray amJsonArray = (JSONArray) jsonObject.get(Constants.TYPE_DE_REFERENCE_EXTERNE);

			Map<String, String> amMap = new HashMap<>();

			for (int i = 0; i < amJsonArray.size(); i++) {
				String value = (String) amJsonArray.get(i);

				amMap.put(value, value);
			}

			dropdowns.put(Constants.TYPE_DE_REFERENCE_EXTERNE, amMap);

			// AV
			JSONArray avJsonArray = (JSONArray) jsonObject.get(Constants.CODE_ETAT_ACTUAEL_DU_PERT_SUR);

			Map<String, String> avMap = new HashMap<>();

			for (int i = 0; i < avJsonArray.size(); i++) {
				String value = (String) avJsonArray.get(i);

				avMap.put(value, value);
			}

			dropdowns.put(Constants.CODE_ETAT_ACTUAEL_DU_PERT_SUR, avMap);

			// AW
			JSONArray awJsonArray = (JSONArray) jsonObject.get(Constants.ETATE_DE_LA_PERTE);

			Map<String, String> awMap = new HashMap<>();

			for (int i = 0; i < awJsonArray.size(); i++) {
				String value = (String) awJsonArray.get(i);

				awMap.put(value, value);
			}

			dropdowns.put(Constants.ETATE_DE_LA_PERTE, awMap);

			// AX
			JSONArray axJsonArray = (JSONArray) jsonObject.get(Constants.CLASSIFICATION_DE_LA_PERTE);

			Map<String, String> axMap = new HashMap<>();

			for (int i = 0; i < axJsonArray.size(); i++) {
				String value = (String) axJsonArray.get(i);

				axMap.put(value, value);
			}

			dropdowns.put(Constants.CLASSIFICATION_DE_LA_PERTE, axMap);
			
			// AY
			JSONArray ayJsonArray = (JSONArray) jsonObject.get(Constants.NOTATION_DE_LA_PERTE_EN_REPUTATION);

			Map<String, String> ayMap = new HashMap<>();

			for (int i = 0; i < ayJsonArray.size(); i++) {
				String value = (String) ayJsonArray.get(i);

				ayMap.put(value, value);
			}

			dropdowns.put(Constants.NOTATION_DE_LA_PERTE_EN_REPUTATION, ayMap);
			
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dropdowns;
		
	}
	
	public static Map<String, Map<String, Map<String, Map<String, String>>>> parseRecursiveDropDowns(InputStream in) {
		
		JSONParser parser = new JSONParser();
		
		Map<String, Map<String, Map<String, Map<String, String>>>> specialDropdown = new HashMap<>();
		
		try {
			Object object = parser.parse(new InputStreamReader(in, "UTF-8"));

			// convert Object to JSONObject
			JSONObject jsonObject = (JSONObject) object;
			
			Map<String, Map<String, Map<String, String>>> secondLevelMap = new HashMap<>();
			Map<String, Map<String, String>> thirdLevelMap = new HashMap<>();
			Map<String, String> fourthLevelList = new HashMap<>();

			JSONArray anJsonArray = (JSONArray) jsonObject.get(Constants.COMITE_DE_BALE);
			for (int j = 0; j < anJsonArray.size(); j++) {
				JSONObject jsonobject = (JSONObject) anJsonArray.get(j);
				Set<String> firstLevelKeys = jsonobject.keySet();

				for (Iterator<String> it = firstLevelKeys.iterator(); it.hasNext();) {
					String firstLevelKey = it.next();

					JSONArray secondLevelkeys = (JSONArray) jsonobject.get(firstLevelKey);

					secondLevelMap = new HashMap<>();
					
					for (int k = 0; k < secondLevelkeys.size(); k++) {

						JSONObject secondLevelJsonobject = (JSONObject) secondLevelkeys.get(k);
						Set<String> thirdLevelKeys = secondLevelJsonobject.keySet();
						
						for (Iterator<String> it1 = thirdLevelKeys.iterator(); it1.hasNext();) {
							String secondLevelKey = it1.next();

							JSONArray thirdLevelJsonArray = (JSONArray) secondLevelJsonobject.get(secondLevelKey);

							thirdLevelMap = new HashMap<>();
							
							for (int l = 0; l < thirdLevelJsonArray.size(); l++) {

								JSONObject thirdLevelJsonobject = (JSONObject) thirdLevelJsonArray.get(l);
								Set<String> fourthLevelKeys = thirdLevelJsonobject.keySet();
								
								for (Iterator<String> it2 = fourthLevelKeys.iterator(); it2.hasNext();) {
									String thirdLevelKey = it2.next();

									JSONArray fourthLevelJsonArray = (JSONArray) thirdLevelJsonobject.get(thirdLevelKey);

									fourthLevelList = new HashMap<>();
									
									for (int m = 0; m < fourthLevelJsonArray.size(); m++) {
										String value = (String) fourthLevelJsonArray.get(m);

										fourthLevelList.put(value, value);
									}
									
									thirdLevelMap.put(thirdLevelKey, fourthLevelList);

								}
							}
							
							secondLevelMap.put(secondLevelKey, thirdLevelMap);
						}
					}
					
					specialDropdown.put(firstLevelKey, secondLevelMap);
				}
			}
			
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return specialDropdown;
	}
	
}
