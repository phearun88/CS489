package phearun.thds_backend.dto.request;

public record UserAuthRequest(
        String username,
        String password
) {
}
