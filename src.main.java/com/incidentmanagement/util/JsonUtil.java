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
	
	public static Map<String, List<String>> parseSimpleDropDowns(InputStream in) {
		
		JSONParser parser = new JSONParser();

		Map<String, List<String>> dropdowns = new HashMap<>();

		try {
			Object object = parser.parse(new InputStreamReader(in, "UTF-8"));

			// convert Object to JSONObject
			JSONObject jsonObject = (JSONObject) object;

			// AK
			JSONArray akJsonArray = (JSONArray) jsonObject.get(Constants.DECISION_ADMISSION_REJECT);

			List<String> akList = new ArrayList<>();

			for (int i = 0; i < akJsonArray.size(); i++) {
				String value = (String) akJsonArray.get(i);

				akList.add(value);
			}

			dropdowns.put(Constants.DECISION_ADMISSION_REJECT, akList);

			// AL
			JSONArray alJsonArray = (JSONArray) jsonObject.get(Constants.STATUS_DE_INCIDENT);

			List<String> alList = new ArrayList<>();

			for (int i = 0; i < alJsonArray.size(); i++) {
				String value = (String) alJsonArray.get(i);

				alList.add(value);
			}

			dropdowns.put(Constants.STATUS_DE_INCIDENT, alList);

			// AM
			JSONArray amJsonArray = (JSONArray) jsonObject.get(Constants.TYPE_DE_REFERENCE_EXTERNE);

			List<String> amList = new ArrayList<>();

			for (int i = 0; i < amJsonArray.size(); i++) {
				String value = (String) amJsonArray.get(i);

				amList.add(value);
			}

			dropdowns.put(Constants.TYPE_DE_REFERENCE_EXTERNE, amList);

			// AV
			JSONArray avJsonArray = (JSONArray) jsonObject.get(Constants.CODE_ETAT_ACTUAEL_DU_PERT_SUR);

			List<String> avList = new ArrayList<>();

			for (int i = 0; i < avJsonArray.size(); i++) {
				String value = (String) avJsonArray.get(i);

				avList.add(value);
			}

			dropdowns.put(Constants.CODE_ETAT_ACTUAEL_DU_PERT_SUR, avList);

			// AW
			JSONArray awJsonArray = (JSONArray) jsonObject.get(Constants.ETATE_DE_LA_PERTE);

			List<String> awList = new ArrayList<>();

			for (int i = 0; i < awJsonArray.size(); i++) {
				String value = (String) awJsonArray.get(i);

				awList.add(value);
			}

			dropdowns.put(Constants.ETATE_DE_LA_PERTE, awList);

			// AX
			JSONArray axJsonArray = (JSONArray) jsonObject.get(Constants.CLASSIFICATION_DE_LA_PERTE);

			List<String> axList = new ArrayList<>();

			for (int i = 0; i < axJsonArray.size(); i++) {
				String value = (String) axJsonArray.get(i);

				axList.add(value);
			}

			dropdowns.put(Constants.CLASSIFICATION_DE_LA_PERTE, axList);

		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dropdowns;
		
	}
	
	public static Map<String, Map<String, Map<String, List<String>>>> parseRecursiveDropDowns(InputStream in) {
		
		JSONParser parser = new JSONParser();
		
		Map<String, Map<String, Map<String, List<String>>>> specialDropdown = new HashMap<>();
		
		try {
			Object object = parser.parse(new InputStreamReader(in, "UTF-8"));

			// convert Object to JSONObject
			JSONObject jsonObject = (JSONObject) object;
			
			Map<String, Map<String, List<String>>> secondLevelMap = new HashMap<>();
			Map<String, List<String>> thirdLevelMap = new HashMap<>();
			List<String> fourthLevelList = new ArrayList<>();

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

									fourthLevelList = new ArrayList<>();
									
									for (int m = 0; m < fourthLevelJsonArray.size(); m++) {
										String value = (String) fourthLevelJsonArray.get(m);

										fourthLevelList.add(value);
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
