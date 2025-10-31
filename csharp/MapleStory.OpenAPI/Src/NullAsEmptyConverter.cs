using Newtonsoft.Json;
using Newtonsoft.Json.Linq;

namespace MapleStory.OpenAPI
{
    /// <summary>
    /// Represents a JSON converter that deserializes null values into empty collections.
    /// </summary>
    /// <remarks>
    /// This converter is typically applied to properties of type <see cref="System.Collections.Generic.List{T}"/>
    /// to ensure that a null JSON array or object results in an empty list rather than a null reference.
    ///
    /// Usage example:
    /// <code>
    /// public class MyClass
    /// {
    ///     [JsonProperty("items")]
    ///     [JsonConverter(typeof(NullAsEmptyConverter))]
    ///     public List&lt;string&gt; Items { get; set; } = new();
    /// }
    /// </code>
    /// </remarks>
    public class NullAsEmptyConverter : JsonConverter
    {
        public override bool CanConvert(Type objectType)
        {
            return objectType.GetInterfaces().Any(i => i.IsGenericType && i.GetGenericTypeDefinition() == typeof(ICollection<>));
        }

        public override bool CanWrite => false;

        public override object? ReadJson(JsonReader reader, Type objectType, object? existingValue, JsonSerializer serializer)
        {
            if (reader.TokenType == JsonToken.Null)
            {
                if (objectType.IsInterface)
                {
                    return Activator.CreateInstance(typeof(List<>).MakeGenericType(objectType.GetGenericArguments()));
                }

                return Activator.CreateInstance(objectType);
            }

            JToken token = JToken.Load(reader);
            return token.ToObject(objectType, serializer);
        }

        public override void WriteJson(JsonWriter writer, object value, JsonSerializer serializer)
        {
            throw new NotImplementedException();
        }
    }
}
