namespace MapleStory.OpenAPI
{
    /// <summary>
    /// MapleStory OpenAPI exception.
    /// <para>Please refer to <a href="https://developers.nexon.com/Maplestory/guides">MapleStory API guide</a> for the exception details.</para>
    /// </summary>
    public class MapleStoryAPIException: Exception
    {
        public new string Message { get; }

        public int Status { get; }

        internal MapleStoryAPIException(MapleStoryAPIErrorBody error) : base(error.Message)
        {
            this.Message = error.Message;
            this.Status = error.Status;
        }
    }
}
