using Newtonsoft.Json;

namespace MapleStory.OpenAPI
{
    /// <summary>
    /// 
    /// </summary>
    public class DefaultValueConverter<T> : JsonConverter<T>
    {
        private readonly T _defaultValue;

        public DefaultValueConverter(T defaultValue)
        {
            _defaultValue = defaultValue;
        }

        public override T ReadJson(JsonReader reader, Type objectType, T existingValue, bool hasExistingValue, JsonSerializer serializer)
        {
            if (reader.TokenType == JsonToken.Null)
            {
                return _defaultValue;
            }

            if (reader.Value == null)
            {
                return _defaultValue;
            }

            return (T)Convert.ChangeType(reader.Value, typeof(T));
        }

        public override void WriteJson(JsonWriter writer, T value, JsonSerializer serializer)
        {
            writer.WriteValue(value);
        }
    }
}
