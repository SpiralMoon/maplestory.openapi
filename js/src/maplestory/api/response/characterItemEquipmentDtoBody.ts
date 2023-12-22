type CharacterItemEquipmentDtoBody = {
    date: string;
    character_gender: string;
    character_class: string;
    item_equipment: CharacterItemEquipmentInfoDtoBody[];
    title: CharacterItemEquipmentTitleDtoBody;
    dragon_equipment?: CharacterItemEquipmentInfoDtoBody[];
    mechanic_equipment?: CharacterItemEquipmentInfoDtoBody[];
}

type CharacterItemEquipmentInfoDtoBody = {
    item_equipment_part: string;
    equipment_slot: string;
    item_name: string;
    item_icon: string;
    item_description: string;
    item_shape_name: string;
    item_shape_icon: string;
    gender: string;
    item_total_option: CharacterItemEquipmentOptionDtoBody;
    item_base_option: CharacterItemEquipmentBaseOptionDtoBody;
    potential_option_grade: string;
    additional_potential_option_grade: string;
    potential_option_1: string;
    potential_option_2: string;
    potential_option_3: string;
    additional_potential_option_1: string;
    additional_potential_option_2: string;
    additional_potential_option_3: string;
    equipment_level_increase: number;
    item_exceptional_option: CharacterItemEquipmentOptionDtoBody;
    item_add_option: CharacterItemEquipmentAddOptionDtoBody;
    growth_exp: number;
    growth_level: number;
    scroll_upgrade: string;
    cuttable_count: string;
    golden_hammer_flag: string;
    scroll_resilience_count: string;
    scroll_upgradeable_count: string;
    soul_name: string;
    soul_option: string;
    item_etc_option: CharacterItemEquipmentOptionDtoBody;
    starforce: string;
    starforce_scroll_flag: string;
    item_starforce_option: CharacterItemEquipmentOptionDtoBody;
    special_ring_level: number;
    date_expire: string;
};

type CharacterItemEquipmentOptionDtoBody = {
    str: string;
    dex: string;
    int: string;
    luk: string;
    max_hp: string;
    max_mp: string;
    attack_power: string;
    magic_power: string;
    armor: string;
    speed: string;
    jump: string;
    boss_damage: string;
    ignore_monster_armor: string;
    all_stat: string;
    damage: string;
    equipment_level_decrease: number;
    max_hp_rate: string;
    max_mp_rate: string;
}

type CharacterItemEquipmentExceptionalOptionDtoBody = {
    str: string;
    dex: string;
    int: string;
    luk: string;
    max_hp: string;
    max_mp: string;
    attack_power: string;
    magic_power: string;
};

type CharacterItemEquipmentTotalOptionDtoBody = {
    str: string;
    dex: string;
    int: string;
    luk: string;
    max_hp: string;
    max_mp: string;
    attack_power: string;
    magic_power: string;
    armor: string;
    speed: string;
    jump: string;
    boss_damage: string;
    ignore_monster_armor: string;
    all_stat: string;
    damage: string;
    equipment_level_decrease: number;
    max_hp_rate: string;
    max_mp_rate: string;
}

type CharacterItemEquipmentBaseOptionDtoBody = {
    str: string;
    dex: string;
    int: string;
    luk: string;
    max_hp: string;
    max_mp: string;
    attack_power: string;
    magic_power: string;
    armor: string;
    speed: string;
    jump: string;
    boss_damage: string;
    ignore_monster_armor: string;
    all_stat: string;
    max_hp_rate: string;
    max_mp_rate: string;
    base_equipment_level: number;
}

type CharacterItemEquipmentAddOptionDtoBody = {
    str: string;
    dex: string;
    int: string;
    luk: string;
    max_hp: string;
    max_mp: string;
    attack_power: string;
    magic_power: string;
    armor: string;
    speed: string;
    jump: string;
    boss_damage: string;
    damage: string;
    all_stat: string;
    equipment_level_decrease: number;
}

type CharacterItemEquipmentEtcOptionDtoBody = {
    str: string;
    dex: string;
    int: string;
    luk: string;
    max_hp: string;
    max_mp: string;
    attack_power: string;
    magic_power: string;
    armor: string;
    speed: string;
    jump: string;
}

type CharacterItemEquipmentStarforceOptionDtoBody = CharacterItemEquipmentEtcOptionDtoBody;

type CharacterItemEquipmentTitleDtoBody = {
    title_name: string;
    title_icon: string;
    title_description: string;
    date_expire: string;
    date_option_expire: string | null;
};

export type {
    CharacterItemEquipmentDtoBody,
    CharacterItemEquipmentInfoDtoBody,
    CharacterItemEquipmentTitleDtoBody,
    CharacterItemEquipmentOptionDtoBody,
    CharacterItemEquipmentExceptionalOptionDtoBody,
    CharacterItemEquipmentTotalOptionDtoBody,
    CharacterItemEquipmentBaseOptionDtoBody,
    CharacterItemEquipmentAddOptionDtoBody,
    CharacterItemEquipmentEtcOptionDtoBody,
    CharacterItemEquipmentStarforceOptionDtoBody
};
