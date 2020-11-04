import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();

        HttpGet request = new HttpGet("https://cat-fact.herokuapp.com/facts");

        CloseableHttpResponse response = httpClient.execute(request);
        String json = mapper.readTree(response.getEntity().getContent()).get("all").toString();
        List<Facts> cats = mapper.readValue(json, new TypeReference<>() {
        });
        List<Facts> fact = cats.stream()
                .filter(v -> v.getUpvotes() > 0)
                .collect(Collectors.toList());
        fact.forEach(System.out::println);
    }

}
