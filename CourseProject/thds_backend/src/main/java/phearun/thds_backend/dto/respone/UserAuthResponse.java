package phearun.thds_backend.dto.respone;

public record UserAuthResponse(
        String jwtToken,
        String firstName,
        String lastName
) {
}
