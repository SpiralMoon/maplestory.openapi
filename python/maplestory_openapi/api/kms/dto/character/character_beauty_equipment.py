from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_beauty_equipment import CharacterBeautyEquipmentHair as BaseCharacterBeautyEquipmentHair
from maplestory_openapi.api.common.dto.character.character_beauty_equipment import CharacterBeautyEquipmentFace as BaseCharacterBeautyEquipmentFace
from maplestory_openapi.api.common.dto.character.character_beauty_equipment import CharacterBeautyEquipmentSkin as BaseCharacterBeautyEquipmentSkin
from maplestory_openapi.api.common.dto.character.character_beauty_equipment import CharacterBeautyEquipment as BaseCharacterBeautyEquipment


class CharacterBeautyEquipmentHair(BaseModel, BaseCharacterBeautyEquipmentHair):
    """
    캐릭터 헤어 정보

    Attributes:
        hair_name (str): 헤어 명
        base_color (str): 헤어 베이스 컬러
        mix_color (str or None): 헤어 믹스 컬러
        mix_rate (str): 헤어 믹스 컬러의 염색 비율
        freestyle_flag (str or None): 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
    """
    hair_name: str
    base_color: str
    mix_color: str | None
    mix_rate: str
    freestyle_flag: str | None

    @property
    def is_freestyle_flag(self) -> bool:
        """
        프리스타일 쿠폰 적용 여부
        """
        return self.freestyle_flag == '1'


class CharacterBeautyEquipmentFace(BaseModel, BaseCharacterBeautyEquipmentFace):
    """
    캐릭터 성형 정보

    Attributes:
        face_name (str): 성형 명
        base_color (str): 성형 베이스 컬러
        mix_color (str or None): 성형 믹스 컬러
        mix_rate (str): 성형 믹스 컬러의 염색 비율
        freestyle_flag (str or None): 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
    """
    face_name: str
    base_color: str
    mix_color: str | None
    mix_rate: str
    freestyle_flag: str | None

    @property
    def is_freestyle_flag(self) -> bool:
        """
        프리스타일 쿠폰 적용 여부
        """
        return self.freestyle_flag == '1'


class CharacterBeautyEquipmentSkin(BaseModel, BaseCharacterBeautyEquipmentSkin):
    """
    캐릭터 피부 정보

    Attributes:
        skin_name (str): 피부 명
        color_style (str or None): 색상 계열
        hue (int or None): 피부 색조
        saturation (int or None): 피부 채도
        brightness (int or None): 피부 명도
    """
    skin_name: str
    color_style: str | None
    hue: int | None
    saturation: int | None
    brightness: int | None


class CharacterBeautyEquipment(BaseModel, BaseCharacterBeautyEquipment):
    """
    캐릭터 헤어, 성형, 피부 정보

    Attributes:
        date (datetime or None): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        character_gender (str or None): 캐릭터 성별
        character_class (str or None): 캐릭터 직업
        character_hair (CharacterBeautyEquipmentHair or None): 캐릭터 헤어 정보 (제로: 알파, 엔젤릭버스터: 일반 모드)
        character_face (CharacterBeautyEquipmentFace or None): 캐릭터 성형 정보 (제로: 알파, 엔젤릭버스터: 일반 모드)
        character_skin (CharacterBeautyEquipmentSkin or None): 캐릭터 피부 정보 (제로: 알파, 엔젤릭버스터: 일반 모드)
        additional_character_hair (CharacterBeautyEquipmentHair or None): 제로: 베타, 엔젤릭버스터: 드레스 업 모드 헤어 정보
        additional_character_face (CharacterBeautyEquipmentFace or None): 제로: 베타, 엔젤릭버스터: 드레스 업 모드 성형 정보
        additional_character_skin (CharacterBeautyEquipmentSkin or None): 제로: 베타, 엔젤릭버스터: 드레스 업 모드 피부 정보
    """
    date: datetime | None
    character_gender: str | None
    character_class: str | None
    character_hair: CharacterBeautyEquipmentHair | None
    character_face: CharacterBeautyEquipmentFace | None
    character_skin: CharacterBeautyEquipmentSkin | None
    additional_character_hair: CharacterBeautyEquipmentHair | None
    additional_character_face: CharacterBeautyEquipmentFace | None
    additional_character_skin: CharacterBeautyEquipmentSkin | None
