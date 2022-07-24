package authentication.provider;

import org.testng.annotations.DataProvider;

public class AuthDataProvider {
    @DataProvider(name="auth test negative")
    public Object[][] authTest() {
        return new Object[][] {
                {"",""},
                {"asdokapsdpo", "asdqwioje"},
                {"","123"},
                {"<script> alert ('test') </script>", "123"},
                {"alert ('test')", "123"},
                {"drop table if exists \"user\", \"users\"", "123"}
        };
    }
}
