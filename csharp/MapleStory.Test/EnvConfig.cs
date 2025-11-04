using Microsoft.Extensions.Configuration;

namespace MapleStory.Test
{
    public class EnvConfig
    {
        private static IConfigurationRoot Configuration = new ConfigurationBuilder()
            .SetBasePath(Directory.GetCurrentDirectory())
            .AddJsonFile("appsettings.Local.json", optional: true)
            .AddEnvironmentVariables()
            .Build();

        public static string Get(string key)
        {
            return Configuration[key] ?? throw new InvalidOperationException($"{key} not found.");
        }
    }
}
