using MapleStory.OpenAPI;

var apiKey = "{Your API Key}";
var api = new MapleStoryAPI(apiKey);

// run your code
try
{
    var response = await api.GetCubeResult(1000, 2023, 10, 15);

    var count = response.Count;
    var cubeHistories = response.CubeHistories;
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