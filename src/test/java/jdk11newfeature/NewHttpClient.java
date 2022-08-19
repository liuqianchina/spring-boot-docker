package jdk11newfeature;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class NewHttpClient {

    public static void main(String[] args) throws Exception {
        var request = HttpRequest.newBuilder()
                .uri(URI.create("http://www.baidu.com"))
                .GET()
                .build();
        var client = HttpClient.newHttpClient();

        var response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println);
    }
}
