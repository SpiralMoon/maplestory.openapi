using System.Text.Json;

namespace MapleStory.Test
{
    public static class Utils
    {
        public static string ToJson(this object obj)
        {
            return JsonSerializer.Serialize(obj, new JsonSerializerOptions { WriteIndented = true });
        }
    }
}
