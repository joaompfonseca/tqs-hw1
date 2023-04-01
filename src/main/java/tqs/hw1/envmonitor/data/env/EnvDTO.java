package tqs.hw1.envmonitor.data.env;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvDTO {
    private String location;
    private String country;
    private List<EnvItemDTO> items;
}
