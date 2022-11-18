package HW13;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ApiTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        String url = "https://jsonplaceholder.typicode.com/users";
        String urlId = "https://jsonplaceholder.typicode.com/users/8";
        String urlUserName = "https://jsonplaceholder.typicode.com/users?username=Bret";

        User user = new User();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String userInfo = gson.toJson(user);

        //Task 1.1
        HttpRequest request1 = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.ofString(userInfo))
                .build();

        //Task 1.2
        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(URI.create(urlId))
                .method("PATCH", HttpRequest.BodyPublishers.ofString(userInfo))
                .build();

        //Task 1.3
        HttpRequest request3 = HttpRequest.newBuilder()
                .uri(URI.create(urlId))
                .DELETE()
                .build();

        //Task 1.4
        HttpRequest request4 = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        //Task 1.5
        HttpRequest request5 = HttpRequest.newBuilder()
                .uri(URI.create(urlId))
                .GET()
                .build();

        //Task 1.6
        HttpRequest request6 = HttpRequest.newBuilder()
                .uri(URI.create(urlUserName))
                .GET()
                .build();

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpResponse<String> response1 = client.send(request1, HttpResponse.BodyHandlers.ofString());
        HttpResponse<String> response2 = client.send(request2, HttpResponse.BodyHandlers.ofString());
        HttpResponse<String> response3 = client.send(request3, HttpResponse.BodyHandlers.ofString());
        HttpResponse<String> response4 = client.send(request4, HttpResponse.BodyHandlers.ofString());
        HttpResponse<String> response5 = client.send(request5, HttpResponse.BodyHandlers.ofString());
        HttpResponse<String> response6 = client.send(request6, HttpResponse.BodyHandlers.ofString());

        //Task 1.1 output
        System.out.println("\nTask 1.1");
        System.out.println(response1.statusCode());
        System.out.println(response1.body());

        //Task 1.2 output
        System.out.println("\nTask 1.2");
        System.out.println(response2.statusCode());
        System.out.println(response2.body());

        //Task 1.3 output
        System.out.println("\nTask 1.3");
        System.out.println(response3.statusCode());
        System.out.println(response3.body());

        //Task 1.4 output
        System.out.println("\nTask 1.4");
        System.out.println(response4.statusCode());
        System.out.println(response4.body());

        //Task 1.5 output
        System.out.println("\nTask 1.5");
        System.out.println(response5.statusCode());
        System.out.println(response5.body());

        //Task 1.6 output
        System.out.println("\nTask 1.6");
        System.out.println(response6.statusCode());
        System.out.println(response6.body());

        getComments("2");

        allUncompletedTasks(1);
    }

    public static void getComments(String id) throws IOException {
        String urlPost = String.format("https://jsonplaceholder.typicode.com/users/%s/posts", id);

        String response = Jsoup.connect(urlPost)
                .ignoreContentType(true)
                .get()
                .body()
                .text();

        Type type = TypeToken
                .getParameterized(List.class, Post.class)
                .getType();

        List<Post> posts = new Gson().fromJson(response, type);
        Integer postId = posts.stream()
                .map(el -> el.getId())
                .mapToInt(el -> el)
                .max().orElseThrow(NoSuchElementException::new);

        String urlComments = String.format("https://jsonplaceholder.typicode.com/posts/%d/comments", postId);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String responseComments = Jsoup.connect(urlComments)
                .ignoreContentType(true)
                .get()
                .body()
                .text();

        Type typeComments = TypeToken
                .getParameterized(List.class, Comments.class)
                .getType();

        String fileAddress = String.format("HW13-materials/user-%s-post-%d-comments.json", id, postId);
        FileOutputStream fos = new FileOutputStream(fileAddress);

        List<Comments> comments = gson.fromJson(responseComments, typeComments);

        String str = gson.toJson(comments);
        fos.write(str.getBytes());

        fos.flush();
        fos.close();
    }

    public static void allUncompletedTasks(Integer id) throws IOException {
        String urlTodos = String.format("https://jsonplaceholder.typicode.com/users/%d/todos", id);

        String response = Jsoup.connect(urlTodos)
                .ignoreContentType(true)
                .get()
                .body()
                .text();

        Type type = TypeToken
                .getParameterized(List.class, Todos.class)
                .getType();

        List<Todos> todos = new Gson().fromJson(response, type);
        List<String> isCompleted = todos.stream()
                .filter((el) -> el.isCompleted() == false)
                .map((el) -> el.getTitle())
                .collect(Collectors.toList());

        System.out.println(isCompleted);
    }
}
