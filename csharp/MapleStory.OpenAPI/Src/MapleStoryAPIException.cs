namespace MapleStory.OpenAPI
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
            this.Message = message;
            this.ErrorCode = errorCode;
        }

        internal MapleStoryAPIException(MapleStoryAPIErrorBody errorBody) : base(errorBody.Error.Message)
        {
            var error = errorBody.Error;

            this.Message = error.Message;
            this.ErrorCode = FromString(error.Name);
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
    }
}