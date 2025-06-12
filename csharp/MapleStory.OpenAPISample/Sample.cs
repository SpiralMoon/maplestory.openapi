using MapleStory.OpenAPI.KMS;
using MapleStory.OpenAPI.Common;

var apiKey = "{Your API Key}";
var api = new MapleStoryAPI(apiKey);
var dateTimeOffset = new DateTimeOffset(2023, 10, 15, 0, 0, 0, TimeSpan.FromHours(9));

// run your code
try
{
    var response = await api.GetCubeHistory(1000, dateTimeOffset);

    var count = response.Count;
    var cubeHistory = response.CubeHistory;
    var nextCursor = response.NextCursor;

    Console.WriteLine("You used " + count + " cubes.");
}
// exception handling
catch (MapleStoryAPIException e)
{
    // handle MapleStoryApiException
}
catch (HttpRequestException e)
{
    // handle HttpRequestException
}