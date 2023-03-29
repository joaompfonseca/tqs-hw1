package tqs.hw1.envmonitor.data.env;

import lombok.Data;

@Data
public class EnvItemDTO {
    private Long dt;
    private EnvComponentsDTO components;
}
