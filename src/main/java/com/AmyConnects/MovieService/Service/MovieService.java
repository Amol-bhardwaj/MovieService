package com.AmyConnects.MovieService.Service;

import com.AmyConnects.MovieService.Entity.User;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final RestTemplate restTemplate;
    private final UserService userService;
    private final SearchHistoryRepository historyRepository;

    @Value("${omdb.api.key}")
    private String apiKey;

    public String searchMovie(String movieName, String token) {

        User user = userService.validateToken(token);

        String url = "http://www.omdbapi.com/?apikey=" + apiKey + "&t=" + movieName;

        String response = restTemplate.getForObject(url, String.class);

        SearchHistory history = SearchHistory.builder()
                .movieName(movieName)
                .searchedAt(LocalDateTime.now())
                .user(user)
                .build();

        historyRepository.save(history);

        return response;
    }
}
