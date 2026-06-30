import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class GithubActivityCLI {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java GithubActivityCLI <username>");
            return;
        }

        String GITHUB_API_URL = "https://api.github.com/users/" + args[0] + "/events";

        HttpClient client = HttpClient.newHttpClient();

        try {
            HttpRequest request = HttpRequest.newBuilder().uri(new URI(GITHUB_API_URL)).header("Accept", "application/vnd.github+json").GET().build();
        } catch (URISyntaxException uriSyntaxException) {
            uriSyntaxException.printStackTrace();
        }
    }
}
