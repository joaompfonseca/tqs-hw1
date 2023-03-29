package tqs.hw1.envmonitor.data.env;

import lombok.Data;

import java.util.List;

@Data
public class EnvDTO {
    private String location;
    private String country;
    private List<EnvItemDTO> items;
}
