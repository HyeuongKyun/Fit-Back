package com.ssafy.board.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.ssafy.board.model.dto.Video;

public class Json_to_List {
	private static JSONArray total;
	private static List<Video> video = new ArrayList<>();

	public static JSONArray getList() {
		try {

			Object obj = new JSONParser().parse(new FileReader("video.json"));
			JSONArray jsonArr = (JSONArray) obj;

			if (jsonArr.size() > 0) {
				for (int i = 0; i < jsonArr.size(); i++) {
					JSONObject jsonObj = (JSONObject) jsonArr.get(i);
				}
				total = jsonArr;
			}

		} catch (FileNotFoundException a) {
			a.printStackTrace();

		} catch (IOException b) {
			b.printStackTrace();

		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
		return total;
	}

	public static List<Video> selectVideo(JSONArray jsonArr) {
		if (jsonArr.size() > 0) {
			for (int i = 0; i < jsonArr.size(); i++) {
				Video temp = new Video();
				JSONObject jsonObj = (JSONObject) jsonArr.get(i);
				temp.setVideoId((String.valueOf(jsonObj.get("id"))));
				temp.setTitle((String) jsonObj.get("title"));
				temp.setPart(((String) jsonObj.get("part")));
				temp.setUrl((((String) jsonObj.get("url"))));
				video.add(temp);
			}
		}
		return video;
	}
}
