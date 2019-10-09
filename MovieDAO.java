package com.verdin.jsf.ejb;

import com.verdin.jsf.model.Movie;
import org.jboss.logging.Logger;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


@Named("movieService")
@ApplicationScoped
public class MovieDAO {
	
	static Logger logger = Logger.getLogger(MovieDAO.class);
	
	public List<Movie> getMovie() throws Exception {

		logger.info("get in DAO ...");
		

	    List<Movie> _movies =  new ArrayList<Movie>();

		try {

			String url = "https://api.themoviedb.org/3/discover/movie?api_key=0d231ca439c48aeb0525fa568fcb824a";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			int responseCode = con.getResponseCode();
			logger.info("Get response code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			} in .close();

			JSONObject objMovie = new JSONObject(response.toString());
			JSONArray arr = objMovie.getJSONArray("results");
			for (int i = 0; i < arr.length(); i++) {
				Movie m = new Movie();
				m.setTitle(arr.getJSONObject(i).getString("title"));
				m.setRelease(arr.getJSONObject(i).getString("release_date"));
				m.setPoster("https://image.tmdb.org/t/p/w500" + arr.getJSONObject(i).getString("poster_path"));

				_movies.add(m);
			}

			logger.info("get in DAO ... "+ _movies.size());
			
		}  catch (Exception e) {
			
			e.printStackTrace();

		}


		return _movies;

	}


}
