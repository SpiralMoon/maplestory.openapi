package dev.spiralmoon.maplestory.api.dto;

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

    protected List<Ranking> ranking;
}
