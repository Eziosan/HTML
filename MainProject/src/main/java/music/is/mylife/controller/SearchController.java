package music.is.mylife.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import music.is.mylife.service.SearchService;
import music.is.mylife.vo.Song;

@RequestMapping("search")
@Controller
public class SearchController {
	
	@Autowired
	SearchService sServ;

	@RequestMapping(value="search", method=RequestMethod.GET)
	public String search(String searchText, Model model) {
		ArrayList<Song> searchResult1 = sServ.searchSongsBySongName(searchText);
		ArrayList<Song> searchResult2 = sServ.searchSongsBySingerName(searchText);
		
		model.addAttribute("searchText", searchText);
		model.addAttribute("searchResult1", searchResult1);
		model.addAttribute("searchResult2", searchResult2);
		
		for(Song s : searchResult1) {
			System.out.println(s);
		}
		
		for(Song s : searchResult2) {
			System.out.println(s);
		}
		
		
		
		return "search/test";
	}
	@RequestMapping(value="test", method=RequestMethod.GET)
	public String search() {
		
		
		return "search/test";
	}
}
