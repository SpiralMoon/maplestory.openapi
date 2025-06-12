using NUnit.Framework;
using MapleStory.OpenAPI.KMS;

namespace MapleStory.Test
{
    [TestFixture]
    public class CharacterAPI
    {
        private static readonly string apiKey = Environment.GetEnvironmentVariable("API_KEY")!; // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);
        private static readonly string ocid = "e0a4f439e53c369866b55297d2f5f4eb";

        [Test]
        public async Task GetCharacter()
        {
            var nickname = "아델";
            var response = await api.GetCharacter(nickname);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetCharacterList()
        {
            var response = await api.GetCharacterList();
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetCharacterBasic()
        {
            var response = await api.GetCharacterBasic(ocid);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetCharacterImage()
        {
            var response = await api.GetCharacterImage(ocid);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetCharacterPopularity()
        {
            var response = await api.GetCharacterPopularity(ocid);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetCharacterStat()
        {
            var response = await api.GetCharacterStat(ocid);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetCharacterHyperStat()
        {
            var response = await api.GetCharacterHyperStat(ocid);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetCharacterPropensity()
        {
            var response = await api.GetCharacterPropensity(ocid);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetCharacterAbility()
        {
            var response = await api.GetCharacterAbility(ocid);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetCharacterItemEquipment()
        {
            var response = await api.GetCharacterItemEquipment(ocid);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetCharacterCashItemEquipment()
        {
            var response = await api.GetCharacterCashItemEquipment(ocid);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetCharacterSymbolEquipment()
        {
            var response = await api.GetCharacterSymbolEquipment(ocid);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetCharacterSetEffect()
        {
            var response = await api.GetCharacterSetEffect(ocid);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetCharacterBeautyEquipment()
        {
            var response = await api.GetCharacterBeautyEquipment(ocid);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetCharacterAndroidEquipment()
        {
            var response = await api.GetCharacterAndroidEquipment(ocid);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetCharacterPetEquipment()
        {
            var response = await api.GetCharacterPetEquipment(ocid);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetCharacterSkill()
        {
            var skillGrade = "0";
            var response = await api.GetCharacterSkill(ocid, skillGrade);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetCharacterLinkSkill()
        {
            var response = await api.GetCharacterLinkSkill(ocid);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetCharacterVMatrix()
        {
            var response = await api.GetCharacterVMatrix(ocid);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetCharacterHexaMatrix()
        {
            var response = await api.GetCharacterHexaMatrix(ocid);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetCharacterHexaMatrixStat()
        {
            var response = await api.GetCharacterHexaMatrixStat(ocid);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetCharacterDojang()
        {
            var response = await api.GetCharacterDojang(ocid);
            Console.WriteLine(response.ToJson());
        }
    }
}
