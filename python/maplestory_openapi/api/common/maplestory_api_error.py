from pydantic import BaseModel


class MapleStoryApiError(BaseModel):
    name: str
    message: str


class MapleStoryApiException(Exception):
    """
    MapleStory API Exception

    https://openapi.nexon.com/guide/request-api/#error-code-table
    """

    def __init__(self, error: MapleStoryApiError) -> None:
        self.error_code = error.name
        self.message = error.message
        super().__init__(error.message)
