# Migration

> 💡 There are a few simple changes introduced in this version upgrade. If you're using a previous version, we recommend following the guide below to migrate smoothly.

## 2.x.x to 3.0.0

### Changed namespace

Starting from version 3.0.0, support for multiple service regions has been added. To achieve this, common logic has been abstracted into interfaces, and API classes as well as response types have been split by region and implemented accordingly.

You now need to include the region identifier in the namespace when importing classes related to a specific region.

```csharp
using MapleStory.OpenAPI;

// Update to:

using MapleStory.OpenAPI.KMS;
```

Common elements and abstract interfaces shared across all regions are provided via `MapleStory.OpenAPI.Common`

```csharp
using MapleStory.OpenAPI.Common; // Abstract API base class, Common error class
using MapleStory.OpenAPI.Common.DTO; // Abstract character response DTO
using MapleStory.OpenAPI.Common.Enum; // Enum used as API parameters
```