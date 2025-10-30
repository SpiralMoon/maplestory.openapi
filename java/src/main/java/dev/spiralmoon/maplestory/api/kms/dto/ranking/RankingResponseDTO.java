package dev.spiralmoon.maplestory.api.kms.dto.ranking;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RankingResponseDTO<Ranking> {

    @JsonSetter(nulls = Nulls.AS_EMPTY)
    protected List<Ranking> ranking;
}
