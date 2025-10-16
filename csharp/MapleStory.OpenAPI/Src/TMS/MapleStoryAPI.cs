using MapleStory.OpenAPI.TMS.DTO;
using MapleStory.OpenAPI.TMS.Param;
using Base = MapleStory.OpenAPI.Common;

namespace MapleStory.OpenAPI.TMS
{
    /// <summary>
    /// MapleStory OpenAPI client for TMS.
    /// <para>This is an implementation of <a href="https://openapi.nexon.com/game/maplestorytw">MapleStory API</a></para>
    /// </summary>
    public class MapleStoryAPI : MapleStoryAPIInherit
    {
        public MapleStoryAPI(string apiKey): base(apiKey, "maplestorytw", 480)
        {
            
        }

        #region Character Information Retrieval

        /// <summary>
        /// 檢視角色辨識器 (OCID)。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="characterName">角色名稱</param>
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
        /// 檢視基本資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        public override Task<CharacterBasicDTO> GetCharacterBasic(string ocid)
        {
            return GetCharacterBasic(ocid, null);
        }

        /// <summary>
        /// 檢視基本資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        /// <param name="dateTimeOffset">要搜尋的日期 (TST)</param>
        public override async Task<CharacterBasicDTO> GetCharacterBasic(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/basic";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 10, 15))
                : null;

            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterBasicDTO>(path, query);
        }

        /// <summary>
        /// 檢視角色外型圖片資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        public override Task<CharacterImageDTO> GetCharacterImage(string ocid)
        {
            return GetCharacterImage(ocid, new CharacterImageOption(), null);
        }

        /// <summary>
        /// 檢視角色外型圖片資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        /// <param name="imageOption">圖像選項</param>
        public override Task<CharacterImageDTO> GetCharacterImage(string ocid, CharacterImageOption imageOption)
        {
            return GetCharacterImage(ocid, imageOption, null);
        }

        /// <summary>
        /// 檢視角色外型圖片資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        /// <param name="imageOption">圖像選項</param>
        /// <param name="dateTimeOffset">要搜尋的日期 (TST)</param>
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
        /// 檢視名聲資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        public override Task<CharacterPopularityDTO> GetCharacterPopularity(string ocid)
        {
            return GetCharacterPopularity(ocid, null);
        }

        /// <summary>
        /// 檢視名聲資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        /// <param name="dateTimeOffset">要搜尋的日期 (TST)</param>
        public override async Task<CharacterPopularityDTO> GetCharacterPopularity(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/popularity";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 10, 15))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterPopularityDTO>(path, query);
        }

        /// <summary>
        /// 檢視綜合能力值資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        public override Task<CharacterStatDTO> GetCharacterStat(string ocid)
        {
            return GetCharacterStat(ocid, null);
        }

        /// <summary>
        /// 檢視綜合能力值資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        /// <param name="dateTimeOffset">要搜尋的日期 (TST)</param>
        public override async Task<CharacterStatDTO> GetCharacterStat(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/stat";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 10, 15))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterStatDTO>(path, query);
        }

        /// <summary>
        /// 檢視極限屬性資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        public override Task<CharacterHyperStatDTO> GetCharacterHyperStat(string ocid)
        {
            return GetCharacterHyperStat(ocid, null);
        }

        /// <summary>
        /// 檢視極限屬性資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        /// <param name="dateTimeOffset">要搜尋的日期 (TST)</param>
        public override async Task<CharacterHyperStatDTO> GetCharacterHyperStat(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/hyper-stat";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 10, 15))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterHyperStatDTO>(path, query);
        }

        /// <summary>
        /// 檢視性向資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        public override Task<CharacterPropensityDTO> GetCharacterPropensity(string ocid)
        {
            return GetCharacterPropensity(ocid, null);
        }

        /// <summary>
        /// 檢視性向資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        /// <param name="dateTimeOffset">要搜尋的日期 (TST)</param>
        public override async Task<CharacterPropensityDTO> GetCharacterPropensity(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/propensity";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 10, 15))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterPropensityDTO>(path, query);
        }

        /// <summary>
        /// 檢視能力資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        public override Task<CharacterAbilityDTO> GetCharacterAbility(string ocid)
        {
            return GetCharacterAbility(ocid, null);
        }

        /// <summary>
        /// 檢視能力資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        /// <param name="dateTimeOffset">要搜尋的日期 (TST)</param>
        public override async Task<CharacterAbilityDTO> GetCharacterAbility(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/ability";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 10, 15))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterAbilityDTO>(path, query);
        }

        /// <summary>
        /// 檢視已裝備道具資訊 (不含現金道具)。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        public override Task<CharacterItemEquipmentDTO> GetCharacterItemEquipment(string ocid)
        {
            return GetCharacterItemEquipment(ocid, null);
        }

        /// <summary>
        /// 檢視已裝備道具資訊 (不含現金道具)。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        /// <param name="dateTimeOffset">要搜尋的日期 (TST)</param>
        public override async Task<CharacterItemEquipmentDTO> GetCharacterItemEquipment(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/item-equipment";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 10, 15))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterItemEquipmentDTO>(path, query);
        }

        /// <summary>
        /// 檢視已裝備現金道具資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        public override Task<CharacterCashItemEquipmentDTO> GetCharacterCashItemEquipment(string ocid)
        {
            return GetCharacterCashItemEquipment(ocid, null);
        }

        /// <summary>
        /// 檢視已裝備現金道具資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        /// <param name="dateTimeOffset">要搜尋的日期 (TST)</param>
        public override async Task<CharacterCashItemEquipmentDTO> GetCharacterCashItemEquipment(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/cashitem-equipment";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 10, 15))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterCashItemEquipmentDTO>(path, query);
        }

        /// <summary>
        /// 檢視已裝備符文資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        public override Task<CharacterSymbolEquipmentDTO> GetCharacterSymbolEquipment(string ocid)
        {
            return GetCharacterSymbolEquipment(ocid, null);
        }

        /// <summary>
        /// 檢視已裝備符文資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        /// <param name="dateTimeOffset">要搜尋的日期 (TST)</param>
        public override async Task<CharacterSymbolEquipmentDTO> GetCharacterSymbolEquipment(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/symbol-equipment";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 10, 15))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterSymbolEquipmentDTO>(path, query);
        }

        /// <summary>
        /// 檢視目前套用的套裝效果資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        public override Task<CharacterSetEffectDTO> GetCharacterSetEffect(string ocid)
        {
            return GetCharacterSetEffect(ocid, null);
        }

        /// <summary>
        /// 檢視目前套用的套裝效果資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        /// <param name="dateTimeOffset">要搜尋的日期 (TST)</param>
        public override async Task<CharacterSetEffectDTO> GetCharacterSetEffect(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/set-effect";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 10, 15))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterSetEffectDTO>(path, query);
        }

        /// <summary>
        /// 檢視目前已裝備的髮型、臉型與膚色資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        public override Task<CharacterBeautyEquipmentDTO> GetCharacterBeautyEquipment(string ocid)
        {
            return GetCharacterBeautyEquipment(ocid, null);
        }

        /// <summary>
        /// 檢視目前已裝備的髮型、臉型與膚色資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        /// <param name="dateTimeOffset">要搜尋的日期 (TST)</param>
        public override async Task<CharacterBeautyEquipmentDTO> GetCharacterBeautyEquipment(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/beauty-equipment";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 10, 15))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterBeautyEquipmentDTO>(path, query);
        }

        /// <summary>
        /// 檢視已裝備機器人資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        public override Task<CharacterAndroidEquipmentDTO> GetCharacterAndroidEquipment(string ocid)
        {
            return GetCharacterAndroidEquipment(ocid, null);
        }

        /// <summary>
        /// 檢視已裝備機器人資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        /// <param name="dateTimeOffset">要搜尋的日期 (TST)</param>
        public override async Task<CharacterAndroidEquipmentDTO> GetCharacterAndroidEquipment(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/android-equipment";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 10, 15))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterAndroidEquipmentDTO>(path, query);
        }

        /// <summary>
        /// 檢視已裝備寵物、寵物技能與寵物道具資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        public override Task<CharacterPetEquipmentDTO> GetCharacterPetEquipment(string ocid)
        {
            return GetCharacterPetEquipment(ocid, null);
        }

        /// <summary>
        /// 檢視已裝備寵物、寵物技能與寵物道具資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        /// <param name="dateTimeOffset">要搜尋的日期 (TST)</param>
        public override async Task<CharacterPetEquipmentDTO> GetCharacterPetEquipment(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/pet-equipment";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 10, 15))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterPetEquipmentDTO>(path, query);
        }

        /// <summary>
        /// 檢視角色技能與超技能資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        /// <param name="characterSkillGrade">您要檢視的轉職階段 <a href="https://openapi.nexon.com/game/maplestorytw/?id=49">Available values</a></param>
        public override Task<CharacterSkillDTO> GetCharacterSkill(string ocid, string characterSkillGrade)
        {
            return GetCharacterSkill(ocid, characterSkillGrade, null);
        }

        /// <summary>
        /// 檢視角色技能與超技能資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        /// <param name="characterSkillGrade">您要檢視的轉職階段 <a href="https://openapi.nexon.com/game/maplestorytw/?id=49">Available values</a></param>
        /// <param name="dateTimeOffset">要搜尋的日期 (TST)</param>

        public override async Task<CharacterSkillDTO> GetCharacterSkill(string ocid, string characterSkillGrade, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/skill";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 10, 15))
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
        /// 檢視已裝備連結技能資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        public override Task<CharacterLinkSkillDTO> GetCharacterLinkSkill(string ocid)
        {
            return GetCharacterLinkSkill(ocid, null);
        }

        /// <summary>
        /// 檢視已裝備連結技能資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        /// <param name="dateTimeOffset">要搜尋的日期 (TST)</param>
        public override async Task<CharacterLinkSkillDTO> GetCharacterLinkSkill(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/link-skill";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 10, 15))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterLinkSkillDTO>(path, query);
        }

        /// <summary>
        /// 檢視 V 矩陣欄位資訊與已裝備 V 核心資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        public override Task<CharacterVMatrixDTO> GetCharacterVMatrix(string ocid)
        {
            return GetCharacterVMatrix(ocid, null);
        }

        /// <summary>
        /// 檢視 V 矩陣欄位資訊與已裝備 V 核心資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        /// <param name="dateTimeOffset">要搜尋的日期 (TST)</param>
        public override async Task<CharacterVMatrixDTO> GetCharacterVMatrix(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/vmatrix";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 10, 15))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterVMatrixDTO>(path, query);
        }

        /// <summary>
        /// 檢視已裝備於 HEXA 矩陣的 HEXA 核心資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        public override Task<CharacterHexaMatrixDTO> GetCharacterHexaMatrix(string ocid)
        {
            return GetCharacterHexaMatrix(ocid, null);
        }

        /// <summary>
        /// 檢視已裝備於 HEXA 矩陣的 HEXA 核心資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        /// <param name="dateTimeOffset">要搜尋的日期 (TST)</param>
        public override async Task<CharacterHexaMatrixDTO> GetCharacterHexaMatrix(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/hexamatrix";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 10, 15))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterHexaMatrixDTO>(path, query);
        }

        /// <summary>
        /// 檢視設定於 HEXA 矩陣中的 HEXA 屬性資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        public override Task<CharacterHexaMatrixStatDTO> GetCharacterHexaMatrixStat(string ocid)
        {
            return GetCharacterHexaMatrixStat(ocid, null);
        }

        /// <summary>
        /// 檢視設定於 HEXA 矩陣中的 HEXA 屬性資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        /// <param name="dateTimeOffset">要搜尋的日期 (TST)</param>
        public override async Task<CharacterHexaMatrixStatDTO> GetCharacterHexaMatrixStat(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/hexamatrix-stat";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 10, 15))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterHexaMatrixStatDTO>(path, query);
        }

        /// <summary>
        /// 檢視角色在武陵道場的最高紀錄資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        public override Task<CharacterDojangDTO> GetCharacterDojang(string ocid)
        {
            return GetCharacterDojang(ocid, null);
        }

        /// <summary>
        /// 檢視角色在武陵道場的最高紀錄資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        /// <param name="dateTimeOffset">要搜尋的日期 (TST)</param>
        public override async Task<CharacterDojangDTO> GetCharacterDojang(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/dojang";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 10, 15))
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
        /// 檢視戰地等級與戰地階級資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        public override Task<UnionDTO> GetUnion(string ocid)
        {
            return GetUnion(ocid, null);
        }

        /// <summary>
        /// 檢視戰地等級與戰地階級資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        /// <param name="dateTimeOffset">要搜尋的日期 (TST)</param>
        public override async Task<UnionDTO> GetUnion(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/user/union";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 10, 15))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<UnionDTO>(path, query);
        }

        /// <summary>
        /// 檢視詳細資訊，例如派遣至聯盟的攻擊單位成員效果，以及攻擊單位佔領效果。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        public override Task<UnionRaiderDTO> GetUnionRaider(string ocid)
        {
            return GetUnionRaider(ocid, null);
        }

        /// <summary>
        /// 檢視詳細資訊，例如派遣至聯盟的攻擊單位成員效果，以及攻擊單位佔領效果。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        /// <param name="dateTimeOffset">要搜尋的日期 (TST)</param>
        public override async Task<UnionRaiderDTO> GetUnionRaider(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/user/union-raider";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 10, 15))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<UnionRaiderDTO>(path, query);
        }

        /// <summary>
        /// 檢視戰地神器資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        public override Task<UnionArtifactDTO> GetUnionArtifact(string ocid)
        {
            return GetUnionArtifact(ocid, null);
        }

        /// <summary>
        /// 檢視戰地神器資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="ocid">角色辨識器</param>
        /// <param name="dateTimeOffset">要搜尋的日期 (TST)</param>
        public override async Task<UnionArtifactDTO> GetUnionArtifact(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/user/union-artifact";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 10, 15))
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
        /// 檢視公會識別碼 (oguild_id) 資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
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
        /// 檢視公會基本資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="oGuildId">Guild identifier</param>
        public override Task<GuildBasicDTO> GetGuildBasic(string oGuildId)
        {
            return GetGuildBasic(oGuildId, null);
        }

        /// <summary>
        /// 檢視公會基本資訊。
        /// <para>- 楓之谷遊戲資料平均在 15 分鐘後即可使用。</para>
        /// <para>- 您可以從 2025 年 10 月 15 日起搜尋資料。</para>
        /// <para>- 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)</para>
        /// <para>- 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。</para>
        /// <para>- 此 API 提供來自楓之谷台灣的資料。</para>
        /// </summary>
        /// <param name="oGuildId">Guild identifier</param>
        /// <param name="dateTimeOffset">要搜尋的日期 (TST)</param>
        public override async Task<GuildBasicDTO> GetGuildBasic(string oGuildId, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/guild/basic";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2025, 10, 15))
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
        GuildBasicDTO,
        CharacterImageOption>
    {
        public MapleStoryAPIInherit(string apiKey, string subUrl, int timezoneOffset) : base(apiKey, subUrl, timezoneOffset)
        {

        }
    }
}
