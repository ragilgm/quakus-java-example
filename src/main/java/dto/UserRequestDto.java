package dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import io.smallrye.common.constraint.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import validator.constraint.NameAreadyExist;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRequestDto {

    @NotNull
    @NameAreadyExist
    private String name;

}
