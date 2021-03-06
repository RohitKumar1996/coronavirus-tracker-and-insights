package com.rk.covidproject.coronavirustracker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class coronaVirusTrackerController {

	@Autowired
	coronaVirusDataService covidDataService;

	@RequestMapping("/global")
	Map<String, Object> fetchGlobalData() throws InterruptedException, IOException {
		return covidDataService.fetchVirusData();
	}

	@RequestMapping(value = "/countries/{countryName}", method = RequestMethod.GET)
	Pair<Object, ArrayList<Object>> fetchCountryData(@PathVariable("countryName") String countryName)
			throws InterruptedException, IOException, ClassNotFoundException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException, SecurityException, ParseException {
		return covidDataService.fetchVirusDataByCountry(countryName);
	}

}
