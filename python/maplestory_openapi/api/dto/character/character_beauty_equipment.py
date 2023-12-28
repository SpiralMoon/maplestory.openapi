from datetime import datetime
from pydantic import BaseModel


class CharacterBeautyEquipmentHair(BaseModel):
    """캐릭터 헤어 정보

    hair_name(str): 헤어 명
    base_color(str): 헤어 베이스 컬러
    mix_color(str): 헤어 믹스 컬러
    mix_rate(str): 헤어 믹스 컬러의 염색 비율
    """
    hair_name: str
    base_color: str
    mix_color: str | None
    mix_rate: str


class CharacterBeautyEquipmentFace(BaseModel):
    """캐릭터 성형 정보

    face_name(str): 성형 명
    base_color(str): 성형 베이스 컬러
    mix_color(str): 성형 믹스 컬러
    mix_rate(str): 성형 믹스 컬러의 염색 비율
    """
    face_name: str
    base_color: str
    mix_color: str | None
    mix_rate: str


class CharacterBeautyEquipment(BaseModel):
    """캐릭터 헤어, 성형, 피부 정보

    date(datetime): 조회 기준일 (KST)
    character_gender: 캐릭터 성별
    character_class: 캐릭터 직업
    character_hair: 캐릭터 헤어 정보 (제로인 경우 알파, 엔젤릭버스터인 경우 일반 모드)
    character_face: 캐릭터 성형 정보 (제로인 경우 알파, 엔젤릭버스터인 경우 일반 모드)
    character_skin_name: 캐릭터 피부 명 (제로인 경우 알파, 엔젤릭버스터인 경우 일반 모드)
    additional_character_hair: 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드에 적용 중인 헤어 정보
    additional_character_face: 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드에 적용 중인 성형 정보
    additional_character_skin_name: 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드에 적용 중인 피부 명
    """
    date: datetime
    character_gender: str
    character_class: str
    character_hair: CharacterBeautyEquipmentHair
    character_face: CharacterBeautyEquipmentFace
    character_skin_name: str
    additional_character_hair: CharacterBeautyEquipmentHair | None
    additional_character_face: CharacterBeautyEquipmentFace | None
    additional_character_skin_name: str | None
