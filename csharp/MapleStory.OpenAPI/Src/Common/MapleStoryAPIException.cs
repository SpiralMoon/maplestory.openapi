namespace MapleStory.OpenAPI.Common
{
    /// <summary>
    /// MapleStory OpenAPI exception.
    /// <para>Please refer to <a href="https://openapi.nexon.com/guide/request-api">MapleStory API guide</a> for the exception details.</para>
    /// </summary>
    public class MapleStoryAPIException: Exception
    {
        public new string Message { get; }

        public MapleStoryAPIErrorCode ErrorCode { get; }

        internal MapleStoryAPIException(MapleStoryAPIErrorCode errorCode, string message): base(message)
        {
            Message = message;
            ErrorCode = errorCode;
        }

        internal MapleStoryAPIException(MapleStoryAPIErrorBody errorBody) : base(errorBody.Error.Message)
        {
            var error = errorBody.Error;

            Message = error.Message;
            ErrorCode = FromString(error.Name);
        }

        internal static MapleStoryAPIErrorCode FromString(string name)
        {
            var errorMap = new Dictionary<string, MapleStoryAPIErrorCode>
            {
                { "OPENAPI00001", MapleStoryAPIErrorCode.OPENAPI00001 },
                { "OPENAPI00002", MapleStoryAPIErrorCode.OPENAPI00002 },
                { "OPENAPI00003", MapleStoryAPIErrorCode.OPENAPI00003 },
                { "OPENAPI00004", MapleStoryAPIErrorCode.OPENAPI00004 },
                { "OPENAPI00005", MapleStoryAPIErrorCode.OPENAPI00005 },
                { "OPENAPI00006", MapleStoryAPIErrorCode.OPENAPI00006 },
                { "OPENAPI00007", MapleStoryAPIErrorCode.OPENAPI00007 },
                { "OPENAPI00009", MapleStoryAPIErrorCode.OPENAPI00009 },
                { "OPENAPI00010", MapleStoryAPIErrorCode.OPENAPI00010 },
                { "OPENAPI00011", MapleStoryAPIErrorCode.OPENAPI00011 },
            };

            if (errorMap.TryGetValue(name, out MapleStoryAPIErrorCode errorCode))
            {
                return errorCode;
            }
            else
            {
                throw new ArgumentException("No enum constant for string: " + name);
            }
        }
    }

    /// <summary>
    /// MapleStory OpenAPI error codes.
    /// <para>Please refer to <a href="https://openapi.nexon.com/guide/request-api">MapleStory API guide</a> for the error code details.</para>
    /// </summary>

    public enum MapleStoryAPIErrorCode
    {
        OPENAPI00001,
        OPENAPI00002,
        OPENAPI00003,
        OPENAPI00004,
        OPENAPI00005,
        OPENAPI00006,
        OPENAPI00007,
        OPENAPI00009,
        OPENAPI00010,
        OPENAPI00011,
    }
}
