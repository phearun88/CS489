/**
 * Author : PhearunPhin
 * Date : 4/4/2024
 */

package phearun.thds_backend.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class ApiException extends RuntimeException {

    private HttpStatus status;
    private String message;
}