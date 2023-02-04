package testhelpers.testfactories;

import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import org.inject.api.models.requests.CredentialsPojo;
import org.inject.api.models.requests.UserPojo;
import org.testng.annotations.Factory;
import tests.UserTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.List;

public class TestFactories {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final File directory = FileSystems.getDefault().getPath("src/main/resources/testdata").toAbsolutePath().toFile();

    @Factory
    public Object[] userTestFactory() throws IOException {
        List<String> roles = List.of("admin", "seller", "customer");
        Object[] result = new Object[roles.size()];
        for (String role :
                roles) {
            File json = new File(directory, "users/" + role + ".json");
            UserPojo userPojo = objectMapper.readValue(json, UserPojo.class);
            result[roles.indexOf(role)] = new UserTest(userPojo,
                    new CredentialsPojo(userPojo.getUsername(), userPojo.getPassword()));
        }
        return result;
    }
}
