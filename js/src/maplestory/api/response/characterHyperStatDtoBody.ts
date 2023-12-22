type CharacterHyperStatDtoBody = {
	date: string;
	character_class: string;
	use_preset_no: string;
	use_available_hyper_stat: number;
	hyper_stat_preset_1: CharacterHyperStatInfoDtoBody[];
	hyper_stat_preset_1_remain_point: number;
	hyper_stat_preset_2: CharacterHyperStatInfoDtoBody[];
	hyper_stat_preset_2_remain_point: number;
	hyper_stat_preset_3: CharacterHyperStatInfoDtoBody[];
	hyper_stat_preset_3_remain_point: number;
};

type CharacterHyperStatInfoDtoBody = {
	stat_type: string;
	stat_point: number;
	stat_level: number;
	stat_increase: string;
};

export type {CharacterHyperStatDtoBody, CharacterHyperStatInfoDtoBody};
