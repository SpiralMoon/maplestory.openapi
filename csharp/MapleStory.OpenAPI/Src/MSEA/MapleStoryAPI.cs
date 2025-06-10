using MapleStory.OpenAPI.Common.Param;
using MapleStory.OpenAPI.MSEA.DTO;
using Base = MapleStory.OpenAPI.Common;

namespace MapleStory.OpenAPI.MSEA
{
    /// <summary>
    /// MapleStory OpenAPI client for MSEA.
    /// <para>This is an implementation of <a href="https://openapi.nexon.com/game/maplestorysea">MapleStory API</a></para>
    /// </summary>
    public class MapleStoryAPI : MapleStoryAPIInherit
    {
        public MapleStoryAPI(string apiKey): base(apiKey, "maplestorysea", 480)
        {
            
        }

        #region Character Information Retrieval

        /// <summary>
        /// Retrieves the character identifier (ocid).
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="characterName">Character name</param>
        public override async Task<CharacterDTO> GetCharacter(string characterName)
        {
            var path = $"{subUrl}/v1/id";
            var query = new Dictionary<string, string?>()
            {
                { "character_name", characterName }
            };

            return await Get<CharacterDTO>(path, query);
        }

        /// <summary>
        /// Retrieves basic character information.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        public override Task<CharacterBasicDTO> GetCharacterBasic(string ocid)
        {
            return GetCharacterBasic(ocid, null);
        }

        /// <summary>
        /// Retrieves basic character information.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        /// <param name="dateTimeOffset">Reference date for query (SGT)</param>
        public override async Task<CharacterBasicDTO> GetCharacterBasic(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/basic";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 4, 20))
                : null;

            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterBasicDTO>(path, query);
        }

        /// <summary>
        /// Retrieves character image information.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        public override Task<CharacterImageDTO> GetCharacterImage(string ocid)
        {
            return GetCharacterImage(ocid, new CharacterImageOption(), null);
        }

        /// <summary>
        /// Retrieves character image information.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        /// <param name="imageOption">Image options</param>
        public override Task<CharacterImageDTO> GetCharacterImage(string ocid, CharacterImageOption imageOption)
        {
            return GetCharacterImage(ocid, imageOption, null);
        }

        /// <summary>
        /// Retrieves character image information.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        /// <param name="imageOption">Image options</param>
        /// <param name="dateTimeOffset">Reference date for query (SGT)</param>
        public override async Task<CharacterImageDTO> GetCharacterImage(string ocid, CharacterImageOption imageOption, DateTimeOffset? dateTimeOffset)
        {
            var basic = await GetCharacterBasic(ocid, dateTimeOffset);

            var action = imageOption.Action;
            var emotion = imageOption.Emotion;
            var wmotion = imageOption.Wmotion;
            var actionFrame = imageOption.ActionFrame;
            var emotionFrame = imageOption.EmotionFrame;
            var width = imageOption.Width;
            var height = imageOption.Height;
            var x = imageOption.X;
            var y = imageOption.Y;

            var path = basic.CharacterImage.Replace(BASE_URL, "");
            var query = new Dictionary<string, string?>()
            {
                { "action", $"{action.GetValue()}.{actionFrame}" },
                { "emotion", $"{emotion.GetValue()}.{emotionFrame}" },
                { "wmotion", wmotion.GetValue() },
                { "width", width.ToString() },
                { "height", height.ToString() },
                { "x", x?.ToString() },
                { "y", y?.ToString() },
            };

            var tasks = await Task.WhenAll(new List<Task<string>>()
            {
                urlImageToBase64(path, null),
                urlImageToBase64(path, query),
            });
            var (originImage, image) = (tasks[0], tasks[1]);

            return new CharacterImageDTO
            {
                Date = basic.Date,
                OriginUrl = basic.CharacterImage,
                OriginImage = originImage,
                Image = image,
                Action = action,
                Emotion = emotion,
                Wmotion = wmotion,
                ActionFrame = actionFrame,
                EmotionFrame = emotionFrame,
                Width = width,
                Height = height,
                X = x,
                Y = y,
            };
        }

        /// <summary>
        /// Retrieves popularity information of a character.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        public override Task<CharacterPopularityDTO> GetCharacterPopularity(string ocid)
        {
            return GetCharacterPopularity(ocid, null);
        }

        /// <summary>
        /// Retrieves popularity information of a character.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        /// <param name="dateTimeOffset">Reference date for query (SGT)</param>
        public override async Task<CharacterPopularityDTO> GetCharacterPopularity(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/popularity";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 4, 20))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterPopularityDTO>(path, query);
        }

        /// <summary>
        /// Retrieves comprehensive character stats information.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        public override Task<CharacterStatDTO> GetCharacterStat(string ocid)
        {
            return GetCharacterStat(ocid, null);
        }

        /// <summary>
        /// Retrieves comprehensive character stats information.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        /// <param name="dateTimeOffset">Reference date for query (SGT)</param>
        public override async Task<CharacterStatDTO> GetCharacterStat(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/stat";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 4, 20))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterStatDTO>(path, query);
        }

        /// <summary>
        /// Retrieves Hyper Stat information.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        public override Task<CharacterHyperStatDTO> GetCharacterHyperStat(string ocid)
        {
            return GetCharacterHyperStat(ocid, null);
        }

        /// <summary>
        /// Retrieves Hyper Stat information.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        /// <param name="dateTimeOffset">Reference date for query (SGT)</param>
        public override async Task<CharacterHyperStatDTO> GetCharacterHyperStat(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/hyper-stat";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 4, 20))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterHyperStatDTO>(path, query);
        }

        /// <summary>
        /// Retrieves traits information.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        public override Task<CharacterPropensityDTO> GetCharacterPropensity(string ocid)
        {
            return GetCharacterPropensity(ocid, null);
        }

        /// <summary>
        /// Retrieves traits information.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        /// <param name="dateTimeOffset">Reference date for query (SGT)</param>
        public override async Task<CharacterPropensityDTO> GetCharacterPropensity(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/propensity";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 4, 20))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterPropensityDTO>(path, query);
        }

        /// <summary>
        /// Retrieves Ability information.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        public override Task<CharacterAbilityDTO> GetCharacterAbility(string ocid)
        {
            return GetCharacterAbility(ocid, null);
        }

        /// <summary>
        /// Retrieves Ability information.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        /// <param name="dateTimeOffset">Reference date for query (SGT)</param>
        public override async Task<CharacterAbilityDTO> GetCharacterAbility(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/ability";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 4, 20))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterAbilityDTO>(path, query);
        }

        /// <summary>
        /// Retrieves information about equipped equipment, excluding cash items.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        public override Task<CharacterItemEquipmentDTO> GetCharacterItemEquipment(string ocid)
        {
            return GetCharacterItemEquipment(ocid, null);
        }

        /// <summary>
        /// Retrieves information about equipped equipment, excluding cash items.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        /// <param name="dateTimeOffset">Reference date for query (SGT)</param>
        public override async Task<CharacterItemEquipmentDTO> GetCharacterItemEquipment(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/item-equipment";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 4, 20))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterItemEquipmentDTO>(path, query);
        }

        /// <summary>
        /// Retrieves equipped cash item information.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        public override Task<CharacterCashItemEquipmentDTO> GetCharacterCashItemEquipment(string ocid)
        {
            return GetCharacterCashItemEquipment(ocid, null);
        }

        /// <summary>
        /// Retrieves equipped cash item information.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        /// <param name="dateTimeOffset">Reference date for query (SGT)</param>
        public override async Task<CharacterCashItemEquipmentDTO> GetCharacterCashItemEquipment(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/cashitem-equipment";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 4, 20))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterCashItemEquipmentDTO>(path, query);
        }

        /// <summary>
        /// Retrieves information about equipped symbols.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        public override Task<CharacterSymbolEquipmentDTO> GetCharacterSymbolEquipment(string ocid)
        {
            return GetCharacterSymbolEquipment(ocid, null);
        }

        /// <summary>
        /// Retrieves information about equipped symbols.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        /// <param name="dateTimeOffset">Reference date for query (SGT)</param>
        public override async Task<CharacterSymbolEquipmentDTO> GetCharacterSymbolEquipment(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/symbol-equipment";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 4, 20))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterSymbolEquipmentDTO>(path, query);
        }

        /// <summary>
        /// Retrieves information about equipped set item effects.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        public override Task<CharacterSetEffectDTO> GetCharacterSetEffect(string ocid)
        {
            return GetCharacterSetEffect(ocid, null);
        }

        /// <summary>
        /// Retrieves information about equipped set item effects.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        /// <param name="dateTimeOffset">Reference date for query (SGT)</param>
        public override async Task<CharacterSetEffectDTO> GetCharacterSetEffect(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/set-effect";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 4, 20))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterSetEffectDTO>(path, query);
        }

        /// <summary>
        /// Retrieves information about equipped hair, face, and skin.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        public override Task<CharacterBeautyEquipmentDTO> GetCharacterBeautyEquipment(string ocid)
        {
            return GetCharacterBeautyEquipment(ocid, null);
        }

        /// <summary>
        /// Retrieves information about equipped hair, face, and skin.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        /// <param name="dateTimeOffset">Reference date for query (SGT)</param>
        public override async Task<CharacterBeautyEquipmentDTO> GetCharacterBeautyEquipment(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/beauty-equipment";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 4, 20))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterBeautyEquipmentDTO>(path, query);
        }

        /// <summary>
        /// Retrieves equipped android information.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        public override Task<CharacterAndroidEquipmentDTO> GetCharacterAndroidEquipment(string ocid)
        {
            return GetCharacterAndroidEquipment(ocid, null);
        }

        /// <summary>
        /// Retrieves equipped android information.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        /// <param name="dateTimeOffset">Reference date for query (SGT)</param>
        public override async Task<CharacterAndroidEquipmentDTO> GetCharacterAndroidEquipment(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/android-equipment";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 4, 20))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterAndroidEquipmentDTO>(path, query);
        }

        /// <summary>
        /// Retrieves information about equipped pets, including pet skills and equipment.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        public override Task<CharacterPetEquipmentDTO> GetCharacterPetEquipment(string ocid)
        {
            return GetCharacterPetEquipment(ocid, null);
        }

        /// <summary>
        /// Retrieves information about equipped pets, including pet skills and equipment.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        /// <param name="dateTimeOffset">Reference date for query (SGT)</param>
        public override async Task<CharacterPetEquipmentDTO> GetCharacterPetEquipment(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/pet-equipment";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 4, 20))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterPetEquipmentDTO>(path, query);
        }

        /// <summary>
        /// Retrieves information about character skills and Hyper Skills.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        /// <param name="characterSkillGrade">Job advancement tier to query
        /// <para>0: 0th job skills and Zero shared skills</para>
        /// <para>1: 1st job skills</para>
        /// <para>1.5: 1.5th job skills</para>
        /// <para>2: 2nd job skills</para>
        /// <para>2.5: 2.5th job skills</para>
        /// <para>3: 3rd job skills</para>
        /// <para>4: 4th job skills and Zero Alpha/Beta skills</para>
        /// <para>hyperpassive: Hyper passive skills</para>
        /// <para>hyperactive: Hyper active skills</para>
        /// <para>5: 5th job skills</para>
        /// <para>6: 6th job skills</para>
        /// </param>
        public override Task<CharacterSkillDTO> GetCharacterSkill(string ocid, string characterSkillGrade)
        {
            return GetCharacterSkill(ocid, characterSkillGrade, null);
        }

        /// <summary>
        /// Retrieves information about character skills and Hyper Skills.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        /// <param name="characterSkillGrade">Job advancement tier to query
        /// <para>0: 0th job skills and Zero shared skills</para>
        /// <para>1: 1st job skills</para>
        /// <para>1.5: 1.5th job skills</para>
        /// <para>2: 2nd job skills</para>
        /// <para>2.5: 2.5th job skills</para>
        /// <para>3: 3rd job skills</para>
        /// <para>4: 4th job skills and Zero Alpha/Beta skills</para>
        /// <para>hyperpassive: Hyper passive skills</para>
        /// <para>hyperactive: Hyper active skills</para>
        /// <para>5: 5th job skills</para>
        /// <para>6: 6th job skills</para>
        /// </param>
        /// <param name="dateTimeOffset">Reference date for query (SGT)</param>

        public override async Task<CharacterSkillDTO> GetCharacterSkill(string ocid, string characterSkillGrade, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/skill";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 4, 20))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date },
                { "character_skill_grade", characterSkillGrade }
            };

            return await Get<CharacterSkillDTO>(path, query);
        }

        /// <summary>
        /// Retrieves information about equipped Link Skills.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        public override Task<CharacterLinkSkillDTO> GetCharacterLinkSkill(string ocid)
        {
            return GetCharacterLinkSkill(ocid, null);
        }

        /// <summary>
        /// Retrieves information about equipped Link Skills.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        /// <param name="dateTimeOffset">Reference date for query (SGT)</param>
        public override async Task<CharacterLinkSkillDTO> GetCharacterLinkSkill(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/link-skill";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 4, 20))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterLinkSkillDTO>(path, query);
        }

        /// <summary>
        /// Retrieves V Matrix slot and equipped Node information.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        public override Task<CharacterVMatrixDTO> GetCharacterVMatrix(string ocid)
        {
            return GetCharacterVMatrix(ocid, null);
        }

        /// <summary>
        /// Retrieves V Matrix slot and equipped Node information.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        /// <param name="dateTimeOffset">Reference date for query (SGT)</param>
        public override async Task<CharacterVMatrixDTO> GetCharacterVMatrix(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/vmatrix";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 4, 20))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterVMatrixDTO>(path, query);
        }

        /// <summary>
        /// Retrieves information about HEXA Nodes equipped in the HEXA Matrix.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        public override Task<CharacterHexaMatrixDTO> GetCharacterHexaMatrix(string ocid)
        {
            return GetCharacterHexaMatrix(ocid, null);
        }

        /// <summary>
        /// Retrieves information about HEXA Nodes equipped in the HEXA Matrix.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        /// <param name="dateTimeOffset">Reference date for query (SGT)</param>
        public override async Task<CharacterHexaMatrixDTO> GetCharacterHexaMatrix(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/hexamatrix";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 4, 20))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterHexaMatrixDTO>(path, query);
        }

        /// <summary>
        /// Retrieves information about HEXA stats configured in the HEXA Matrix.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        public override Task<CharacterHexaMatrixStatDTO> GetCharacterHexaMatrixStat(string ocid)
        {
            return GetCharacterHexaMatrixStat(ocid, null);
        }

        /// <summary>
        /// Retrieves information about HEXA stats configured in the HEXA Matrix.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        /// <param name="dateTimeOffset">Reference date for query (SGT)</param>
        public override async Task<CharacterHexaMatrixStatDTO> GetCharacterHexaMatrixStat(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/hexamatrix-stat";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 4, 20))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterHexaMatrixStatDTO>(path, query);
        }

        /// <summary>
        /// Retrieves the character's highest record information in Mu Lung Garden.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        public override Task<CharacterDojangDTO> GetCharacterDojang(string ocid)
        {
            return GetCharacterDojang(ocid, null);
        }

        /// <summary>
        /// Retrieves the character's highest record information in Mu Lung Garden.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        /// <param name="dateTimeOffset">Reference date for query (SGT)</param>
        public override async Task<CharacterDojangDTO> GetCharacterDojang(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/dojang";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 4, 20))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterDojangDTO>(path, query);
        }

        #endregion

        #region Union Information Retrieval

        /// <summary>
        /// Retrieves Union level and Union rank information.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        public override Task<UnionDTO> GetUnion(string ocid)
        {
            return GetUnion(ocid, null);
        }

        /// <summary>
        /// Retrieves Union level and Union rank information.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        /// <param name="dateTimeOffset">Reference date for query (SGT)</param>
        public override async Task<UnionDTO> GetUnion(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/user/union";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 4, 20))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<UnionDTO>(path, query);
        }

        /// <summary>
        /// Retrieves detailed information about raid member effects and capture effects deployed in the Union.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        public override Task<UnionRaiderDTO> GetUnionRaider(string ocid)
        {
            return GetUnionRaider(ocid, null);
        }

        /// <summary>
        /// Retrieves detailed information about raid member effects and capture effects deployed in the Union.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        /// <param name="dateTimeOffset">Reference date for query (SGT)</param>
        public override async Task<UnionRaiderDTO> GetUnionRaider(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/user/union-raider";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 4, 20))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<UnionRaiderDTO>(path, query);
        }

        /// <summary>
        /// Retrieves Union Artifact information.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        public override Task<UnionArtifactDTO> GetUnionArtifact(string ocid)
        {
            return GetUnionArtifact(ocid, null);
        }

        /// <summary>
        /// Retrieves Union Artifact information.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// </summary>
        /// <param name="ocid">Character identifier</param>
        /// <param name="dateTimeOffset">Reference date for query (SGT)</param>
        public override async Task<UnionArtifactDTO> GetUnionArtifact(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/user/union-artifact";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 4, 20))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<UnionArtifactDTO>(path, query);
        }

        #endregion

        #region Guild Information Retrieval

        /// <summary>
        /// Retrieves information for the guild identifier (oguild_id).
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="guildName">Guild name</param>
        /// <param name="wolrdName">World name</param>
        public override async Task<GuildDTO> GetGuild(string guildName, string wolrdName)
        {
            var path = $"{subUrl}/v1/guild/id";
            var query = new Dictionary<string, string?>()
            {
                { "guild_name", guildName },
                { "world_name", wolrdName }
            };

            return await Get<GuildDTO>(path, query);
        }

        /// <summary>
        /// Retrieves guild basic information.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="oGuildId">Guild identifier</param>
        public override Task<GuildBasicDTO> GetGuildBasic(string oGuildId)
        {
            return GetGuildBasic(oGuildId, null);
        }

        /// <summary>
        /// Retrieves guild basic information.
        /// <para>- MapleStory game data can be verified approximately 15 minutes after updates.</para>
        /// <para>- Data is available starting from April 20, 2025.</para>
        /// <para>- Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)</para>
        /// <para>- Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.</para>
        /// <para>- This API provides data for MapleStory SEA.</para>
        /// </summary>
        /// <param name="oGuildId">Guild identifier</param>
        /// <param name="dateTimeOffset">Reference date for query (SGT)</param>
        public override async Task<GuildBasicDTO> GetGuildBasic(string oGuildId, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/guild/basic";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 4, 20))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "oguild_id", oGuildId },
                { "date", date }
            };

            return await Get<GuildBasicDTO>(path, query);
        }

        #endregion
    }

    public abstract class MapleStoryAPIInherit : Base.MapleStoryAPI<
        CharacterDTO,
        CharacterBasicDTO,
        CharacterImageDTO,
        CharacterPopularityDTO,
        CharacterStatDTO,
        CharacterHyperStatDTO,
        CharacterPropensityDTO,
        CharacterAbilityDTO,
        CharacterItemEquipmentDTO,
        CharacterCashItemEquipmentDTO,
        CharacterSymbolEquipmentDTO,
        CharacterSetEffectDTO,
        CharacterBeautyEquipmentDTO,
        CharacterAndroidEquipmentDTO,
        CharacterPetEquipmentDTO,
        CharacterSkillDTO,
        CharacterLinkSkillDTO,
        CharacterVMatrixDTO,
        CharacterHexaMatrixDTO,
        CharacterHexaMatrixStatDTO,
        CharacterDojangDTO,
        UnionDTO,
        UnionRaiderDTO,
        UnionArtifactDTO,
        GuildDTO,
        GuildBasicDTO>
    {
        public MapleStoryAPIInherit(string apiKey, string subUrl, int timezoneOffset) : base(apiKey, subUrl, timezoneOffset)
        {

        }
    }
}
