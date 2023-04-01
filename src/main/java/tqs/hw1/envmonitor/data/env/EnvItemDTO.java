package tqs.hw1.envmonitor.data.env;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvItemDTO {
    private Long dt;
    private EnvComponentsDTO components;
}
