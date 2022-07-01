package com.SrBerserk.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.SrBerserk.Models.LocationStats;
import com.SrBerserk.Service.CoronaVirusDataService;

@Controller
public class HomeController {
	
	@Autowired
	CoronaVirusDataService DataService;
	
	@GetMapping("/")
	public String home(Model model) {
		List<LocationStats> allStats =  DataService.getAllStats();
		int totalCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
		int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();

		model.addAttribute("locationStats", allStats);
		model.addAttribute("totalReportedCases", totalCases);
		model.addAttribute("totalNewCases", totalNewCases);
		return "home";
	} 
}
